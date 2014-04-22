package auction_sniper;

import org.junit.After;
import org.junit.Test;

/**
 * Created on 4/18/2014.
 */
public class AuctionSniperEndToEndTest {
    public static final String ITEM_ID = "item-54321";
    private final FakeAuctionServer auction = new FakeAuctionServer(ITEM_ID);
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
        auction.startSellingItem(); // Step 1
        application.startBiddingIn(auction); // Step 2
        auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID); // Step 3
        auction.announceClosed(); // Step 4
        application.showsSniperHasLostAuction(); // Step 5
    }

    @Test
    public void sniperMakesAHigherBidButLoses() throws Exception {
        auction.startSellingItem(); // Step 1
        application.startBiddingIn(auction); // Step 2
        auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID); // Step 3
        auction.reportPrice(1000, 98, "other bidder");
        application.hasShownSniperIsBidding(1000, 1098);
        auction.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);
        auction.announceClosed(); // Step 4
        application.showsSniperHasLostAuction(); // Step 5
    }

    @Test
    public void sniperWinsAnAuctionByBiddingHigher() throws Exception {
        auction.startSellingItem(); // Step 1

        application.startBiddingIn(auction); // Step 2
        auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID); // Step 3

        auction.reportPrice(1000, 98, "other bidder");
        Thread.sleep(5000);
        application.hasShownSniperIsBidding(1000, 1098);

        auction.hasReceivedBid(1098, ApplicationRunner.SNIPER_XMPP_ID);

        auction.reportPrice(1098, 97, ApplicationRunner.SNIPER_XMPP_ID);
        application.hasShownSniperIsWinning(1098);

        auction.announceClosed(); // Step 4
        application.showsSniperHasWonAuction(1098); // Step 5
    }

    // Additional cleanup
    @After
    public void stopAuction() {
        auction.stop();
    }

    @After
    public void stopApplication() {
        application.stop();
    }
}

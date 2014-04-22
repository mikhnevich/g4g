package auction_sniper;

/**
 * Created on 4/18/2014.
 */
public class AuctionSniper implements AuctionEventListener {
    private final SniperListener sniperListener;
    private final Auction auction;
    private boolean isWinning = false;

    public AuctionSniper(Auction auction, SniperListener sniperListener) {
        this.sniperListener = sniperListener;
        this.auction = auction;
    }

    public void auctionClosed() {
        if (isWinning) {
            sniperListener.sniperWon();
        } else {
            sniperListener.sniperLost();
        }
    }

    @Override
    public void currentPrice(int price, int increment, PriceSource priceSource) {
        isWinning = priceSource == PriceSource.FromSniper;
        if (isWinning) {
            sniperListener.sniperWinning();
        } else {
            final int bid = price + increment;
            auction.bid(bid);
            sniperListener.sniperBidding(new SniperState(AuctionSniperEndToEndTest.ITEM_ID, price, bid));
        }
    }
}

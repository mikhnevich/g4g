package auction_sniper;

/**
 * Created on 4/18/2014.
 */
public interface AuctionEventListener {
    enum PriceSource {
        FromSniper, FromOtherBidder
    }

    void auctionClosed();

    void currentPrice(int price, int increment, PriceSource fromOtherBidder);
}

package auction_sniper;

import org.jivesoftware.smack.XMPPException;

/**
 * Created on 4/18/2014.
 */
public interface Auction {
    void bid(int price);

    void join();
}

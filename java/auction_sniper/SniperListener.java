package auction_sniper;

import java.util.EventListener;

/**
 * Created on 4/18/2014.
 */
public interface SniperListener extends EventListener {
    void sniperLost();

    void sniperBidding(SniperState sniperState);

    void sniperWinning();

    void sniperWon();

}

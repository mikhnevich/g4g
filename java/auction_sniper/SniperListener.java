package auction_sniper;

import java.util.EventListener;

/**
 * Created on 4/18/2014.
 */
public interface SniperListener extends EventListener {
    void sniperLost();

    void sniperBidding();

    void sniperWinning();

    void sniperWon();

}

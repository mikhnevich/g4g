package auction_sniper;

/**
 * Created on 4/21/2014.
 */
public class SniperState {
    public final String itemId;
    public final int lastPrice;
    public final int lastBid;

    public SniperState(String itemId, int lastPrice, int lastBid) {
        this.itemId = itemId;
        this.lastPrice = lastPrice;
        this.lastBid = lastBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SniperState that = (SniperState) o;

        if (lastBid != that.lastBid) return false;
        if (lastPrice != that.lastPrice) return false;
        if (!itemId.equals(that.itemId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + lastPrice;
        result = 31 * result + lastBid;
        return result;
    }

    @Override
    public String toString() {
        return "SniperState{" +
                "itemId='" + itemId + '\'' +
                ", lastPrice=" + lastPrice +
                ", lastBid=" + lastBid +
                '}';
    }
}

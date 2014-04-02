package union;

/**
 * Created by user @ 3/18/14 1:38 PM
 */
public class DSU {
    public final int value;
    public DSU parent;
    private int rank = 1;

    public DSU(int v) {
        this.value = v;
        parent = this;
    }

    public static DSU makeSet(int x) {
        return new DSU(x);
    }

    public void union(DSU x, DSU y) {
        DSU px = x.find();
        DSU py = y.find();
        if (px != py) {
            if (px.rank < py.rank) {
                px.parent = py;
            } else if (px.rank > py.rank) {
                py.parent = px;
            } else {
                py.parent = px;
                px.rank++;
            }
        }
    }

    public void union_no_rank(DSU x, DSU y) {
        DSU px = x.find();
        DSU py = y.find();
        if (px != py) {
            py.parent = px;
        }
    }

    public DSU find() {
        if (parent != this)
            parent = parent.find();
        return parent;
    }
}

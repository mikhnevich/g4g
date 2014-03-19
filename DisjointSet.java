/**
 * Created by sm84878 @ 2/7/14 2:23 PM
 */
public class DisjointSet {
    public DisjointSet parent;
    public int rank;
    public final int row;
    public final int col;

    public DisjointSet(int row, int col, int rank) {
        this.row = row;
        this.col = col;
        this.rank = rank;
        this.parent = this;
    }

    public static DisjointSet createSet(int row, int col) {
        return new DisjointSet(row, col, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisjointSet that = (DisjointSet) o;

        if (row != that.row) return false;
        if (col != that.col) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    public static void mergeSets(DisjointSet x, DisjointSet y) {
        DisjointSet px = findSet(x);
        DisjointSet py = findSet(y);
        if (px == py) {
            return;
        }
        if (px.rank > py.rank) {
            py.setParent(px);
        } else {
            px.setParent(py);
        }
        if (px.rank == py.rank) {
            py.increaseRank();
        }
    }

    private void increaseRank() {
        rank++;
    }

    public static DisjointSet findSet(DisjointSet set) {
        if (set != set.parent) {
            set.parent = findSet(set.parent);
        }
        return set.parent;
    }

    public void setParent(DisjointSet parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "DisjointSet{" +
                "row=" + row +
                ", col=" + col +
                ", rank=" + rank +
                '}';
    }

}

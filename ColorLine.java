import union.DSU;

/**
 * Created by sm84878 @ 3/18/14 1:37 PM
 */
public class ColorLine {
    private DSU[] line;
    private int[] answer;

    public ColorLine(int size) {
        line = new DSU[size];
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            line[i] = new DSU(i);
        }
    }

    public void color(int l, int r, int c) {
        for (int v = l; ; ) {
            DSU p = line[v].find();
            if (p.value > r) {
                break;
            }
            answer[p.value] = c;
            p.parent = line[p.value + 1];
        }
    }

    public static void main(String[] args) {
        ColorLine cl = new ColorLine(10);
        cl.color(3, 6, 1);
        cl.color(4, 8, 2);
        cl.color(1, 8, 3);
        cl.printColors();
    }

    private void printColors() {
        for (int i : answer) {
            System.out.print(i);
        }
        System.out.println();
    }
}

package graph;

import array.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created @ 6/12/2014
 */
public class TriangleDGraph {

    private static final class Path {
        final Path parent;
        final int value;
        final int sum;

        private Path(Path parent, int value, int sum) {
            this.parent = parent;
            this.value = value;
            this.sum = sum;
        }
    }

    public static List<Integer> findPath(List<List<Integer>> rows) {
        Path path = findPath(new Path(null, 0, 0), 0, 0, rows);
        List<Integer> list = new ArrayList<>();
        Path current = path;
        while (current.parent != null) {
            list.add(current.value);
            current = current.parent;
        }
        return list;
    }

    public static Path findPath(Path current, int row, int column, List<List<Integer>> rows) {
        if (row >= rows.size()) {
            return current;
        }
        List<Integer> currentRow = rows.get(row);
        if (column >= currentRow.size()) {
            return current;
        }
        final int value = currentRow.get(column);
        Path left = findPath(new Path(current, value, current.sum + value), row + 1, column, rows);
        Path right = findPath(new Path(current, value, current.sum + value), row + 1, column + 1, rows);
        return max(left, right);
    }

    private static Path max(Path left, Path right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return left.sum > right.sum ? left : right;
    }

    public static List<List<Integer>> convert(int[]... rows) {
        List<List<Integer>> listRows = new ArrayList<>(rows.length);
        for (int[] row : rows) {
            List<Integer> l = new ArrayList<>(row.length);
            for (int i : row) {
                l.add(i);
            }
            listRows.add(l);
        }
        return listRows;
    }

    public static int findPathDP(List<List<Integer>> rows) {
        int[][] triangle = new int[rows.size() + 1][rows.get(rows.size() - 1).size() + 1];
        for (int i = rows.size() - 1; i >= 0; i--) {
            List<Integer> row = rows.get(i);
            for (int j = 0; j < row.size(); j++) {
                triangle[i][j] = Math.max(
                        triangle[i + 1][j] + row.get(j),
                        triangle[i + 1][j + 1] + row.get(j)
                );
            }
        }
        ArrayUtils.print(triangle);
        return triangle[0][0];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader("C:\\work\\projects\\java\\g4g\\src\\java\\graph\\triangle.txt"));
        String s = null;
        List<List<Integer>> triangle = new ArrayList<>();
        while ((s = r.readLine()) != null) {
            String[] numbers = s.split(" ");
            List<Integer> list = new ArrayList<>(numbers.length);
            for (String n : numbers) {
                list.add(Integer.parseInt(n));
            }
            triangle.add(list);
        }

        int path = findPathDP(convert(
                new int[]{5},
                new int[]{9, 6},
                new int[]{4, 6, 8},
                new int[]{0, 1, 7, 5}
        ));
        System.out.println(path);

        path = findPathDP(triangle);
        System.out.println(path);

        System.out.println(findPath(
                convert(
                        new int[]{5},
                        new int[]{9, 6},
                        new int[]{4, 6, 8},
                        new int[]{0, 1, 7, 5}
                )
        ));

    }
}

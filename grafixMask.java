import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Division 1 500 SRM211
 * http://community.topcoder.com/stat?c=problem_statement&pm=2998
 *
 * Problem Statement

 Note: This problem statement includes images that may not appear if you are using a plugin. For best results, use the Arena editor.

 In one mode of the grafix software package, the user blocks off portions of a masking layer using opaque rectangles. The bitmap used as the masking layer is 400 pixels tall and 600 pixels wide. Once the rectangles have been blocked off, the user can perform painting actions through the remaining areas of the masking layer, known as holes. To be precise, each hole is a maximal collection of contiguous pixels that are not covered by any of the opaque rectangles. Two pixels are contiguous if they share an edge, and contiguity is transitive.

 You are given a String[] named rectangles, the elements of which specify the rectangles that have been blocked off in the masking layer. Each String in rectangles consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the window coordinates of the top left pixel in the given rectangle, and the last two integers are the window coordinates of its bottom right pixel. The window coordinates of a pixel are a pair of integers specifying the row number and column number of the pixel, in that order. Rows are numbered from top to bottom, starting with 0 and ending with 399. Columns are numbered from left to right, starting with 0 and ending with 599. Every pixel within and along the border of the rectangle defined by these opposing corners is blocked off.

 Return a int[] containing the area, in pixels, of every hole in the resulting masking area, sorted from smallest area to greatest.


 Definition

 Class:	grafixMask
 Method:	sortedAreas
 Parameters:	String[]
 Returns:	int[]
 Method signature:	int[] sortedAreas(String[] rectangles)
 (be sure your method is public)


 Notes
 -	Window coordinates are not the same as Cartesian coordinates. Follow the definition given in the second paragraph of the problem statement.

 Constraints
 -	rectangles contains between 1 and 50 elements, inclusive
 -	each element of rectangles has the form "ROW COL ROW COL", where: "ROW" is a placeholder for a non-zero-padded integer between 0 and 399, inclusive; "COL" is a placeholder for a non-zero-padded integer between 0 and 599, inclusive; the first row number is no greater than the second row number; the first column number is no greater than the second column number

 Examples
 0)

 {"0 292 399 307"}
 Returns: { 116800,  116800 }
 The masking layer is depicted below in a 1:4 scale diagram.

 1)

 {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"}
 Returns: { 22816,  192608 }

 2)

 {"0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599"}
 Returns: { 22080,  22816,  22816,  23040,  23040,  23808,  23808,  23808,  23808 }

 3)

 {"50 300 199 300", "201 300 350 300", "200 50 200 299", "200 301 200 550"}
 Returns: { 1,  239199 }
 4)

 {"0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92",
 "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
 "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
 "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
 "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
 "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
 "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
 "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
 "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
 "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
 "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
 "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
 "373 0 373 599", "389 0 389 599"}
 Returns:
 { 15,  30,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  45,  100,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  115,  200,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  230,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  300,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345,  345 }

 */
public class grafixMask {
    public static final int ROW_COUNT = 400;
    public static final int COLUMN_COUNT = 600;


    private static final class Rectangle {
        int topLeftX;
        int topLeftY;
        int bottomRightX;
        int bottomRightY;

        private Rectangle(String st) {
            this(st.split(" "));
        }

        private Rectangle(String[] coordinates) {
            this(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]), Integer.parseInt(coordinates[3]));
        }


        private Rectangle(int topLeftY, int topLeftX, int bottomRightY, int bottomRightX) {
            this.topLeftX = topLeftX;
            this.topLeftY = topLeftY;
            this.bottomRightX = bottomRightX;
            this.bottomRightY = bottomRightY;
        }
    }

    public int[] sortedAreas(String[] rectangles) {
        DisjointSet[][] pixels = new DisjointSet[ROW_COUNT][COLUMN_COUNT];
        Rectangle[] masks = buildMasks(rectangles);
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COLUMN_COUNT; col++) {
                boolean isMasked = isMasked(row, col, masks);
                if (isMasked) {
                    pixels[row][col] = null;
                } else {
                    DisjointSet set = DisjointSet.createSet(row, col);
                    pixels[row][col] = set;
                    if (row > 0) {
                        DisjointSet neighbor = pixels[row - 1][col];
                        if (neighbor != null) {
                            DisjointSet.mergeSets(set, DisjointSet.findSet(neighbor));
                        }
                    }
                    if (col > 0) {
                        DisjointSet neighbor = pixels[row][col - 1];
                        if (neighbor != null) {
                            DisjointSet.mergeSets(set, DisjointSet.findSet(neighbor));
                        }
                    }
                }
            }
        }
        return sortHoles(pixels);
    }

    private int[] sortHoles(DisjointSet[][] pixels) {
        Map<DisjointSet, Integer> map = new HashMap<>();
        for (DisjointSet[] column : pixels) {
            for (DisjointSet pixel : column) {
                if (pixel != null) {
                    DisjointSet parent = DisjointSet.findSet(pixel);
                    Integer i = map.get(parent);
                    if (i == null) {
                        map.put(parent, 1);
                    } else {
                        map.put(parent, i + 1);
                    }
                }
            }
        }
        int[] result = new int[map.size()];
        int i = 0;
        for (Integer integer : map.values()) {
            result[i++] = integer;
        }
        Arrays.sort(result);
        return result;
    }

    private boolean isMasked(int row, int col, Rectangle[] masks) {
        for (Rectangle mask : masks) {
            if (row >= mask.topLeftY && row <= mask.bottomRightY && col >= mask.topLeftX && col <= mask.bottomRightX) {
                return true;
            }
        }
        return false;
    }

    private Rectangle[] buildMasks(String[] rectangles) {
        Rectangle[] result = new Rectangle[rectangles.length];
        int i = 0;
        for (String r : rectangles) {
            result[i++] = new Rectangle(r);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result;

//        result = new grafixMask().sortedAreas(new String[] {"0 3 2 5"});
//        result = new grafixMask().sortedAreas(new String[] {"0 292 399 307"});
//        result = new grafixMask().sortedAreas(new String[] {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"});
//        result = new grafixMask().sortedAreas(new String[] {"0 192 399 207", "0 392 399 407", "120 0 135 599", "260 0 275 599"});
//        result = new grafixMask().sortedAreas(new String[] {"50 300 199 300", "201 300 350 300", "200 50 200 299", "200 301 200 550"}        );
        result = new grafixMask().sortedAreas(new String[] {"0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92",
                "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
                "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
                "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
                "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
                "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
                "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
                "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
                "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
                "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
                "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
                "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
                "373 0 373 599", "389 0 389 599"}        );
        System.out.println(Arrays.toString(result));
    }
}

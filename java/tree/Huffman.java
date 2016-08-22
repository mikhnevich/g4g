package tree;

/**
 * Created by user on 8/12/2016.
 */
public class Huffman {

    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(char data) {
            this.data = data;
        }
    }

    void decode(String S, Node root) {
        int idx = 0;
        Node current = root;
        while (idx < S.length()) {
            if (current.left == null && current.right == null) {
                System.out.print(current.data);
                current = root;
            } else {
                if (S.charAt(idx) == '0') {
                    current = current.left;
                } else {
                    current = current.right;
                }
                idx++;
            }
        }
        if (current.left == null && current.right == null) {
            System.out.print(current.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(' ',
                new Node(' ',
                        new Node('B'),
                        new Node('C')
                        ),
                new Node('A')
        );
        new Huffman().decode("1001011", root);
    }
}

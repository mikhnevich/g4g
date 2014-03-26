package tree;

/**
 * Created on 3/25/2014.
 */
public class Diameter {
    public static int diameter(Node root) {
        return 0;
    }

    public static void main(String[] args) {


        Node r3 = new Node(10,
                new Node(8,
                        new Node(3),
                        new Node(5)),
                new Node(2,
                        new Node(2),
                        new Node(1)
                )
        );


        BST_Utils.printNode(r3);

        int d = diameter(r3);
        System.out.println(d);
    }
}

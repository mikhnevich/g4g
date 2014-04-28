package tree;

/**
 * Created on 3/29/2014.
 * Convert Tree -> DLL in place (modify pointers)
 * left = previous
 * right = next;
 */
public class ConvertToDll {

    public static Node convert(Node root) {
        Node converted = convertInternal(root, null);
        Node head = converted;
        while (head.left != null) {
            head = head.left;
        }
        Node tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    private static Node convertInternal(Node root, Node last) {
        Node left;
        if (root.left != null) {
            left = convertInternal(root.left, last);
            last = left;
            root.left = left;
        }
        if (last != null) {
            last.right = root;
            root.left = last;
        }

        if (root.right != null) {
            return convertInternal(root.right, root);
        }
        return root;
    }

    private static class State {
        Node head;
        Node prev;
    }

    public static Node convert2(Node root) {
        State state = new State();
        convert2(root, state);
        return state.head;
    }

    public static void convert2(Node root, State state) {
        if (root == null) {
            return;
        }
        convert2(root.left, state);
        if (state.prev == null) {
            state.head = root;
        } else {
            state.prev.right = root;
            root.left = state.prev;
        }
        state.prev = root;
        convert2(root.right, state);
    }

    public static void main(String[] args) {
        Node root2 = new Node(4,
                new Node(2,
                        new Node(1),
                        new Node(3)
                ),
                new Node(20,
                        new Node(15,
                                new Node(12,
                                        new Node(11),
                                        null
                                ),
                                new Node(17,
                                        new Node(16),
                                        null
                                )
                        ),
                        new Node(30)
                )
        );
        Node root = new Node(4,
                new Node(2,
                        new Node(1),
                        new Node(3)
                ),
                new Node(5,
                        null,
                        new Node(6)
                )
        );
        Node root2Copy = TreeUtils.copy(root2);
        Node c = convert(root2);
        Node t = c;
        do {
            System.out.print(t.value);
            System.out.print(' ');
            t = t.right;
        } while (c.value != t.value);
        System.out.println();

        Node c2 = convert2(root2Copy);
        t = c2;
        do {
            System.out.print(t.value);
            System.out.print(' ');
            t = t.right;
        } while (t != null);
        System.out.println();

    }
}

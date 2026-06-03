public class printInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.data) {
            root.left = Insert(root.left, val);
        } else {
            root.right = Insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printinrange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (k1 <= root.data && root.data <= k2) {
            printinrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinrange(root.right, k1, k2);
        } else if (k1 > root.data) {
            printinrange(root.right, k1, k2);
        } else {
            printinrange(root.left, k1, k2);
        }
    }

    public static void main(String args[]) {
        int val[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }
        inorder(root);
        System.out.println();

        printinrange(root, 5, 12);
    }
}

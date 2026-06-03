public class validateBst {
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

    public static Boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }

        return isValid(root.left, min, root)
                && isValid(root.right, root, max);

    }

    public static void main(String args[]) {
        Node root = new Node(8);

        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(9);


        if (isValid(root, null, null)) {
            System.out.print(" valid ");
        } else {
            System.out.print("invalid");
        }
    }
}

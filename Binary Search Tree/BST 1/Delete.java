public class Delete {
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

    public static Node delete(Node root, int k) {
        if (k < root.data) {
            root.left = delete(root.left, k);
        } else if (k > root.data) {
            root.right = delete(root.right, k);
        } else { // voila

            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 2childs
            Node Is = inOrderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String args[]) {
        int val[] = { 5, 1, 3, 4, 2, 7 };

        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }
        inorder(root);
        System.out.println();
        delete(root, 3);

        inorder(root);
        System.out.println();
    }

}
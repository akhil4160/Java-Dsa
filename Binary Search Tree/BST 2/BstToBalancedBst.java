import java.util.ArrayList;

public class BstToBalancedBst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void GetInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        GetInorder(root.left, inorder);
        inorder.add(root.data);
        GetInorder(root.right, inorder);
    }

    public static Node ar2bst(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = ar2bst(inorder, st, mid - 1);
        root.right = ar2bst(inorder, mid + 1, end);
        return root;
    }

    public static Node balanceBst(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();

        GetInorder(root, inorder);
        root = ar2bst(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balanceBst(root);
        preorder(root);
    }
}
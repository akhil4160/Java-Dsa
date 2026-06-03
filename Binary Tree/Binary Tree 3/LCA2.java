public class LCA2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftTree = lca2(root.left, n1, n2);
        Node rightTree = lca2(root.right, n1, n2);

        if(leftTree == null) {
            return rightTree;
        }
        if(rightTree == null) {
            return leftTree;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print(lca2(root, 4, 6).data);
    }
}

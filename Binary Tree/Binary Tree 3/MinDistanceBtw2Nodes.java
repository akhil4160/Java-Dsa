public class MinDistanceBtw2Nodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftTree = lca2(root.left, n1, n2);
        Node rightTree = lca2(root.right, n1, n2);

        if (leftTree == null) {
            return rightTree;
        }
        if (rightTree == null) {
            return leftTree;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftdist = lcaDist(root.left, n);
        int rightdist = lcaDist(root.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        } else if (leftdist == -1) {
            return rightdist + 1;
        }
        return leftdist + 1;
    }

    public static int minDis(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        int Dist1 = lcaDist(lca, n1);
        int Dist2 = lcaDist(lca, n2);

        return Dist1 + Dist2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print(minDis(root, 4, 6));
    }
}

import java.util.ArrayList;

public class printAllPathsRootToLeafs {
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

    public static void r2l(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        r2l(root.left, path);
        r2l(root.right, path);
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        int val[] = { 8, 5, 3, 1, 4, 6, 10, 9, 11, 14 };

        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }

        r2l(root, new ArrayList<>());
    }
}

public class searchInBst {
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

    public static Boolean Search(Node root, int k) {
        if(root == null) {
            return false;
        }
        if(root.data == k) {
            return true;
        }
        if(k < root.data) {
            return Search(root.left, k);
        }
        if(k > root.data) {
            return Search(root.right, k);
        }
        return false;
    }

    public static void main(String args[]) {
        int val[] = { 5, 1, 3, 4, 2, 7 };

        Node root = null;

        for (int i = 0; i < val.length; i++) {
            root = Insert(root, val[i]);
        }
        int k = 1;
        if(Search(root, k)) {
            System.out.print("found");
        }else{
            System.out.print("not found");
        }
    }
}

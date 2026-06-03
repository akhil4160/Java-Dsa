public class SortedArrayToBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node ar2bst(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }
        int mid = (st + end) /2;
        Node root = new Node(arr[mid]);
        root.left = ar2bst(arr, st, mid-1);
        root.right = ar2bst(arr, mid+1, end);
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
        int arr[] = {3, 5, 6, 8, 10, 11, 12};

        Node root = ar2bst(arr, 0, arr.length-1);

        preorder(root);
    }
}

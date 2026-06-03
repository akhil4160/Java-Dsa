public class KthAnsector {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int ka(Node root, int n , int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n){
            return 0;
        }
        int lftTree = ka(root.left, n, k);
        int rtTree = ka(root.right, n, k);

        if(lftTree == -1 && rtTree == -1) {
            return -1;
        }

        int max = Math.max(lftTree, rtTree);

        if(max+1 == k) {
            System.out.print(root.data);
        }

        return max +1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ka(root, 7, 2);
    }
}

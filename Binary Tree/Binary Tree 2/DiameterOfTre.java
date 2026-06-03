public class DiameterOfTre {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lftDia = diameter(root.left);
        int rtDia = diameter(root.right);
        int lftHt = height(root.left);
        int rtHt = height(root.right);
        
        int selfDia = lftHt + rtHt + 1;

        return Math.max(selfDia, Math.max(rtDia, lftDia));
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    }
}

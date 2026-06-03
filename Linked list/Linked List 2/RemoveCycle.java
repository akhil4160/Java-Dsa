public class RemoveCycle {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    void removeCycle() {

        Node slow = head;
        Node fast = head;
        boolean Cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Cycle = true;
                break;
            }
        }

        Node prev = null;
        if (Cycle == false) {
            return;
        }
        slow = head;
        while (slow != fast) {
            
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static void main(String args[]) {

        RemoveCycle ll = new RemoveCycle();

        ll.head = new Node(1);
        Node temp = new Node(2);
        ll.head.next = temp;
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = temp;

        System.out.println(ll.isCycle());
        ll.removeCycle();
        System.out.println(ll.isCycle());
    }
}

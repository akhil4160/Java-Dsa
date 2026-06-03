public class ZigZagLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void print() {

         if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void ZigZag() {
        Node mid = getMid(head);

        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node lh = head;
        Node rh = prev;
        Node nxtL, nxtR;

        while (lh != null && rh != null) {
            nxtL = lh.next;
            lh.next = rh;
            nxtR = rh.next;
            rh.next = nxtL;

            lh = nxtL;
            rh = nxtR;
        }
    }

    public static void main(String args[]) {
        ZigZagLL ll = new ZigZagLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(8);

        ll.print();
        ll.ZigZag();
        ll.print();
    }
}
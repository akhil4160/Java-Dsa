public class DeleteNthFromEnd {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    int sz() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    void dlt(int n, int size) {
        int itoFirst = (size - n);
        if (n == size) {
            head = head.next;
            return;
        }
        int i = 1;
        Node prev = head;
        while (i < itoFirst) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static void main(String args[]) {
        DeleteNthFromEnd ll = new DeleteNthFromEnd();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        ll.print();

        int size = ll.sz();
        ll.dlt(3, size);
        ll.print();
    }
}

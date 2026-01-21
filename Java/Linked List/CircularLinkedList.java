import java.util.Scanner;

class CNode {
    int data;
    CNode next;

    CNode(int value) {
        data = value;
        next = null;
    }
}

class CircularLinkedList {
    CNode head;

    void insertAtBeginning(int value) {
        CNode n = new CNode(value);
        if (head == null) {
            head = n;
            n.next = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        n.next = head;
        temp.next = n;
        head = n;
    }

    void insertAtEnd(int value) {
        CNode n = new CNode(value);
        if (head == null) {
            head = n;
            n.next = head;
            return;
        }
        CNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = n;
        n.next = head;
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        CNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        CNode n = new CNode(value);
        n.next = temp.next;
        temp.next = n;
    }

    void deleteFromBeginning() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
            return;
        }
        CNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        head = head.next;
        temp.next = head;
    }

    void deleteFromEnd() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
            return;
        }
        CNode temp = head;
        while (temp.next.next != head)
            temp = temp.next;

        temp.next = head;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == null) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        CNode temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        if (temp.next == head) return;
        temp.next = temp.next.next;
    }

    boolean search(int value) {
        if (head == null) return false;
        CNode temp = head;
        do {
            if (temp.data == value) return true;
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    void display() {
        if (head == null) return;
        CNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(HEAD)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        int ch, val, pos;

        do {
            System.out.println("\n1.Insert Begin\n2.Insert End\n3.Insert Position\n4.Delete Begin\n5.Delete End\n6.Delete Position\n7.Search\n8.Display\n9.Exit");
            ch = sc.nextInt();

            switch (ch) {
            case 1: val = sc.nextInt(); list.insertAtBeginning(val); break;
            case 2: val = sc.nextInt(); list.insertAtEnd(val); break;
            case 3: val = sc.nextInt(); pos = sc.nextInt(); list.insertAtPosition(val, pos); break;
            case 4: list.deleteFromBeginning(); break;
            case 5: list.deleteFromEnd(); break;
            case 6: pos = sc.nextInt(); list.deleteFromPosition(pos); break;
            case 7: val = sc.nextInt(); System.out.println(list.search(val) ? "Found" : "Not Found"); break;
            case 8: list.display(); break;
            }
        } while (ch != 9);

        sc.close();
    }
}
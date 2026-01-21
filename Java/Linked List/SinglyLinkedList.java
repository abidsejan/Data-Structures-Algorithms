import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

class SinglyLinkedList {
    Node head;

    void insertAtBeginning(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
    }

    void insertAtEnd(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = n;
            return;
        }
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n;
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        Node n = new Node(value);
        Node t = head;
        for (int i = 1; i < pos - 1 && t != null; i++)
            t = t.next;

        if (t == null) return;
        n.next = t.next;
        t.next = n;
    }

    void deleteFromBeginning() {
        if (head != null) head = head.next;
    }

    void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node t = head;
        while (t.next.next != null) t = t.next;
        t.next = null;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == null) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        Node t = head;
        for (int i = 1; i < pos - 1 && t.next != null; i++)
            t = t.next;
        if (t.next != null)
            t.next = t.next.next;
    }

    boolean search(int value) {
        Node t = head;
        while (t != null) {
            if (t.data == value) return true;
            t = t.next;
        }
        return false;
    }

    void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
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
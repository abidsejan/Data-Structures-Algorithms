import java.util.Scanner;

class DNode {
    int data;
    DNode next, prev;

    DNode(int value) {
        data = value;
        next = prev = null;
    }
}

class DoublyLinkedList {
    DNode head, tail;

    void insertAtBeginning(int value) {
        DNode n = new DNode(value);
        if (head == null)
            head = tail = n;
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    void insertAtEnd(int value) {
        DNode n = new DNode(value);
        if (tail == null)
            head = tail = n;
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        DNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) return;

        DNode n = new DNode(value);
        n.next = temp.next;
        n.prev = temp;

        if (temp.next != null)
            temp.next.prev = n;
        else
            tail = n;

        temp.next = n;
    }

    void deleteFromBeginning() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
    }

    void deleteFromEnd() {
        if (tail == null) return;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == null) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        DNode temp = head;
        for (int i = 1; i < pos && temp != null; i++)
            temp = temp.next;

        if (temp == null) return;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;
    }

    boolean search(int value) {
        DNode t = head;
        while (t != null) {
            if (t.data == value) return true;
            t = t.next;
        }
        return false;
    }

    void display() {
        DNode t = head;
        while (t != null) {
            System.out.print(t.data + " <-> ");
            t = t.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
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
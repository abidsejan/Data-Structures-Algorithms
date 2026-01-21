#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int value) {
        data = value;
        next = nullptr;
    }
};

class CircularLinkedList {
    Node* head;

public:
    CircularLinkedList() {
        head = nullptr;
    }

    void insertAtBeginning(int value) {
        Node* n = new Node(value);
        if (head == nullptr) {
            head = n;
            n->next = head;
            return;
        }
        Node* temp = head;
        while (temp->next != head)
            temp = temp->next;

        n->next = head;
        temp->next = n;
        head = n;
    }

    void insertAtEnd(int value) {
        Node* n = new Node(value);
        if (head == nullptr) {
            head = n;
            n->next = head;
            return;
        }
        Node* temp = head;
        while (temp->next != head)
            temp = temp->next;

        temp->next = n;
        n->next = head;
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        Node* temp = head;
        for (int i = 1; i < pos - 1 && temp->next != head; i++)
            temp = temp->next;

        Node* n = new Node(value);
        n->next = temp->next;
        temp->next = n;
    }

    void deleteFromBeginning() {
        if (head == nullptr) return;
        if (head->next == head) {
            delete head;
            head = nullptr;
            return;
        }
        Node* temp = head;
        while (temp->next != head)
            temp = temp->next;

        Node* del = head;
        head = head->next;
        temp->next = head;
        delete del;
    }

    void deleteFromEnd() {
        if (head == nullptr) return;
        if (head->next == head) {
            delete head;
            head = nullptr;
            return;
        }
        Node* temp = head;
        while (temp->next->next != head)
            temp = temp->next;

        delete temp->next;
        temp->next = head;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == nullptr) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        Node* temp = head;
        for (int i = 1; i < pos - 1 && temp->next != head; i++)
            temp = temp->next;

        Node* del = temp->next;
        if (del == head) return;

        temp->next = del->next;
        delete del;
    }

    bool search(int value) {
        if (head == nullptr) return false;
        Node* temp = head;
        do {
            if (temp->data == value) return true;
            temp = temp->next;
        } while (temp != head);
        return false;
    }

    void display() {
        if (head == nullptr) return;
        Node* temp = head;
        do {
            cout << temp->data << " -> ";
            temp = temp->next;
        } while (temp != head);
        cout << "(HEAD)\n";
    }
};

int main() {
    CircularLinkedList list;
    int ch, val, pos;

    do {
        cout << "\n1.Insert Begin\n2.Insert End\n3.Insert Position\n4.Delete Begin\n5.Delete End\n6.Delete Position\n7.Search\n8.Display\n9.Exit\n";
        cin >> ch;

        switch (ch) {
        case 1: cin >> val; list.insertAtBeginning(val); break;
        case 2: cin >> val; list.insertAtEnd(val); break;
        case 3: cin >> val >> pos; list.insertAtPosition(val, pos); break;
        case 4: list.deleteFromBeginning(); break;
        case 5: list.deleteFromEnd(); break;
        case 6: cin >> pos; list.deleteFromPosition(pos); break;
        case 7: cin >> val; cout << (list.search(val) ? "Found\n" : "Not Found\n"); break;
        case 8: list.display(); break;
        }
    } while (ch != 9);

    return 0;
}
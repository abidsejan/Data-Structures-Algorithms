#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int value) {
        data = value;
        next = prev = nullptr;
    }
};

class DoublyLinkedList {
    Node* head;
    Node* tail;

public:
    DoublyLinkedList() {
        head = tail = nullptr;
    }

    void insertAtBeginning(int value) {
        Node* n = new Node(value);
        if (head == nullptr) {
            head = tail = n;
        } else {
            n->next = head;
            head->prev = n;
            head = n;
        }
    }

    void insertAtEnd(int value) {
        Node* n = new Node(value);
        if (tail == nullptr) {
            head = tail = n;
        } else {
            tail->next = n;
            n->prev = tail;
            tail = n;
        }
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        Node* temp = head;
        for (int i = 1; i < pos - 1 && temp != nullptr; i++)
            temp = temp->next;

        if (temp == nullptr) return;

        Node* n = new Node(value);
        n->next = temp->next;
        n->prev = temp;

        if (temp->next != nullptr)
            temp->next->prev = n;
        else
            tail = n;

        temp->next = n;
    }

    void deleteFromBeginning() {
        if (head == nullptr) return;
        Node* temp = head;
        head = head->next;

        if (head != nullptr)
            head->prev = nullptr;
        else
            tail = nullptr;

        delete temp;
    }

    void deleteFromEnd() {
        if (tail == nullptr) return;
        Node* temp = tail;
        tail = tail->prev;

        if (tail != nullptr)
            tail->next = nullptr;
        else
            head = nullptr;

        delete temp;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == nullptr) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node* temp = head;
        for (int i = 1; i < pos && temp != nullptr; i++)
            temp = temp->next;

        if (temp == nullptr) return;

        if (temp->prev != nullptr)
            temp->prev->next = temp->next;

        if (temp->next != nullptr)
            temp->next->prev = temp->prev;
        else
            tail = temp->prev;

        delete temp;
    }

    bool search(int value) {
        Node* temp = head;
        while (temp != nullptr) {
            if (temp->data == value) return true;
            temp = temp->next;
        }
        return false;
    }

    void display() {
        Node* temp = head;
        while (temp != nullptr) {
            cout << temp->data << " <-> ";
            temp = temp->next;
        }
        cout << "NULL\n";
    }
};

int main() {
    DoublyLinkedList list;
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
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

class SinglyLinkedList {
    Node* head;

public:
    SinglyLinkedList() {
        head = nullptr;
    }

    void insertAtBeginning(int value) {
        Node* newNode = new Node(value);
        newNode->next = head;
        head = newNode;
    }

    void insertAtEnd(int value) {
        Node* newNode = new Node(value);
        if (head == nullptr) {
            head = newNode;
            return;
        }
        Node* temp = head;
        while (temp->next != nullptr)
            temp = temp->next;
        temp->next = newNode;
    }

    void insertAtPosition(int value, int pos) {
        if (pos <= 0) return;
        if (pos == 1) {
            insertAtBeginning(value);
            return;
        }
        Node* newNode = new Node(value);
        Node* temp = head;
        for (int i = 1; i < pos - 1 && temp != nullptr; i++)
            temp = temp->next;

        if (temp == nullptr) {
            cout << "Position out of range\n";
            delete newNode;
            return;
        }
        newNode->next = temp->next;
        temp->next = newNode;
    }

    void deleteFromBeginning() {
        if (head == nullptr) return;
        Node* temp = head;
        head = head->next;
        delete temp;
    }

    void deleteFromEnd() {
        if (head == nullptr) return;
        if (head->next == nullptr) {
            delete head;
            head = nullptr;
            return;
        }
        Node* temp = head;
        while (temp->next->next != nullptr)
            temp = temp->next;
        delete temp->next;
        temp->next = nullptr;
    }

    void deleteFromPosition(int pos) {
        if (pos <= 0 || head == nullptr) return;
        if (pos == 1) {
            deleteFromBeginning();
            return;
        }
        Node* temp = head;
        for (int i = 1; i < pos - 1 && temp->next != nullptr; i++)
            temp = temp->next;

        if (temp->next == nullptr) {
            cout << "Position out of range\n";
            return;
        }
        Node* del = temp->next;
        temp->next = del->next;
        delete del;
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
            cout << temp->data << " -> ";
            temp = temp->next;
        }
        cout << "NULL\n";
    }
};

int main() {
    SinglyLinkedList list;
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
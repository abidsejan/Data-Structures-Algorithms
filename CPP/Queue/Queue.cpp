#include <iostream>
using namespace std;

#define MAX 5

int arr[MAX];
int front = -1;
int rear = -1;

bool isEmpty() {
    return (front == -1 && rear == -1);
}

bool isFull() {
    return (rear == MAX - 1);
}

void enqueue(int x) {
    if (isFull()) {
        cout << "Queue is full!" << endl;
    } else {
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear++;
        }
        arr[rear] = x;
        cout << x << " enqueued into queue." << endl;
    }
}

void dequeue() {
    if (isEmpty()) {
        cout << "Queue is empty!" << endl;
    } else {
        cout << arr[front] << " dequeued from queue." << endl;
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }
}

void display() {
    if (isEmpty()) {
        cout << "Queue is empty!" << endl;
    } else {
        cout << "Queue: ";
        for (int i = front; i <= rear; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
}

int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);
    display();

    dequeue();
    display();

    enqueue(40);
    enqueue(50);
    enqueue(60);
    display();

    return 0;
}
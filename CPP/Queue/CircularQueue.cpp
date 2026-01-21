#include <iostream>
using namespace std;

#define MAX 5

int arr[MAX];
int front = -1;
int rear = -1;

bool isEmpty() {
    return (front == -1);
}

bool isFull() {
    return ((rear + 1) % MAX == front);
}

void enqueue(int x) {
    if (isFull()) {
        cout << "Circular Queue is full!" << endl;
    } else {
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % MAX;
        }
        arr[rear] = x;
        cout << x << " enqueued into circular queue." << endl;
    }
}

void dequeue() {
    if (isEmpty()) {
        cout << "Circular Queue is empty!" << endl;
    } else {
        cout << arr[front] << " dequeued from circular queue." << endl;
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % MAX;
        }
    }
}

void display() {
    if (isEmpty()) {
        cout << "Circular Queue is empty!" << endl;
    } else {
        cout << "Circular Queue: ";
        int i = front;
        while (true) {
            cout << arr[i] << " ";
            if (i == rear)
                break;
            i = (i + 1) % MAX;
        }
        cout << endl;
    }
}

int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    display();

    dequeue();
    dequeue();
    display();

    enqueue(50);
    enqueue(60);
    display();

    return 0;
}
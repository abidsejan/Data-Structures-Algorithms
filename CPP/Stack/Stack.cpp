#include <iostream>
using namespace std;

int MAX = 10;
int arr[10];
int top = 0;

bool isEmpty() {
    return (top == 0);
}

bool isFull() {
    return (top == MAX);
}

void push(int x) {
    if (isFull()) {
        cout << "Stack full" << endl;
    } else {
        arr[top] = x;
        top++;
        cout << x << " pushed into stack." << endl;
    }
}

void pop() {
    if (isEmpty()) {
        cout << "Stack empty" << endl;
    } else {
        top--;
        cout << arr[top] << " popped from stack." << endl;
    }
}

int topElement() {
    if (isEmpty()) {
        cout << "Stack is empty." << endl;
        return -1;
    }
    return arr[top - 1];
}

void show() {
    if (isEmpty()) {
        cout << "Stack is empty." << endl;
    } else {
        cout << "Stack elements (Top to Bottom): ";
        for (int i = top - 1; i >= 0; i--) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
}

int main() {
    push(10);
    push(20);
    push(30);
    show();

    cout << "Top element: " << topElement() << endl;

    pop();
    show();

    push(40);
    push(50);
    show();

    return 0;
}
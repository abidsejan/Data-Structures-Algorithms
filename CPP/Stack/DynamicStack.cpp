#include <iostream>
using namespace std;

int *arr;
int top = 0;
int MAX;

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

int main() {
    cout << "Enter stack size: ";
    cin >> MAX;

    arr = new int[MAX];

    push(10);
    push(20);
    pop();
    push(30);

    return 0;
}
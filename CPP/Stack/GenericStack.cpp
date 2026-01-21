#include <iostream>
using namespace std;

int MAX = 10;
int top = 0;

template <class T>
T arr[10];

bool isEmpty() {
    return (top == 0);
}

bool isFull() {
    return (top == MAX);
}

template <class T>
void push(T x) {
    if (isFull()) {
        cout << "Stack full" << endl;
    } else {
        arr<T>[top] = x;
        top++;
        cout << x << " pushed into stack." << endl;
    }
}

template <class T>
void pop() {
    if (isEmpty()) {
        cout << "Stack empty" << endl;
    } else {
        top--;
        cout << arr<T>[top] << " popped from stack." << endl;
    }
}

int main() {
    push<int>(10);
    push<int>(20);
    pop<int>();
    return 0;
}
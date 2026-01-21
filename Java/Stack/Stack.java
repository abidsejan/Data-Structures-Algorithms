class Stack {
    static int MAX = 10;
    static int[] arr = new int[MAX];
    static int top = 0;

    static boolean isEmpty() {
        return (top == 0);
    }

    static boolean isFull() {
        return (top == MAX);
    }

    static void push(int x) {
        if (isFull()) {
            System.out.println("Stack full");
        } else {
            arr[top] = x;
            top++;
            System.out.println(x + " pushed into stack.");
        }
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("Stack empty");
        } else {
            top--;
            System.out.println(arr[top] + " popped from stack.");
        }
    }

    static int topElement() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return arr[top - 1];
    }

    static void show() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements (Top to Bottom): ");
            for (int i = top - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        show();

        System.out.println("Top element: " + topElement());

        pop();
        show();

        push(40);
        push(50);
        show();
    }
}
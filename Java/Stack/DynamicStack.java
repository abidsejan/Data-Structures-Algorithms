class DynamicStack {
    static int[] arr;
    static int top = 0;
    static int MAX;

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

    public static void main(String[] args) {
        MAX = 5;
        arr = new int[MAX];

        push(10);
        push(20);
        pop();
        push(30);
    }
}
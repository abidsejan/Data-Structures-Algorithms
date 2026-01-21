class GenericStack<T> {
    static int MAX = 10;
    static Object[] arr = new Object[MAX];
    static int top = 0;

    static boolean isEmpty() {
        return (top == 0);
    }

    static boolean isFull() {
        return (top == MAX);
    }

    static <T> void push(T x) {
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
        push(10);
        push(20);
        pop();
    }
}
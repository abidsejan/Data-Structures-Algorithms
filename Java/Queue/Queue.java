class Queue {
    static final int MAX = 5;
    static int[] arr = new int[MAX];
    static int front = -1;
    static int rear = -1;

    static boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    static boolean isFull() {
        return (rear == MAX - 1);
    }

    static void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear++;
            }
            arr[rear] = x;
            System.out.println(x + " enqueued into queue.");
        }
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println(arr[front] + " dequeued from queue.");
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
        }
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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
    }
}
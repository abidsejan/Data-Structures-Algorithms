class CircularQueue {
    static final int MAX = 5;
    static int[] arr = new int[MAX];
    static int front = -1;
    static int rear = -1;

    static boolean isEmpty() {
        return (front == -1);
    }

    static boolean isFull() {
        return ((rear + 1) % MAX == front);
    }

    static void enqueue(int x) {
        if (isFull()) {
            System.out.println("Circular Queue is full!");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % MAX;
            }
            arr[rear] = x;
            System.out.println(x + " enqueued into circular queue.");
        }
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
        } else {
            System.out.println(arr[front] + " dequeued from circular queue.");
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % MAX;
            }
        }
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
        } else {
            System.out.print("Circular Queue: ");
            int i = front;
            while (true) {
                System.out.print(arr[i] + " ");
                if (i == rear)
                    break;
                i = (i + 1) % MAX;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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
    }
}
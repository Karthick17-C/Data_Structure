class Array {
    static class Queue {
        int front, rear, capacity;
        int arr[];

        Queue(int size) {
            front = rear = 0;
            capacity = size;
            arr = new int[capacity];
        }

        void enqueue(int x) {
            if (capacity == rear) {
                System.out.println("Queue is full");
                return;
            }
            arr[rear] = x;
            rear++;
        }

        void dequeue() {
            if (front == rear) {
                System.out.println("Queue is empty");
                return;
            }
            for (int i = 0; i < rear - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
        }

        void peek() {
            if (front == rear) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Front element is: " + arr[front]);
        }

        void display() {
            if (front == rear) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue elements are: ");
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.dequeue();
        q.display();
        q.peek();
    }
}
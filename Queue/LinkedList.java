class LinkedList {
    static class Queue{
        Node front, rear;
        int size;

        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Queue() {
            front = rear = null;
            size = 0;
        }

        void enqueue(int x) {
            Node newNode = new Node(x);
            if (rear == null) {
                front = rear = newNode;
                size++;
                return;
            }
            rear.next = newNode;
            rear = newNode;
            size++;
        }

        void dequeue() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            front = front.next;
            size--;
            if (front == null) {
                rear = null;
            }
        }

        void peek() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Front element is: " + front.data);
        }

        void display() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue elements are: ");
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
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

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void pop(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        if(head.next==null){
            System.out.println("Popped element is: "+head.data);
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        System.out.println("Popped element is: "+temp.next.data);
        temp.next=null;
    }

    public void peek(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        System.out.println("Top element is: "+temp.data);
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        list.peek();
        list.pop(); 
        list.display();
        list.peek();
    }
}

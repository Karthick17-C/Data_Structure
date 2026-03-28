import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node pre;

    Node(int data){
        this.data=data;
    }
}
public class Main{
    static Node head,tail;
    public static void Insert(int data){
        Node n = new Node(data);
        if(head==null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
    }

    public static void InsertAtBegin(int data){
        Node n = new Node(data);
        if(head==null){
            head = n;
            tail = n;
        }else{
            head.pre = n;
            n.next = head;
            head = n;
        }
    }

    public static void InsertAtPosition(int p, int data){
        Node n = new Node(data);
        Node t = head;
        for(int i=0;i<p-1;i++){
            t=t.next;
        }
        if(t==null){
            System.out.println("Position not found");
        }else{
            n.next = t.next;
            n.pre = t;
            if(t.next!=null){
                t.next.pre = n;
            }
            t.next = n;
        }
    }

    public static void DeleteAtPosition(int p){
        Node t = head;
        for(int i=1;i<p & t!=null;i++){
            t=t.next;
        }
        if(t.pre==null){
            head = t.next;
            if(t.next!=null){
                head.pre = null;
            }
        }else{
            t.pre.next = t.next;
            if(t.next!=null){
                t.next.pre = t.pre;
            }                                                                        
        }
        t.pre = null;
        t.next = null;
    }
    public static void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void reverse(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.pre;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            Insert(s.nextInt());
        }
        display();
        InsertAtBegin(2);
        display();
        InsertAtPosition(3, 4);
        display();
        DeleteAtPosition(2);
        display();
        reverse();
        display();
        s.close();
    }
}
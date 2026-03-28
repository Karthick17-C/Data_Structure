import java.util.Scanner;
class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data=data;
    }
}

public class Circular {
    static Node head,tail;

    static void insert(int d){
        Node n = new Node(d);
        if(head==null){
            head=tail=n;
            n.next=head;
            n.prev=tail;
        }else{
            tail.next = n;
            n.prev=tail;
            tail=n;
            n.next=head;
            head.prev=tail;
        }
    }

    static void insertBegin(int d){
        Node n = new Node(d);
         if(head==null){
            head=tail=n;
            n.next=head;
            n.prev=tail;
        }else{
            n.next=head;
            n.prev=tail;
            tail.next=n;
            head.prev=n;
            head=n;
        }
    }

    static void insertAtPos(int p, int d){
        Node n = new Node(d);
        if(p==1){
            n.next=head;
            n.prev=tail;
            tail.next=n;
            head.prev=n;
            head=n;
        }
        Node c = head;
        int i=1;
        while(i<p-1 && c.next!=head){
            i++;
            c=c.next;
        }
        n.next=c.next;
        n.prev=c;
        c.next=n;
        if(c==tail){
            tail=n;
            head.prev=tail;
        }
    }

    static void delete(){
        Node c = head;
        while(c.next.next!=head){
            c=c.next;
        }
        c.next.prev=null;
        c.next.next=null;
        c.next=head;
        head.prev=c;
    }

    static void display(){
        Node t = head;
        do{
            System.out.print(t.data+" ");
            t=t.next;
        }while(t!=head);
        System.out.println();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            insert(s.nextInt());
        }
        insertBegin(8);
        display();
        insertAtPos(2, 7);
        display();
        delete();
        display();
        s.close();
    }
}
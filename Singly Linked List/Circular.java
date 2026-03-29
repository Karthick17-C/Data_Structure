import java.util.Scanner;
class Circular{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    static Node head,tail;

    static void InsertAtEnd(int d){
        Node n = new Node(d);
        if(head==null){
            head=n;
            tail=n;
            tail.next=head;
        }else{
            tail.next = n;
            tail = n;
            tail.next=head;
        }
    }

    static void InsertBegin(int d){
        Node n = new Node(d);
        if(head==null){
            head = n;
            tail = n;
            tail.next = head;
        }else{
            n.next = head;
            tail.next = n;
            head = n;
        }
    }

    static void InsertAtPosition(int p, int val){
        Node n = new Node(val);
        if(p<=0){
            System.out.println("Invalid");
            return;
        }
        if(p==1){
            if(head==null){
                head = n;
                tail = n;
                tail.next = head;
            }else{
                n.next = head;
                tail.next = n;
                head = n;
            }
        }
        int c=1;
        Node temp = head;
        while(c<p-1 && temp.next!=head){
            temp=temp.next;
            c++;
        }
        if(c<p-1){
            System.out.println("Invalid");
            return;
        }
        n.next = temp.next;
        temp.next = n;
        if(temp==tail){
            tail = n;
        }
    }

    static void deleteBegin(){
        if(head==null){
            return;
        }
        if(head==tail){
            head=tail=null;
            return;
        }
        head=head.next;
        tail.next=head;
    }

    static void deleteEnd(){
        if(head==null){
            return;
        }
        if(head==tail){
            head=tail=null;
            return;
        }
        Node t = head;
        while(t.next!=null){
            t=t.next;
        }
        t.next=head;
        tail=t;
    }

    static void deletePos(int p){
        if(head==null){
            return;
        }
        if(p==1){
            head=head.next;
            tail.next=head;
            return;
        }
        Node t = head;
        int i=0;
        while(i<p-1){
            i++;
            t=t.next;
            if(t==head){
                return;
            }
        }
        t.next=t.next.next;
        if(t.next==head){
            tail = t;
        }
    }

    static void display(Node head){
        if(head==null){
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            InsertAtEnd(s.nextInt());
        }
        InsertAtPosition(2, 8);
        InsertBegin(4);
        display(head);
        deletePos(3);
        display(head);
        deleteEnd();
        display(head);
        deleteBegin();
        display(head);
        s.close();
    }
}
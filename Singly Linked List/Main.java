class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next = null;
    }
}

public class Main{
    static Node head, tail;
    static void Insert(int data){
        Node n = new Node(data);
        if(head==null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
    }

    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.err.println();
    }

    static Node reverse(Node head){
        Node temp = head;
        Node rev = null;
        while(temp!=null){
            Node t = temp.next;
            temp.next = rev;
            rev = temp;
            temp = t;
        }
        return rev;
    }

    static void InsertBegin(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;
    }

    static void Search(int target){
        Node temp = head;
        int n=1;
        int f=0;
        while(temp!=null){
            if(temp.data==target){
                f++;
                break;
            }
            temp=temp.next;
            n++;
        }
        if(f==0){
            System.out.println("Target not found");
        }else{
            System.out.println("Target node is : "+n);
        }
    }

    static void InsertAtPosition(int p, int val){
        Node temp = head;
        int pos = 1;
        int f=0;
        Node pre = null;
        while(temp!=null){
            if(pos==p){
                f++;
                break;
            }
            pos++;
            pre = temp;
            temp=temp.next;
        }
        if(f==0){
            System.out.println("Out of Range");
        }else{
            Node n = new Node(val);
            pre.next = n;
            n.next = temp;
        }
    }

    static void DeleteHead(){
        if(head==null){
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next=null;
    }

    static void DeleteTail(){
        if(head==null || head.next==null){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    static void DeleteAtIndex(int pos){
        Node temp = head;
        int i=1;
        if(pos<=0){
            return;
        }
        if(i==pos){
            DeleteHead();
            return;
        }
        while(i<pos-1 && temp.next!=null){
            temp = temp.next;
            i++;
        }
        if(temp.next==null){
            return;
        }
        if(temp.next.next==null){
            DeleteTail();
            return;
        }
        temp.next = temp.next.next;
    }

    static int FindMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    public static void main(String[] args){
        int a = 5;
        int b = 10;
        int c = 15;
        int d = 20;
        Insert(a);
        Insert(b);
        Insert(c);
        Insert(d);
        display(head);
        Node r = reverse(head);
        display(r);
        head = reverse(r);
        Search(15);
        InsertAtPosition(2, 17);
        display(head);
        DeleteHead();
        display(head);
        DeleteTail();
        display(head);
        DeleteAtIndex(2);
        display(head);
        System.out.println(FindMiddle(head));
    }
}
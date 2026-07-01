import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class Binary_Tree{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data  = data;
        }
    }

    static Node insert(Scanner s){
        int v = s.nextInt();
        if(v==-1){
            return null;
        }
        Queue <Node> q = new LinkedList<>();
        Node root = new Node(v);
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            int left = s.nextInt();
            if(left!=-1){
                cur.left = new Node(left);
                q.add(cur.left);
            }
            int right = s.nextInt();
            if(right!=-1){
                cur.right = new Node(right);
                q.add(cur.right);
            }
        }
        return root;
    }

    static void display(Node root){
        if(root==null){
            return;
        }
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
            System.out.print(cur.data+" ");
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Node root = insert(s);
        display(root);
    }
}
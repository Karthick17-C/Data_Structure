import java.util.Scanner;

class BST {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    static Node insert(Node root,int v){
        if(root==null){
            return new Node(v);
        }
        if(root.data>v){
            root.left = insert(root.left,v);
        }
        else if(root.data<v){
            root.right = insert(root.right,v);
        }
        return root;
    }

    static void display(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node root = null;
        while(true){
            int v = s.nextInt();
            if(v==-1){
                break;
            }else{
                root = insert(root,v);
            }
        }
        display(root);
        s.close();
    }
}
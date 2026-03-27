class Array{
    static class Stack{
        int top;
        int capacity;
        int arr[];
        Stack(int size){
            top=-1;
            capacity=size;
            arr=new int[capacity];
        }
        void push(int x){
            if(top==capacity-1){
                System.out.println("Stack overflow");
                return;
            }
            arr[++top]=x;
        }
        void pop(){
            if(top==-1){
                System.out.println("Stack underflow");
            }else{
                System.out.println("Popped element is: "+arr[top--]);
            }
        }
        void peek(){
            if(top==-1){
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Top element is: "+arr[top]);
        }

        void display(){
            if(top==-1){
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack elements are: ");
            for(int i=top;i>=0;i--){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.display();
        stack.peek();
        stack.pop();
        stack.peek();
        stack.display();
    }
}
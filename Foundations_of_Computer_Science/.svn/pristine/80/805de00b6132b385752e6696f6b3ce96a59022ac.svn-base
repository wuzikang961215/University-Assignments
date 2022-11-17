public class MyStack{

    // attribute
    private Node top; // the reference to the top node in this stack

    // initialize an empty stack
    public MyStack(){
        this.top = null;
    }

    // accessor
    public Node getTop(){
        return this.top;
    }

    // push a node into stack
    public void push(Node node){
        node.setNext(top);
        top = node;
    }

    // get and remove the top node
    public Node pop(){
        // when the stack is empty
        if(isEmpty() == true){
            System.out.println("Stack is empty");
            return null;
        }
        // when not empty
        Node tmp = top;
        top = top.getNext();
        return tmp;        
    }

    // get the top node
    public Node peek(){
        // when empty
        if(isEmpty() == true){
            System.out.println("Stack is empty");
            return null;
        }
        // when not empty
        return top;
    }

    // return true when empty and otherwise false
    public boolean isEmpty(){
        if(top == null)
            return true;
        else
            return false;
    }

    // printing stack
    public void printStack(){
        if(top == null)
            System.out.println("Stack is empty");
        Node stack = top;
        while(stack != null){
            System.out.print(stack.getData() + " ");
            stack = stack.getNext();
        }
    }

    // remove node
    public void removeNode(String data){
        if(top == null)
            return;
        // if it is the top that saves the data
        if(top.getData().equals(data)){
            top = top.getNext();
            return;
        }
        // if not the top ,search for the data in the stack
        Node previousNode = top;
        Node currentNode = top.getNext();
        while(currentNode != null){
            // if found
            if(currentNode.getData().equals(data)){
                previousNode.setNext(currentNode.getNext());
                break;
            }
            // if not found, keep searching
            previousNode = previousNode.getNext();
            currentNode = currentNode.getNext();
        }
    }
}
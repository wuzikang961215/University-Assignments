public class MyQueue{

    // the reference to the first and last node in the queue
    private Node front, rear;

    // constructor
    public MyQueue(){
        this.front = null;
        this.rear = null;
    }

    // accessors
    public Node getFront(){
        return this.front;
    }
    public Node getRear(){
        return this.rear;
    }

    // mutators
    public void setFront(Node front){
        this.front = front;
    }
    public void setRear(Node rear){
        this.rear = rear;
    }

    // insert one node at the end of the queue
    public void enqueue(Node node){
        // when queue is empty
        if(isEmpty() == true){
            front = node;
            return;
        }

        // when not empty
        rear = front;
        while(rear.getNext() != null)
            rear = rear.getNext();
        // when reach the last element
        rear.setNext(node);
    }

    // get and remove the front from the queue
    public String dequeue(){
        // when the queue is empty
        if(isEmpty() == true){
            System.out.println("Queue is empty");
            return null;
        }
        // else
        String frontData = front.getData();
        front = front.getNext();
        return frontData;
    }

    // return true if the queue is empty and otherwise false
    public boolean isEmpty(){
        if(front == null)
            return true;
        return false;
    }

    // print out the data saved in nodes in the queue
    public void displayQueue(){
        // when empty
        if(isEmpty() == true){
            System.out.println("Queue is empty");
            return;
        }
        // when not empty
        rear = front;
        while(rear != null){
            rear.printNode();
            rear = rear.getNext();
        }
    }

    // get the length of the queue
    public int getQueueLength(){
        int length = 0;
        // if empty
        if(isEmpty() == true)
            return length;
        // if not empty
        rear = front;
        while(rear != null){
            length++;
            rear = rear.getNext();
        }
        return length;
    }


}
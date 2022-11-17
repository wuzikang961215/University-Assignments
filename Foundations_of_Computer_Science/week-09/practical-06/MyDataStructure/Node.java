public class Node{

    // attributes
    private String data; // data saved in this node
    private Node next; // reference to another node

    // constructor
    public Node(String data){
        this.data = data;
        this.next = null;
    }

    // accessors
    public String getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }

    // mutators
    public void setData(String data){
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

    // print method
    public void printNode(){
        System.out.println("Node data: " + getData());
    }
}
public class Node{
    
    // attribute
    private int index;

    // constructor
    public Node(int index){
        this.index = index;
    }

    // accessor
    public int getIndex(){
        return this.index;
    }
    // mutator
    public void setIndex(int index){
        this.index = index;
    }

    // print function
    public void printNode(){
        System.out.print(" Node " + index + " ");
    }
}
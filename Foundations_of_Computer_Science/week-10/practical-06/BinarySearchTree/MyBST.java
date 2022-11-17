public class MyBST{
    // attribute
    private Node root;

    // accessor
    public Node getRoot(){
        return this.root;
    }
    // mutator
    public void setRoot(Node root){
        this.root = root;
    }

    // constructor
    public MyBST(){
        this.root = null;
    }

    // insert a value to the tree
    public void insert(int value){
        // if root is null
        if(root == null)
            root = new Node(value);
        // if root is not null
        else{
            Node current = root;
            insertRec(current, value);
        }
    }
    // recursive function to insert a value to the tree
    private void insertRec(Node current, int value){
        // recursive
        if(value < current.getData()){
            // if left is null
            if(current.getLeft() == null)
                current.setLeft(new Node(value));
            else{
                current = current.getLeft();
                insertRec(current, value);
            }
        }
        else if(value > current.getData()){
            // if right is null
            if(current.getRight() == null)
                current.setRight(new Node(value));
            else{
                current = current.getRight();
                insertRec(current, value); 
            }
        }
            // if the node is already in the tree
        else
            System.out.println("Node is in the tree");    
            
        
    }

    // search a Node in the tree
    public boolean search(int value){
        return searchRec(root, value);
    }
    // recursive function to search a Node in the tree
    private boolean searchRec(Node current, int value){
        boolean foundOrNot = false;
        // if the current value is the value
        if(current.getData() == value)
            foundOrNot = true;         
        // recursive
        else if(value < current.getData() && current.getLeft() != null){
            foundOrNot = searchRec(current.getLeft(), value);
        }
        else if(value > current.getData() && current.getRight() != null){
            foundOrNot = searchRec(current.getRight(), value);
        }
        return foundOrNot;
    }

    // print the tree
    public void printBST(){
        printBSTRec(root);
    }
    // recursively print the tree by order
    public void printBSTRec(Node root){
        if(root != null){
            printBSTRec(root.getLeft());
            root.printNode();
            printBSTRec(root.getRight());
        }
    }
}
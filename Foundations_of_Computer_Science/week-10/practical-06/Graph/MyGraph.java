import java.util.*;

public class MyGraph{

    // an adjancency list
    LinkedList<Node> adjListArray[];

    // constructor to initialize an empty graph
    public MyGraph(){
        // adjListArray = new LinkedList[0];
    }

    // transform an adjancency matrix to an adjacency array
    public void matrixToList(int[][] matrix){
        // V is the number of vertexes
        int V = matrix.length;
        adjListArray = new LinkedList[V];
        // add linked lists to ther graph
        for(int i = 0; i < V; i++)
            adjListArray[i] = new LinkedList<>();
        // read the matrix
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                // this means there is an edge from i to j
                if(matrix[i][j] == 1)
                    addEdge(new Node(i), new Node(j)); 
            }
        }

    }

    // function to add en edge in the graph
    private void addEdge(Node src, Node dest){
        // add en edge from source to destination
        adjListArray[src.getIndex()].addLast(dest);
    }
   
    // print out the adjancency list array
    public void displayAdjListArray(){
        for(int i = 0; i < adjListArray.length; i++){
            System.out.print(i + ":");
            for(Node j: adjListArray[i]){
                // print the node index
                j.printNode();
                // print the arrow if j is not the last Node in adjListArray[i]
                if(j != adjListArray[i].getLast())
                    System.out.print("->");
            }
            System.out.println();
        }
    }



}
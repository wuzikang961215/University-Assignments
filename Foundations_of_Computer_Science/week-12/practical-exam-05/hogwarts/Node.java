/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/

public class Node{

    // properties
    private Node next; //point to the next Node
    private Student info; //student

    // basic constructor
    public Node(){
        this.next = null;
    }

    // parametric constructor
    public Node(Student tmpStudent){
        this.info = tmpStudent;
    }

    // accessors to get properties
    public Node getNext(){
        return this.next;
    }
    public Student getInfo(){
        return this.info;
    }
    
    // mutators to set properties
    public void setNext(Node tmpNext){
        this.next = tmpNext;
    }
    public void setInfo(Student tmpStudent){
        this.info = tmpStudent;
    }
}
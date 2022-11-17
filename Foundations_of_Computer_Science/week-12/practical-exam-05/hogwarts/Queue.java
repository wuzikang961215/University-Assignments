/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/

public class Queue{
    // properties 
    private Node front; // where the first Node is enqueued
    private Node back; // where the last Node is enqueued

    // accessor for getting the attributes
    public Node getFront(){
        return this.front;
    }
    public Node getBack(){
        return this.back;
    }
    // mutator for setting the attributes
    public void setFront(Node tmpFront){
        this.front = tmpFront;
    }
    public void setBack(Node tmpBack){
        this.back = tmpBack;
    }
    
    // constructor
    public Queue(){
        this.front = null;
        this.back = null;
    }

    // method to add a Node to the last position in queue
    public void enqueue(Student tmpStudent){
        // create a node for saving tmpStudent
        Node newNode = new Node(tmpStudent);
        // if the queue is empty
        if(front == null){
            front = newNode;
            return;
        }
        // if the queue is not empty
        // back for traversal
        back = front;
        // move to the last position
        while(back.getNext() != null)
            back = back.getNext();
        // place the new Node to the next of back
        back.setNext(newNode);
    }

    // method to remove the first Node in the queue
    public Student dequeue(){
        // if the queue is empty, do nothing
        if(front == null)
            return null;
        // if not empty, remove back
        Student student = front.getInfo();
        front = front.getNext();
        return student;
    }

    // method to get the name of the first student
    public String peek(){
        // if the queue is empty
        if(front == null)
            return "";
        // if not empty
        String studentName = front.getInfo().getName();
        return studentName;
    }

    // method to print the student information
    public void displayQueue(){
        // if the queue is empty
        if(front == null){
            System.out.println("There are no students waiting for a scholarship");
            return;
        }
        // current Node is for traversing
        Node current = front;
        // position of the queue
        int position = 1;
        while(current != null){
            // print the position, name, age
            System.out.print("#"+position+" "+current.getInfo().getName()+", "+current.getInfo().getAge()+" years old, ");
            // print the period with conditions
            // if period is 1, 11, 21...
            if(current.getInfo().getPeriod()%10 == 1 || current.getInfo().getPeriod() == 1)
                System.out.print(current.getInfo().getPeriod()+"st ");
            // if period is 2, 12, 22...
            else if(current.getInfo().getPeriod()%10 == 2 || current.getInfo().getPeriod() == 2)
                System.out.print(current.getInfo().getPeriod()+"nd ");
            // if period is 3, 13, 23...
            else if(current.getInfo().getPeriod()%10 == 3 || current.getInfo().getPeriod() == 3)
                System.out.print(current.getInfo().getPeriod()+"rd ");
            // other cases
            else
                System.out.print(current.getInfo().getPeriod()+"th ");
            // print the words left
            System.out.println("year in Hogwarts;");
            // add the value of position
            position++;
            // move the current to the next
            current = current.getNext();
        }
    }

}
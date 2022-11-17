public class WaitingList {
    protected Node head;
    protected int numNodes;

    public WaitingList(){
        this.head = null;
        this.numNodes = 0;
    }

    // accessor
    public Node getHead(){
        return this.head;
    }
    // mutator
    public void setHead(Node head){
        this.head = head;
    }

    /**
     * This method will pop the first patient from the waiting list
     * @return the patient popped from the waiting list
     */
    public Patient popPatient() {
        //TODO: Implement this method
        // if there is no patient in the list
        if(head == null)
            return null;
        // else
        Patient patientPoped = head.getPatient();
        head = head.getNext();
        return patientPoped;
    }

    /**
     * This method will add patient into the waiting list according to the triage level
     * @param patient patient's data
     */
    public void addToList(Patient patient) {
        //TODO: Implement this method
        Node newNode = new Node(patient);
        // if the list is empty
        if(head == null){
            head = newNode;
            return;
        }
        // if not empty
        // if the patient traige level bigger than head
        else if(newNode.getPatient().getTriageLevel() > head.getPatient().getTriageLevel()){
            // auxiliary node
            Node aux = head;
            head = newNode;
            head.setNext(aux);
            return;
        }
        // if the patient traige level not bigger than head
        else{
            Node previousNode = head;
            Node currentNode = head.getNext();
            while(currentNode != null){
                // compare the triage level
                if(newNode.getPatient().getTriageLevel() > currentNode.getPatient().getTriageLevel()){
                    previousNode.setNext(newNode);
                    newNode.setNext(currentNode);
                    return;
                }
                else{
                    currentNode = currentNode.getNext();
                    previousNode = previousNode.getNext();
                }
            }
            // if the commands in while loop is not terminated, then put the patient to the end
            previousNode.setNext(newNode);
        }
    }

    /**
     * print out the information for each patient in waiting list
     */
    public void printList() {
        //TODO: Implement this method
        // if the list is empty
        if(head == null){
            System.out.println("There is no patient now!");
            return;
        }
        // if not empty
        Node currentNode = head;
        while(currentNode != null){
            currentNode.printNode();
            currentNode = currentNode.getNext();
        }
    }

    /**
     * Check whether the patient is in this list or not
     * @return
     */
    public boolean isInList(Patient patient) {
        if (this.head == null) {
            return false;
        }
        Node temp = this.head;
        while(temp != null) {
            if(temp.getPatient().getName().equals(patient.getName())
                    && temp.getPatient().getPhoneNumber().equals(patient.getPhoneNumber())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
}

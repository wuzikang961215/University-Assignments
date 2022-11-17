public class Node {
    protected Node next;
    protected Patient patient;

    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void printNode() {
        // print the information of the patient
        System.out.println("------Patient Information------");
        System.out.println("Patient ID: "+patient.getId());
        System.out.println("Patient name: "+patient.getName());
        System.out.println("Patient's triage level: "+patient.getTriageLevel());
        System.out.println();
    }
}

class Student extends Person{

    // attributes
    private double [] marks;
    private String [] disciplines;

    // basic constructor
    public Student(){
        
    }

    // parametric constructor
    public Student(String givenName, String lastName, int age, String gender, String citizenship,double [] marks, String [] disciplines){
        super(givenName, lastName, age, gender, citizenship);
        this.marks = marks;
        this.disciplines = disciplines;
    }

    // accessors
    public double [] get_marks(){
        return this.marks;
    }
    public String [] get_disciplines(){
        return this.disciplines;
    }

    // mutators
    public void set_marks(double [] marks){
        this.marks = marks;
    }
    public void set_disciplines(String [] disciplines){
        this.disciplines = disciplines;
    }

    // methods
    public double averageMarks(double [] marks){
        int i = 0;
        double sum = 0.0;
        // do while loop to calculate the sum of marks
        do{
            sum = sum + marks[i];
            i++;
        }while(i<marks.length);
        double average = sum/(double)marks.length;
        return average;
    }
    public void displayDisciplines(String [] disciplines){
        int i = 0;
        System.out.print("[ ");
        // while loop to print out disciplines
        while(i<disciplines.length){
            System.out.print(disciplines[i]+" ");
            i++;
        }
        System.out.println("]");
    }
}
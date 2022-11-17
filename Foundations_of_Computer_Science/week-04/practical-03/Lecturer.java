class Lecturer extends Person{

    // attributes
    private double salary;
    private String [] disciplines;

    // basic constructor
    public Lecturer(){
        
    }

    // parametric constructor
    public Lecturer(String givenName, String lastName, int age, String gender, String citizenship,double salary, String [] disciplines){
        super(givenName, lastName, age, gender, citizenship);
        this.salary = salary;
        this.disciplines = disciplines;
    }

    // accessors
    public double get_salary(){
        return this.salary;
    }
    public String [] get_disciplines(){
        return this.disciplines;
    }

    // mutators
    public void set_salary(double salary){
        this.salary = salary;
    }
    public void set_disciplines(String [] disciplines){
        this.disciplines = disciplines;
    }

    // methods
    public double annualSalary(double salary){
        double salaryForYear = salary*12;
        return salaryForYear;
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
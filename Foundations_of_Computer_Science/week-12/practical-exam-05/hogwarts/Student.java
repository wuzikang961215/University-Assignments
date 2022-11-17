/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/


public class Student{
    // properties
    private String name; //name of students
    private int age; //age of students
    private int period; //period of students

    // basic constructor
    public Student(){
        this.name = "unknown";
        this.age = 0;
        this.period = 0;
    }

    // parametric constructor
    public Student(String tmpName, int tmpAge, int tmpPeriod){
        this.name = tmpName;
        this.age = tmpAge;
        this.period = tmpPeriod;
    }

    // accessors to get the attributes
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getPeriod(){
        return this.period;
    }

    // mutators to set the attributes
    public void setName(String tmpName){
        this.name = tmpName;
    }
    public void setAge(int tmpAge){
        this.age = tmpAge;
    }
    public void setPeriod(int tmpPeriod){
        this.period = tmpPeriod;
    }

    // method to print a student
    public void printStudent(){
        // print name, age and period
        System.out.println("Printing student record");
        System.out.println("Name:\t\t" + name);
        System.out.println("Age:\t\t" + age);
        System.out.println("Period:\t\t" + period);
    }
}
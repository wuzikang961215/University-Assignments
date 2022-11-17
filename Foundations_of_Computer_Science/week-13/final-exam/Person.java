/*==================================
Foundations of Computer Science
Student: Zikang, Wu
id: a1816094
Semester: tr3
Year: 2020
Practical Exam Number: 
===================================*/

public class Person{

    // attributes
    private String name; // for saving the person's name
    private int age; // for saving a person's age

    // basic constructor
    public Person(){
        this.name = "anon";
        this.age = -1;
    }

    // parametric constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // accessors
    public String getName(){
        return this.name; // return the name of the person
    }
    public int getAge(){
        return this.age; // return the age of the person
    }

    // mutators
    public void setName(String name){
        this.name = name; // set the person's name
    }
    public void setAge(int age){
        this.age = age; // set the person's age
    }

    // return the name and the age by string
    public String toString(){
        // content is for saving what needed to return
        String content = "Person: "+name+" is age: " + String.valueOf(age);
        return content;
    }
}
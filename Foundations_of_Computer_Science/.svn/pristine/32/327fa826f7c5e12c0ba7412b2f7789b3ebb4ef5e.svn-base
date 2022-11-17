public class Person{
    // state
    // default is public
    private String name;
    private int age;

    public Person(){
        this.name = "unknown";
        this.age = 100;
    }

    //constructor
    public Person(String name, int age){
        this.name = name; // name without this (word) is the variable reveived as an argument
        this.age = age;
    }
    public Person(int age){
        this.age = age;
        this.name = "unknown";
    }

    // Method that prints the information

    public void printInformation(){
        System.out.println("My name is "+ this.name + " and my age is "+this.age);
    }

    // abstract method
    public abstract void printInformation(); //signature of the method

    // accessors
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    // modifiers
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age; 
    }
 
}
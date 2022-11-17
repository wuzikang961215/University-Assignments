class Main{
    public static void main(String [] args){
        
        Person p = new Person();
        // using accessors
        p.setName("Peter");
        p.setAge(23);
        
        Person p2 = new Person("Bob", 15);
        
        Person p3 = new Person(18);
        
        // printing the information of my persons
        p.printInformation();
        p2.printInformation();
        p3.printInformation();
        
        // using modifiers
        System.out.println("Printing again Bob");
        System.out.println(p2.getName()+ " "+p2.getAge());

        // We can have an array of objects
        System.out.println("Creating an array of persons");
        Person [] people = {p, p2, p3};
        for(int i = 0; i < people.length ; i++){
            people[i].printInformation();
        }
    }
}
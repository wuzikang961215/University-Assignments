import java.util.Scanner;

class Input {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        System.out.println("\n What is your dog's name? ");
        String name = input.nextLine();
        

        System.out.println("\n How old is your dog? ");
        int age = input.nextInt();
        

        System.out.println("\n What is your dog's favorite food? ");
        String favoritefood = input.next();
        

        System.out.println("\n How tall is your dog? Enter in meters ");
        float height = input.nextFloat();
        

        System.out.println("\n How much does your dog weigh? Enter in kilograms ");
        float weight = input.nextFloat();
        

        System.out.println("\n What is your dog's favorite toy? ");
        String favoritetoy = input.next();


        System.out.println("\n What is your name? ");
        String name_of_owner = input.next();


        System.out.println("\n Your dog's name is " + name + " and it is " + age + " years old. \n Your dog's favorite food is " + favoritefood + ". \n Your dog is "+ height + " meters tall and weigh "+ weight +" kilograms. \n Your dog's favorite toy is "+favoritetoy+ ". \n The name of the dog's owner is "+ name_of_owner+ "." );
    }
}
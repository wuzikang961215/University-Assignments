class TestAnimal{
    public static void main(String[]args){
        Lion l = new Lion();
        Turtle t = new Turtle();
        Chameleon z = new Chameleon();
        Animal [] animals = {l,t,z};
        for(int i = 0 ; i< animals.length; i++){
            System.out.println(animals[i].makeSound());
        }
    }
}
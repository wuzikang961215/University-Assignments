class Wolf extends Animal{
    String name;
    boolean alpha;

    Wolf(String name, boolean alpha, int hungry, int [] location){
        super(hungry, location);
        this.name = name;
        this.alpha = alpha;
    }

    public String toString(){
        return("I am a wolf. My name is "+this.name+". I am "+this.alpha+" and I am "+super.toString());
    }


    void eat(){
        System.out.println("I'm a met lover and my favorite food is fresh deer.. ");
    }

    void sleep(){
        //when the animal considered asleep
        System.out.println("I go to bed after the sunrise");
    }

    void makeNoise(){
        //sound of noise
        System.out.println("I'm a wolf doing noise");
    }
}
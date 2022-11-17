class Animal {
    int hungry;
    int [] location = new int[2]; //x and y coordinates

    Animal(int hungry, int [] location){
        this.hungry = hungry;
        this.location = location;
    }

    public String toString(){
        return("Hungry = "+this.hungry+" and I am allocated in "+location[0]+", "+location[1]+" coordinates");
    }

    void eat(){
        //the animal's preferred food source, meat or grass
    }

    void sleep(){
        //when the animal considered asleep
    }

    void makeNoise(){
        //sound of noise
    }
}
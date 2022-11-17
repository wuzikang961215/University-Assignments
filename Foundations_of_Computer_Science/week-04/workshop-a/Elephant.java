class Elephant extends Panda{
    public Elephant(){
        set_age(0);
    }
    public Elephant(String name, int age, String favorite_food){
        super(name, age, favorite_food);
    }
    public String hobby(){
        return "eating";
    }
}
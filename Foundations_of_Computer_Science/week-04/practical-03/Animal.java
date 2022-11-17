class Animal{

    // attributes
    private String name;
    private double weight;
    private String favoriteFood;
    private int age;

    // basic constructor
    public Animal(){
        this.name = "unknown";
        this.favoriteFood = "unknown";
    }

    // parametric constructor
    public Animal(String name, double weight, String favoriteFood, int age){
        this.name = name;
        this.weight = weight;
        this.favoriteFood = favoriteFood;
        this.age = age;
    }

    // accessors
    public String get_name(){
        return this.name;
    }
    public double get_weight(){
        return this.weight;
    }
    public String get_favoriteFood(){
        return this.favoriteFood;
    }
    public int get_age(){
        return this.age;
    }

    //mutators
    public void set_name(String name){
        this.name = name;
    }
    public void set_weight(double weight){
        this.weight = weight;
    }
    public void set_favoriteFood(String favoriteFood){
        this.favoriteFood = favoriteFood;
    }
    public void set_age(int age){
        this.age = age;
    }

    // method
    public String makeSound(){
        return "Animal sound";
    }

}
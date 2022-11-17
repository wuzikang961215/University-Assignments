class Doctor extends Person{

    // attributes
    private String speciality;

    // basic constructor
    public Doctor(){
        
    }

    // parametric constructor
    public Doctor(String givenName, String lastName, int age, String gender, String citizenship, String speciality){
        super(givenName, lastName, age, gender, citizenship);
        this.speciality = speciality;
    }

    // accessor
    public String get_speciality(){
        return this.speciality;
    }

    // mutator
    public void set_speciality(String speciality){
        this.speciality = speciality;
    }
}
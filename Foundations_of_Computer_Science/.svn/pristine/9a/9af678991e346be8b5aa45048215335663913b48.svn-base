class Bicycle extends VehicleAbstract{
    // attributes
    private boolean is_serviced;
    private String inDate;
    private String outDate;
    private String serviceResponsible;

    // basic constructor
    public Bicycle(){
        this.is_serviced = true;
    }

    // parametric constructor
    public Bicycle(boolean is_serviced, String inDate, String outDate, String serviceResponsible, String color, int year, double numberGears){
        super(color, year, numberGears);
        this.is_serviced = is_serviced;
        this.inDate = inDate;
        this.outDate = outDate;
        this.serviceResponsible = serviceResponsible;
    }

    // accessors
    public boolean get_is_serviced(){
        return is_serviced;
    }
    public String get_inDate(){
        return inDate;
    }
    public String get_outDate(){
        return outDate;
    }
    public String get_serviceResponsible(){
        return serviceResponsible;
    }

    // mutators
    public void set_is_serviced(boolean is_serviced){
        this.is_serviced = is_serviced;
    }
    public void set_inDate(String inDate){
        this.inDate = inDate;
    }
    public void set_outDate(String outDate){
        this.outDate = outDate;
    }
    public void set_serviceResponsible(String serviceResponsible){
        this.serviceResponsible = serviceResponsible;
    }


    // methods
    public void checkoutService(){
        System.out.println("Serviced or not = "+is_serviced+"\ninDate = "+inDate+"\noutDate = "+outDate+"\nserviceResponsible = "+serviceResponsible);
    }
    // methods from Vehicle interface
    public double changeGear(double numberGears){
        this.numberGears = this.numberGears + numberGears;
        return this.numberGears;
    }
    public void checkBreak(double i){
        System.out.println("Check break: "+i);
    }
    // methods from VehicleAbstract class
    public void abstractMethod(){
        System.out.println("This is an abstract method implemented by Bicycle class");
    }
}

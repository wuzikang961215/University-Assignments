class TestBicycle{
    public static void main(String[]args){
        // creating a Bicycle object
        Bicycle b = new Bicycle(true, "9, December", "15, December", "Yaneli", "yellow", 2020, 3.0);
        // running methods
        b.checkoutService();
        System.out.println(b.changeGear(4.5));
        b.checkBreak(5.4);
        b.abstractMethod();
    }
}
class PhysicalBook extends Book{
    private int shelf;
    private int aisle;
    private int floor;

    // basic constructor
    public PhysicalBook(){

    }

    // parametric constructor
    public PhysicalBook(String title, int year, String publish, int pages, int shelf, int aisle, int floor){
        super(title, year, publish, pages);
        this.shelf = shelf;
        this.aisle = aisle;
        this.floor = floor;
    }

    // accessors
    public int get_shelf(){
        return this.shelf;
    }
    public int get_aisle(){
        return this.aisle;
    }
    public int get_floor(){
        return this.floor;
    }

    // mutators
    public void set_shelf(int shelf){
        this.shelf = shelf;
    }
    public void set_aisle(int aisle){
        this.aisle = aisle;
    }
    public void set_floor(int floor){
        this.floor = floor;
    }

    // method
    public void displayBookLocation(int shelf, int aisle, int floor){
        System.out.println("shelf: "+shelf+" aisle: "+aisle+" floor: "+floor);
    }
}
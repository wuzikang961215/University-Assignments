class Book{

    // attributes
    private String title;
    private int year;
    private String publish;
    private int pages;

    // basic constructor
    public Book(){
        this.title = "unknown";
        this.publish = "unknown";
    }

    // parametric constructor
    public Book(String title, int year, String publish, int pages){
        this.title = title;
        this.year = year;
        this.publish = publish;
        this.pages = pages;
    }

    // accessors
    public String get_title(){
        return this.title;
    }
    public int get_year(){
        return this.year;
    }
    public String get_publish(){
        return this.publish;
    }
    public int get_pages(){
        return this.pages;
    }

    //mutators
    public void set_title(String title){
        this.title = title;
    }
    public void set_year(int year){
        this.year = year;
    }
    public void set_publish(String publish){
        this.publish = publish;
    }
    public void set_pages(int pages){
        this.pages = pages;
    }
}
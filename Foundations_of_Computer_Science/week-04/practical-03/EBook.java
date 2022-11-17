class EBook extends Book{
    private String url;

    // basic constructor
    public EBook(){

    }

    // parametric constructor
    public EBook(String title, int year, String publish, int pages, String url){
        super(title, year, publish, pages);
        this.url = url;
    }

    // accessor
    public String get_url(){
        return this.url;
    }

    // mutator
    public void set_url(String url){
        this.url = url;
    }
}
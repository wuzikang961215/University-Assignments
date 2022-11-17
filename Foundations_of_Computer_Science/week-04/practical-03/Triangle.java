class Triangle extends Shape{

    // basic constructor
    public Triangle(){
        
    }

    // parametric constructor
    public Triangle(double height, double radius, double length){
        super(height, radius, length);
    }

    // methods
    public double area(double height, double length){
        double triangleArea = height*length*0.5;
        return triangleArea;
    }
}
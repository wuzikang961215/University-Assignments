class Circle extends Shape{

    // basic constructor
    public Circle(){
        
    }

    // parametric constructor
    public Circle(double radius){
        super(radius);
    }

    // methods
    public double area(double radius){
        double circleArea = Math.PI*radius*radius;
        return circleArea;
    }
}
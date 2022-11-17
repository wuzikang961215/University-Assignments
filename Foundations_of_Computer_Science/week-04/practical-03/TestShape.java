class TestShape{
    public static void main(String[]args){
        Circle a = new Circle(3.5);
        System.out.println("Circle area = "+a.area(a.get_radius()));
        Triangle b = new Triangle(4.0, 3.0, 3.3);
        System.out.println("Triangle area = "+b.area(b.get_height(), b.get_length()));

        Rectangle c = new Rectangle(5.0, 4.0);
        System.out.println("Rectangle area = "+c.area(c.get_width(), c.get_length()));
    }
}
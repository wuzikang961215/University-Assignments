import java.util.Scanner;

class TestRectangle{
    public static void main(String [] args){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter width and height of the rectangle: ");
            // input of width and height
            int width = input.nextInt();
            int height = input.nextInt();
            if(width>=1 && height<10*10*10){
                // building an object of class RectangleArea
                RectangleArea r = new RectangleArea(width, height);
                // saving the value of width and height
                int [] rectangleWidthHeight = r.read_input(r.get_width(), r.get_height());
                System.out.println("The width, height and area of the rectangle are: ");
                // displaying the width, height and the area
                r.display(rectangleWidthHeight[0], rectangleWidthHeight[1]);
                break;
            }
            else{
                System.out.println("Sorry the width must be no smaller than 1 and the height must be smaller than 10^3");
            }
        }      


        
    }
}
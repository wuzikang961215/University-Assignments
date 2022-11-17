class ComplexCalculator{
    // claiming variables
    double real;
    double imaginary;

    // constructor
    public ComplexCalculator(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
    // add method returning a new object of ComplexCalculator
    public static ComplexCalculator add(ComplexCalculator a, ComplexCalculator b){
        // this is the real part of the sum
        double real_sum = a.real + b.real;
        // this is the imaginary part of the sum
        double imaginary_sum = a.imaginary + b.imaginary;
        return new ComplexCalculator(real_sum, imaginary_sum);
    }

    // subtract method
    public static ComplexCalculator subtract(ComplexCalculator a, ComplexCalculator b){
        double real_subtract = a.real - b.real;
        double imaginary_subtract = a.imaginary - b.imaginary;
        return new ComplexCalculator(real_subtract, imaginary_subtract);
    }

    // multiplication method
    public static ComplexCalculator multiplication(ComplexCalculator a, ComplexCalculator b){
        double real_mul = a.real*b.real - a.imaginary*b.imaginary;
        double imaginary_mul = a.imaginary*b.real + a.real*b.imaginary;
        return new ComplexCalculator(real_mul, imaginary_mul);
    }

    // division method
    public static ComplexCalculator division(ComplexCalculator a, ComplexCalculator b){
        double real_division = ((a.real*b.real)+(a.imaginary*b.imaginary))/((b.real*b.real)+(b.imaginary*b.imaginary));
        double imaginary_division = ((a.imaginary*b.real)-(a.real*b.imaginary))/((b.real*b.real)-(b.imaginary*b.imaginary));
        return new ComplexCalculator(real_division, imaginary_division);
    }

    // returning the complex numbers as Strings
    public String complexNumber(){
        if(imaginary>0){
            return String.valueOf(real) + "+" + String.valueOf(imaginary) + "i";
        }
        else if(imaginary<0){
            return String.valueOf(real) + "" + String.valueOf(imaginary) + "i";
        }
        else{
            return String.valueOf(real);
        }
    }

}
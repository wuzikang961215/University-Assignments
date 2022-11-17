class ArrayExample{
    public static void main(String[] args){
        int []numbers = new int[3];
        numbers[0] = 10;
        numbers[1] = 50;
        numbers[2] = 100;
        System.out.println(numbers);
        for (int i = 0; i< numbers.length; i ++){
            System.out.println(numbers [i]);
        }
        System.out.println("Another way to declare and print arrays");
        int [] numbers2 = {5, 90 ,13}; 
        // val is the type of my array like int
        for(int val:numbers2){
            System.out.println(val);
        }
    }
}
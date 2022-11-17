class BaseOperations{
    public static void main(String [] args){
        // creating arrays
        int[] intArray = {4,6,8,3};
        String[] StringArray = {"dog", "Maria", "army","Washington"};
        float[] floatArray = {4.5f, 3.66f, 24.0f, 49.345f};
        // calling printing method
        printArray(intArray);
        printArray(StringArray);
        printArray(floatArray);
        // calling reversing method
        intArray = reverseArray(intArray);
        StringArray = reverseArray(StringArray);
        floatArray = reverseArray(floatArray);
        printArray(intArray);
        printArray(StringArray);
        printArray(floatArray);
    }

    public static void printArray(int[] array){
        int i = 0;
        System.out.print("[");
        // using do while loop to print array
        do{
            System.out.print(array[i]);
            // using conditions to print comma
            if(i < array.length-1){
                System.out.print(",");
            }
            i++;
        }
        while(i < array.length);
        System.out.print("]\n");
    }
    public static void printArray(String[] array){
        int i = 0;
        System.out.print("[");
        do{
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(",");
            }
            i++;
        }
        while(i < array.length);
        System.out.print("]\n");
    }
    public static void printArray(float[] array){
        int i = 0;
        System.out.print("[");
        do{
            System.out.print(array[i]);
            if(i < array.length-1){
                System.out.print(",");
            }
            i++;
        }
        while(i < array.length);
        System.out.print("]\n");
    }
    public static int[] reverseArray(int[] array){
        int x = array.length-1;
        int[] arrayReversed = new int[array.length];
        // using for loop to creat a reversed array
        for(int i = 0; i<array.length; i++){
            arrayReversed[i] = array[x];
            x--;
        }
        return arrayReversed;
    }
    public static String[] reverseArray(String[] array){
        int x = array.length-1;
        String[] arrayReversed = new String[array.length];
        for(int i = 0; i<array.length; i++){
            arrayReversed[i] = array[x];
            x--;
        }
        return arrayReversed;
    }
    public static float[] reverseArray(float[] array){
        int x = array.length-1;
        float[] arrayReversed = new float[array.length];
        for(int i = 0; i<array.length; i++){
            arrayReversed[i] = array[x];
            x--;
        }
        return arrayReversed;
    }
    
}
import java.lang.Math;

public class Main{

    // find next happy number
    static int nextHappeyHum(int num){
        // happy number found
        if(calculateHappy(num+1) == 1)
            return (num+1);
        // not found, keep going
        else
            return nextHappeyHum(num+1);
    }

    // calculate happy number
    private static int calculateHappy(int num){
        // base case
        if(num == 1)
            return num;
        // all unhappy numbers would be stuck in a loop of 4-16-37-58-89-145-42-20-4-...
        // so this case is the num not being happy number
        else if(num <= 4 && num > 1)
            return 0;
        else{
            int sum = 0;
            // get the sum of squares of its digits
            while(num > 0){
                sum += Math.pow(num%10, 2);
                num /= 10;
            }
            return calculateHappy(sum);
        }
    }

    static String decodeString(String s){
        StringBuilder result = new StringBuilder();
        // call decoding and the decoded string is stored in result
        decoding(s, 0, result);
        return result.toString();
    }

    private static int decoding(String s, int index, StringBuilder results){
        // for storing the numbers in s
        int printTimes = 0;

        // searching for the chars in string s
        while(index < s.length()){
            char x = s.charAt(index);
            if(Character.isDigit(x)){
                printTimes = Integer.parseInt(String.valueOf(x));
            }
            else if(x == '['){
                StringBuilder subResult = new StringBuilder();
                // recursively call the method to add chars into string
                index = decoding(s, index+1, subResult);
                for(int i = 0; i < printTimes; i++)
                    results.append(subResult);
                printTimes = 0;
            }
            else if(x == ']'){
                // basic case of recursion
                return index;
            }
            else{
                // adding the letters here
                results.append(x);
            }
            // jump to the next char
            index++;
        }   
        
        return index;
    }

    public static void main(String [] args){
        System.out.println(nextHappeyHum(10));
        System.out.println(decodeString("3[b2[ca]1[d]]"));
    }
}
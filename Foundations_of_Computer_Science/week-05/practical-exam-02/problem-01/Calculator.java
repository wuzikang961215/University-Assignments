//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: break room 1 
//===================================

public class Calculator{
    // adding function
    public int sum(int numA, int numB){
        int num_sum = numA + numB;
        return num_sum;
    }

    // calculating cube function
    public float cube(float num){
        float num_cube = num*num*num;
        return num_cube;
    }

    // calculating division function

    public float division(float numA, float numB){
        if(numB == 0){
            float num_division = -99.9f;
            return num_division;
        }
        else{
            float num_division = numA / numB;
            return num_division;
        }
    }
        
}
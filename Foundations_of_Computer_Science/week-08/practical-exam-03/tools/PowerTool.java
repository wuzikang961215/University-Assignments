//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: breakroom 3
//===================================

public abstract class PowerTool extends Tool{ // inherit from Tool class 
    protected int power;

    public PowerTool(float weight, float value, int power){ // constructor that initializes weight, value and power
        super(weight, value);
        this.power = power;
    }

    public int getPower(){
        return this.power; // returns the value of the power rating 
    }
}
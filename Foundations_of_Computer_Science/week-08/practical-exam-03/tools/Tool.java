//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: breakroom 3
//===================================

public abstract class Tool implements Asset{ // implementing the Asset interface
    protected float weight; // variable to store the weight of the Tool in grams
    protected float value; // variable to store the current value of the Tool in cents

    public Tool(float weight, float value){ // constructor initializing weight and value
        this.weight = weight;
        this.value = value;
    }

    public float getValue(){ // returns the value of this Tool
        return this.value;
    }

    public float getWeight(){ // returns the weight of this Tool
        return this.weight;
    }

    public abstract void useTool(int used); // abstract void method useTool not implemented yet
}
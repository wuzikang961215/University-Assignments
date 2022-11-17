//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: breakroom 3
//===================================

public class Hammer extends HandTool{ // inherit from the HandTool class

    public Hammer(float weight, float value){
        // constructor calling the constructor from father class HandTool and initialize sharp as false
        super(weight, value, false); 
    }

    public void useTool(int used){ // use the tool by used times
        this.value -= 0.01*used; // value dropped by 0.01 per use
        if(this.value < 0)
            this.value = 0; // the value never drops below zero
        
        System.out.println("Bang!");  // make hammer sound

    }
}
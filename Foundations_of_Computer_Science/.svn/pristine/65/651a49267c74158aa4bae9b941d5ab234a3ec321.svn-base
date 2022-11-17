//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: breakroom 3
//===================================

public class PowerDrill extends PowerTool{ // inherit from the PowerTool class

    public PowerDrill(float weight, float value){
        // constructor calling the constructor from father class HandTool and initializing the power as 800 
        super(weight, value, 800);
    }

    public void useTool(int used){ // use the tool by used times
        this.value -= 0.03*used; // value dropped by 0.03 per use
        if(this.value < 0)
            this.value = 0; // the value never drops below zero
        
        System.out.println("Zssh!"); // make powerdrill sound
        
    }

}

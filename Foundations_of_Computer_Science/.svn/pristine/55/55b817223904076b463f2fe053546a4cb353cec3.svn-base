//==================================
// Foundations of Computer Science
// Student: Zikang, Wu
// id: a1816094
// Semester: tr3
// Year: 2020
// Practical Exam Number: breakroom 3
//===================================

public class Chisel extends HandTool{ // inherit from the HandTool class
    
    public Chisel(float weight, float value){
        // constructor calling the constructor from father class HandTool and initialize sharp as true
        super(weight, value, true);
    }

    public void useTool(int used){ // use the tool by used times
        this.value -= 0.02*used; // value dropped by 0.02 per use
        if(this.value < 0)
            this.value = 0; // the value never drops below zero
        
        System.out.println("Scrape"); // make chisel sound
    }

}

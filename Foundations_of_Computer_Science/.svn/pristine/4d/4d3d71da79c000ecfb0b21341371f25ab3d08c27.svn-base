public class Student{


    // attributes
    private String name;
    private int physic;
    private int chemistry;
    private int math;
    private int average;

    // basic constructor
    public Student(){
        this.name = "unknown";
    }

    // parametric consructor
    public Student(String name, int physic, int chemistry, int math){
        this.name = name;
        this.physic = physic;
        this.chemistry = chemistry;
        this.math = math;
        int sum = physic + chemistry + math;
        this.average = Math.round((float)sum/3);
    }

    // accessors
    public String getName(){
        return this.name;
    }
    public int getPhysic(){
        return this.physic;
    }
    public int getChemistry(){
        return this.chemistry;
    }
    public int getMath(){
        return this.math;
    }
    public int getAverage(){
        return this.average;
    }

    // mutators
    public void setName(String name){
        this.name = name;
    }
    public void setPhysic(int physic){
        this.physic = physic;
    }
    public void setChemistry(int chemistry){
        this.chemistry = chemistry;
    }
    public void setMath(int math){
        this.math = math;
    }
    public void setAverage(int average){
        this.average = average;
    }

    // for sorting students array
    public Student [] sortStudents(Student [] students){
        int i, j;
        Student student;
        for(i = 1; i < students.length; i++){
            student = students[i];
            j = i-1;
            // move smaller elements in students array to bigger index
            while(j >= 0 && students[j].average <= student.average){
                if(students[j].average < student.average){
                    students[j+1] = students[j];
                    j--;
                }
                // when averages are equal
                else{
                    // move when bigger index of elements has smaller physic
                    if(students[j].physic < student.physic){
                        students[j+1] = students[j];
                        j--;
                    }
                    // when physics are equal
                    else if(students[j].physic == student.physic){
                        if(students[j].chemistry < student.chemistry){
                            students[j+1] = students[j];
                            j--;
                        }
                        else if(students[j].chemistry == student.chemistry){
                            if(students[j].math < student.math){
                                students[j+1] = students[j];
                                j--;
                            }
                            else if(students[j].math == student.math){
                                // compare the length of names
                                if(students[j].name.length() > student.name.length()){
                                    students[j+1] = students[j];
                                    j--;
                                }
                                else
                                    break;
                            }
                            else
                                break;
                        }
                        else
                            break;
                    }
                    else
                        break;
                }
            }
            // move the ith student to index j+1
            students[j+1] = student;
        }
        return students;
    }

}
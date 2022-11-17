import java.io.*;
import java.util.Arrays;

public class Main{

    // read date from txt files
    private static Student[] readData(String filename){
        // initialize a Student array
        Student [] students = new Student[20];
        try {
            BufferedReader read = new BufferedReader(new FileReader(new File(filename)));
            String line = "";
            String str = "";
            while((line = read.readLine())!=null){
                str += " " + line;
            }
            // save the words from txt file into a string array
            String [] words = str.split(" ");

            // the first element of words array is " ", so start from index 1
            int j = 1;
            for(int i = 0; i < 20; i++){
                // save the names and grades which are transfered from string into int
                students[i] = new Student(words[j], Integer.parseInt(words[j+1]), Integer.parseInt(words[j+2]), Integer.parseInt(words[j+3]));
                j += 4;
            }
        } catch (IOException e) {

        }
        return students;

    }
    
    // print method that prints the name and marks
    public static void printStudents(Student [] students){
        System.out.println("Student         AverageScore    Physic          Chemistry       Maths");
        for(int i = 0; i < 20; i++){
            System.out.println(students[i].getName()+"\t\t"+students[i].getAverage()+"\t\t"+students[i].getPhysic()+"\t\t"+students[i].getChemistry()+"\t\t"+students[i].getMath());
        }
    }
    public static void main(String [] args){
        // read file
        Student [] students = readData("/Users/peterwu/fcs/week-07/students.txt");
        Student s = new Student();
        // sort students
        Student [] studentsSorted = s.sortStudents(students);
        // print information
        printStudents(studentsSorted);
        
    }
}
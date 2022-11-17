 class TestPerson{
     public static void main(String[]args){

        // student peter
        double [] peterMarks = {90.0, 89.5, 95.5, 92.0};
        String [] peterDisciplines = {"excellent", "excellent", "good", "ok"};
        Student peter = new Student("Zikang","Wu",23,"male","China",peterMarks,peterDisciplines);
        System.out.println("My name is "+peter.get_givenName()+", "+peter.get_lastName()+ 
                            ". I am "+peter.get_age()+" years old and am from "+peter.get_citizenship());
        // displaying average marks
        System.out.println("Zikang's average mark = "+peter.averageMarks(peter.get_marks()));
        peter.displayDisciplines(peter.get_disciplines());
        // student nancy
        Student nancy = new Student();
        double [] nancyMarks = {86.5,85.5,67.0,78.0};
        nancy.set_marks(nancyMarks);
        System.out.println("Nancy's average mark = "+nancy.averageMarks(nancy.get_marks()));

        // lecturer
        String [] mariaDisciplines = {"excellent", "excellent", "excellent", "good"};
        Lecturer maria = new Lecturer("maria","lee",39,"female","Hongkong",5200.0,mariaDisciplines);
        System.out.println("Maria's salary = "+maria.annualSalary(maria.get_salary()));
        maria.displayDisciplines(maria.get_disciplines());

        // doctor
        Doctor Lee = new Doctor("Du", "Lee", 39, "female", "China", "stomach");
        System.out.println("Lee's speciality = "+Lee.get_speciality());
        Patient Huang = new Patient();
        Huang.set_diagnostic("stomachache, headache");
        System.out.println("Huang's diagnostic = "+Huang.get_diagnostic());
     }
 }

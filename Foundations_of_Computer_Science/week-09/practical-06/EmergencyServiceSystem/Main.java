import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    /**
     * initialize data to the serviceCenter, terminate the system if data is wrong
     * @param serviceCenter
     */
    public static void initializeSystem(ServiceCenter serviceCenter){
        String[] name = {"Tod", "David", "Dave", "Roy", "Megan"};
        String[] phoneNumbers = {"0410333222", "0410333223", "0410333224",  "0410333225", "0410333226"};
        int[] triageLevel = {1,5,2,4,3};
        String[] location={"King William ST", "North Terrace", "Grote St", "Gouger St", "Melbourne St"};
        // Check the length for each array is equal
        if(!(name.length == phoneNumbers.length && name.length == location.length && name.length == triageLevel.length)){
            System.out.println("Failed to initialize data.");
            return;
        }
        // Initialize data into service center
        for(int i=0; i<name.length; i++){
            serviceCenter.addPatientIntoList(name[i], phoneNumbers[i], triageLevel[i], location[i]);
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String getHeader(boolean toPrint){
        String ans = "\n\n\n";
        ans += "===============================================================================" + "\n";
        ans += ":: Emergency Service Center                                                  ::" + "\n";
        ans += "===============================================================================" + "\n";
        if(toPrint)
            System.out.println(ans);
        return ans;
    }

    public static void printSubHeader(String subHeader){
        getHeader(true);
        String str = ":: " + subHeader + "\n";
        System.out.println(str);
    }

    public static void printScreenMessage(String message){
        String ans = getHeader(false) + "\n\n";
        ans += "::            " + message + "\n\n";
        System.out.println(ans);

    }

    public static void exitMessage(){
        clearScreen();
        printScreenMessage("Thank you!!");
    }

    public static void displayMenu(){
        String ans = getHeader(false);
        ans += ":: Options:                                                                  ::" + "\n";
        ans += ":: 1. Add Patient                                                            ::" + "\n";
        ans += ":: 2. Assign Ambulance For Patient                                           ::" + "\n";
        ans += ":: 3. Print Waiting List                                                     ::" + "\n";
        ans += ":: 0. Exit                                                                   ::" + "\n";
        ans += "===============================================================================" + "\n";
        System.out.println(ans);
    }

    public static int getOption(Scanner inputScan, int [] optionsAvailable){
        String ans = ":: Your option: ";
        System.out.println(ans);
        String _input = inputScan.nextLine();
        int _option = Integer.parseInt(_input);
        for(int i = 0; i < optionsAvailable.length; i++)
            if(_option == optionsAvailable[i])
                return _option;
        return -1;
    }

    public static String getInput(Scanner inputScan, String question){
        System.out.println(question);
        String _input = inputScan.nextLine();
        return _input;
    }

    public static void waitInput(Scanner scan){
        String ans = "\n\n\n";
        ans += "                        Press any key to continue . . .      " + "\n";
        ans += "===============================================================================" + "\n";
        System.out.println(ans);
        scan.nextLine();
    }

    public static void tryAgain(Scanner scan){
        clearScreen();
        String ans = getHeader(false);
        ans += ":: Your input is invalid, please select ::" + "\n";
        ans += ":: a valid option.                      ::" + "\n";
        ans += "===============================================================================" + "\n";
        System.out.println(ans);
        waitInput(scan);
    }

    public static boolean performAction(ServiceCenter serviceCenter, int _option, Scanner inputScan){
        String query = "";
        // TODO: The tester report that the system will crash when the input of triageLevel and id is not a number
        // TODO: The tester report that the system should only accept (1-5) as legal number 
        // TODO: The system should ask the user to input again if there is an illegal input
        String id = "";
        switch(_option){
            case 1:
                while(true){
                    clearScreen();
                    printSubHeader("Add Patient");
                    String name = getInput(inputScan, "Please enter the name of patient: ");
                    String phoneNumber = getInput(inputScan, "Please enter the phoneNumber of patient: ");
                    String triageLevel = getInput(inputScan, "Please enter the triage level of patient: ");
                    String location = getInput(inputScan, "Please enter the location of patient: ");
                    Pattern pattern = Pattern.compile("[0-9]*");
                    // when the input of triage level is not an int
                    if(pattern.matcher(triageLevel).matches() == false){
                        System.out.println("Sorry, the triage level must be integer from 1 to 5. Please enter again");
                        continue;
                    }
                    // when it's an int
                    else{
                        if(Integer.parseInt(triageLevel) > 0 && Integer.parseInt(triageLevel) < 6 ){
                            serviceCenter.addPatientIntoList(name, phoneNumber, Integer.parseInt(triageLevel), location);
                            waitInput(inputScan);
                            break;
                        }
                        // when it's not from 1-5
                        else{
                            System.out.println("Sorry, the triage level must be integer from 1 to 5. Please enter again");
                            continue;
                        }
                    }
                }
                break;    
                
            case 2:
                clearScreen();
                printSubHeader("Assign Ambulance");
                serviceCenter.assignAmbulanceForPatient();
                waitInput(inputScan);
                break;
            case 3:
                clearScreen();
                printSubHeader("Waiting List");
                serviceCenter.printWaitingList();
                waitInput(inputScan);
                break;
            case 0:
                exitMessage();
                return false;
        }
        return true;

    }

   // 3. Assign Ambulance For Patient By Id
    public static Patient PopByID(int ID, WaitingList waitingList){
        // if the waiting list is empty
        if(waitingList.getHead() == null){
            System.out.println("Congratulations! The waiting list is empty and the ambulance can be started immediately.");
            return null;
        }
        // if not empty
        // if the ID is the head
        if(waitingList.getHead().getPatient().getId() == ID){
            Patient patient = waitingList.getHead().getPatient();
            waitingList.setHead(waitingList.getHead().getNext());
            return patient;
        }
        // if the ID is not the head
        Node currentNode = waitingList.getHead();
        Node nextNode = waitingList.getHead().getNext();
        // this variable is to check if the ID is found
        int foundOrNot = 0;
        while(nextNode != null){
            if(nextNode.getPatient().getId() == ID){
                foundOrNot++;
                currentNode.setNext(nextNode.getNext());
                break;
            }
            currentNode = currentNode.getNext();
            nextNode = nextNode.getNext();
        }
        // if found
        if(foundOrNot > 0){
            System.out.println("Success! An ambulance as assigned for patient <"+nextNode.getPatient().getId()+">.");
            return nextNode.getPatient();
        }
        // if not found
        else{
            System.out.println("Sorry, the ID has not been found in the waiting list");
            return null;
        }
    }


    // 4. Check Position By Id
    public static void checkPositionByID(int ID, WaitingList waitingList){
        // if the waiting list is empty
        if(waitingList.getHead() == null){
            System.out.println("Congratulations! The waiting list is empty and the ambulance can be started immediately.");
            return;
        }
        // if not empty
        Node currentNode = waitingList.getHead();
        // this variable is to check if the ID is found
        int foundOrNot = 0;
        // number of patients
        int totalPatient = 0;
        while(currentNode != null){
            if(currentNode.getPatient().getId() == ID){
                foundOrNot++;
                break;
            }
            totalPatient++;
            currentNode = currentNode.getNext();
        }
        // if found
        if(foundOrNot > 0){
            System.out.println("There are <"+totalPatient+"> patients before patient <"+ID+">.");
            return;
        }
        // if not found
        else{
            System.out.println("Sorry, the ID has not been found in the waiting list");
            return;
        }
    }

    public static void main(String[] args) {
        ServiceCenter serviceCenter = new ServiceCenter();
        initializeSystem(serviceCenter);
        Scanner inputScan = new Scanner(System.in);
        int [] options = new int []{1,2,3,0};
        boolean _continue = true;
        while(_continue){
            clearScreen();
            displayMenu();
            int _option = getOption(inputScan, options);
            if(_option != -1)
                _continue = performAction(serviceCenter, _option, inputScan);
            else
                tryAgain(inputScan);
        }


    }
}

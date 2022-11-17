/*
*   Foundations of Computer Science
*   2020, Trimester 3
*   Practical-Exam-04
*
*   student (id): a1816094
*   student (name): Zikang, Wu
*
* Note: in order to finish your exam you need to make changes in this class
* Note: your are also required to perform small changes, as accessors and mutators;

*
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Company{
	private int maxEmp;
	private int curStaff;
	private Employee [] staff;
	private Sort sorting;
	private Search searching;
	private boolean toLoad;
	public char [] alphas = {'B', 'J', 'M', 'V'};

	// accessors
	public int getMaxEmp(){
		return this.maxEmp;
	}
	public int getCurStaff(){
		return this.curStaff;
	}
	public Employee [] getStaff(){
		return this.staff;
	}
	public Sort getSorting(){
		return this.sorting;
	}
	public Search getSearching(){
		return this.searching;
	}
	public boolean getToLoad(){
		return this.toLoad;
	}
	// mutators
	public void setMaxEmp(int maxEmp){
		this.maxEmp = maxEmp;
	}
	public void setCurStaff(int curStaff){
		this.curStaff = curStaff;
	}
	public void setStaff(Employee [] staff){
		this.staff = staff;
	}
	public void setSorting(Sort sorting){
		this.sorting = sorting;
	}
	public void setSearching(Search searching){
		this.searching = searching;
	}
	public void setToLoad(boolean toLoad){
		this.toLoad = toLoad;
	}

	// search for the alphas
	public int searchAlpha(char n){
		int index = 0;
		for(int i = 0; i < alphas.length; i++){
			if(n == alphas[i]){
				index = i;
				break;
			}
		}
		return index;
	}

	Company(){
		this.staff = new Employee [8];
		this.maxEmp = this.staff.length;
		this.curStaff = 0;
		this.toLoad = true;


		// Sorting setup
		this.sorting = new Insertion();
		//this.sorting = new Selection();


		// Searching setup
		this.searching = new BinarySearch();
		//this.searching = new LinearSearch();
	}

	public void sortStaffByName(){
		String [] names = new String[this.curStaff];
		for(int i=0; i < this.curStaff; i++){
			names[i] = this.staff[i].getName();
			names[i] = names[i].toLowerCase();
		}
		int [] sorted = sorting.sortStringByIndex(names);
		Employee [] tmp = new Employee[maxEmp];
		for(int j=0; j < this.curStaff; j++){
			tmp[j] = this.staff[sorted[j]];
		}
		this.staff = tmp;
	}

	public void searchStaffByAge(int query){
		int [] ages = new int[this.curStaff];
		for(int i=0; i < this.curStaff; i++){
			ages[i] = this.staff[i].getAge();
		}
		int staffIndex = searching.search(ages, query);
		if(staffIndex != -1)
			this.staff[staffIndex].display();
		else
			System.out.println(":: Staff does not exist, try again!");	
	}

	public void searchStaffByName(String query){
		String [] names = new String[this.curStaff];
		for(int i=0; i < this.curStaff; i++){
			names[i] = this.staff[i].getName();
			names[i] = names[i].toLowerCase();
		}
		int staffIndex = searching.search(names, query.toLowerCase());
		if(staffIndex != -1)
			this.staff[staffIndex].display();
		else
			System.out.println(":: Staff does not exist, try again!");	
	}

	public void sortStaffByAge(){
		int [] ages = new int[100];
		for(int i=0; i < 8; i++){
			ages[i] = this.staff[i].getAge();
		}
		int [] sorted = sorting.sortIntByIndex(ages);//, true);
		Employee [] tmp = new Employee[100];
		for(int j=0; j < 8; j++){
			tmp[j] = this.staff[sorted[j]];
		}
		this.staff = tmp;
	}


	public void displayStaff(){
		String header = String.format(":: %s %25s %8s %8s %8s", "Name", "Age", "(hpw)", "(dph)", "(wyears)");
		header += "\n";
		header += "---------------------------------------------------------------";

		System.out.println(":: Display staff members");
		System.out.println(":: Total staff: " + this.curStaff);
		System.out.println(header);
		for(int i = 0; i < this.curStaff; i++){
			staff[i].display();
		}
		header = "";
		if(this.toLoad)
			header += ":: No staff loaded yet!" + "\n";
		header += "---------------------------------------------------------------";
		System.out.println(header);
	}

	public void setStaff(String [] data){
		if(data.length != 5)
			throw new java.lang.Error("::setStaff: incorrect number of args");
			String name = data[0];
			int age = Integer.parseInt(data[1]);
			float dollarsPerHours = Float.parseFloat(data[2]);
			int hoursPerWeek = Integer.parseInt(data[3]);
			int workedYears = Integer.parseInt(data[4]);
			this.staff[this.curStaff] = new Employee(name, age, hoursPerWeek, dollarsPerHours, workedYears);
			this.curStaff++;
	}

	public void loadStaff(String filePath){
		if(this.toLoad){
			System.out.println(":: Loading staff members...");
			try{
				File file = new File(filePath);
		        Scanner inputStream = new Scanner(file);
				inputStream.next();
		        while(inputStream.hasNext()){
	            	String data = inputStream.next();
	            	String [] sData = data.split(",");
					this.setStaff(sData);
				}
				System.out.println(":: " + this.curStaff + " staff members loaded!");
		    }catch (FileNotFoundException e){
	            e.printStackTrace();
	        }
	        this.toLoad = false;
		} else{
			System.out.println(":: Staff members were already loaded!");
			System.out.println(this.curStaff + " staff members loaded!");
		}
	}

	public void setSort(Sort tmpSearch){
		this.sorting = tmpSearch;
	}

	// return true if the array is sorted by age, and false if it is not
	public boolean isSortedByAge(){
		// this variable is to check if sorted or not
		boolean sortOrNot = true;
		for(int i = 0; i < this.staff.length-1; i++){
			// checking if the age is sorted
			if(this.staff[i+1].getAge() < this.staff[i].getAge()){
				sortOrNot = false;
				break;
			}
		}
		return sortOrNot;
		
	}

	// return true if the array is sorted by name, and false if it is not
	public boolean isSortedByName(){
		// this variable is to check if sorted or not
		boolean sortOrNot = true;
		for(int i = 0; i < this.staff.length-1; i++){
			// checking if the age is sorted
			if(searchAlpha(this.staff[i+1].getName().charAt(0)) > searchAlpha(this.staff[i].getName().charAt(0))){
				sortOrNot = false;
				break;
			}	
		}
		return sortOrNot;
	}

}
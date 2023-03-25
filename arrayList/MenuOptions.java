package arrayList;

import java.util.*;

class Student {
	private String name;
	private int age;
	private double grade;
	
	public Student(String name, int age, double grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	
	public String getName() {
		return name;
	}

	public double getGrade() {
		return grade;
	}


	public void printMethod() {
		System.out.println("The student " + name + " has " + age + " years and his grade is: " + grade);
	}
}


class StudentManager {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void removeStudent(String name) {
		Iterator<Student> iterator = studentList.iterator();
		boolean tester = false;
		int index = 0;
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.getName().equals(name)) {
				index++;
				if(index > 1)
					{
					iterator.remove();	tester = true;
					}
			}
		}
		if(tester) {
			System.out.println("\nAll the students with the name "+name+", except the first one, were removed.");
		}
		else
			System.out.println("There are not students with the name: "+name);
	}
	
	public void listStudents() {
		Iterator<Student> iterator = studentList.iterator();
		while(iterator.hasNext()) {
			Student a = iterator.next();
			a.printMethod();
		}
		System.out.println();
	}
	
	public double gradeAverage() {
		double average = 0;
		Iterator<Student> iterator = studentList.iterator();
		while(iterator.hasNext()) {
			double number = iterator.next().getGrade();
			average += number;
		}
		
		return average / studentList.size();
	}
	
	public void sortStudents() {
		Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade).reversed());
		listStudents();
	}
}

public class MenuOptions {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StudentManager manag = new StudentManager();
		
		int choice;
		while(true) {
		System.out.println("Please choose one of the actions below:");
		
		System.out.println("[1]Add Student");
		System.out.println("[2]Remove Student");
		System.out.println("[3]List Students");
		System.out.println("[4]Display Average Grade");
		System.out.println("[5]Sort the list according to their averages");
		System.out.println("[0]Quit");
		
		choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Choose a name");
			String name1 = scanner.next();
			if(!scanner.hasNextLine()) {
				System.out.println("Please insert a proper name.");
				break;
			}
			System.out.println("Choose an age for the student");
			int age = scanner.nextInt();
			System.out.println("Choose his grade");
			double grade = scanner.nextDouble();
			if(grade < 1 || grade > 10 )
			{
				System.out.println("You cannot enter a grade higher than 10 or lower than 1.\n");
				break;
			}
			Student student = new Student(name1, age, grade);
			
			manag.addStudent(student);
			break;
		case 2:
			System.out.println("Choose the student you want to remove: ");
			String name2 = scanner.next();
			manag.removeStudent(name2);;
			break;
		case 3:
			manag.listStudents();
			System.out.println();
			break;
		case 4:
			System.out.println("The average grade of the students is: " + manag.gradeAverage());
			break;
		case 5:
			manag.sortStudents();
			break;
		case 0:
			System.out.println("Program finished!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Choose between [0] to [5].");
		}
		
	}

	}

}


package studentjdbc;

import java.util.Scanner;

public class StudentData {
	
	static void updateItem(Scanner sc) {
		System.out.println("1. Insert student record\t 2. Update student record\t 3. Delete student record");
		System.out.print("Please select an option: ");
		int option = sc.nextInt();
		if(option == 1) {
			sc.nextLine();
			System.out.println("Enter name: ");
			String name = sc.nextLine();
			System.out.println("Enter address: ");
			String address = sc.nextLine();
			System.out.println("Enter gender: ");
			String gender = sc.nextLine();
			System.out.println("Enter date of joining: ");
			String doj = sc.nextLine();
			System.out.println("Enter student id: ");
			int id = sc.nextInt();

			StudentDetails sd = new StudentDetails(name, address, gender, doj, id);
			System.out.println(sd);
			
			boolean insertion=StudentUpdation.insertStudent(sd);
			if(insertion) {
				System.out.println("Inserted Successfully");
			}else {
				System.out.println("Oops! Something went wrong while inserting");
			}
			
		}
		else if(option == 2) {
			sc.nextLine();
			System.out.print("Enter student id to be updated: ");
			Integer uId = sc.nextInt();
			sc.nextLine();
			System.out.println("Which field do you want to update? ");
			System.out.println("1. Name\t 2. Address\t 3. Gender\t 4. Doj");
			Integer fId=sc.nextInt();
			sc.nextLine();
			boolean updation=false;
			System.out.println("Enter value to update: ");
			if(fId==1) {
				String nameEntered=sc.nextLine();
				updation = StudentUpdation.updateStudent("name", nameEntered, uId);
			}
			else if(fId==2) {
				String addressEntered=sc.nextLine();
				updation = StudentUpdation.updateStudent("address", addressEntered, uId);
			}
			else if(fId==3) {
				String genderEntered=sc.nextLine();
				updation = StudentUpdation.updateStudent("gender", genderEntered, uId);
			}
			else if(fId==4) {
				String dojEntered=sc.nextLine();
				updation = StudentUpdation.updateStudent("doj", dojEntered, uId);
			}
			
			if(updation) {
				System.out.println("Updated Successfully");
			}else {
				System.out.println("Oops! Something went wrong while updating");
			}
		}
		else if(option == 3) {
			sc.nextLine();
			System.out.print("Enter student id to be Deleted: ");
			Integer delId = sc.nextInt();
			sc.nextLine();
			boolean deletion = StudentUpdation.deleteStudent(delId);
			if(deletion) {
				System.out.println("deleted Successfully");
			}else {
				System.out.println("Oops! Something went wrong while deletion");
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("1. Create\t 2. Read\t 3. Update\t 4. Delete\t 5. Exit");
			System.out.print("Please select an option: ");
			int optionSelected = sc.nextInt();
			if(optionSelected == 1) {
				boolean ins = StudentUpdation.createTable();
				if(ins) {
					System.out.println("Table created successfully");
				}else {
					System.out.println("Oops something went wrong while creating table...");
				}
			}
			else if(optionSelected == 2) {
				StudentUpdation.readStudentData();
			}
			else if(optionSelected == 3) {
				
				StudentData.updateItem(sc);
				
			}
			else if(optionSelected == 4) {
				boolean del = StudentUpdation.deleteTable();
				if(del) {
					System.out.println("Table deleted successfully");
				}else {
					System.out.println("Oops something went wrong while deleting table...");
				}
			}
			else if(optionSelected == 5) {
				System.out.println("Thank you... Bye!");
				break;
			}else {
				continue;
			}
		}

	}

}

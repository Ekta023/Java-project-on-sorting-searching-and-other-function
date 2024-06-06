package CS401prj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CS401prj {
    public static void main(String[] args) {
        
    	// Read data from the text file
        EmployeeList empList = readDataFromFile("employeeNames.txt");
        
        System.out.println("Employee list before sorting:");
        empList.displayList();
    	
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        // Read data from the text file
        EmployeeList employeeList = readDataFromFile("employeeNames.txt");
        
    	// Menu for sorting and searching
        while (true) {
        	
            System.out.println("\nMenu:");
            System.out.println("1. Sort the list");
            System.out.println("2. Search the list");
            System.out.println("3. Add data to the list");
            System.out.println("4. Delete data from the list");
            System.out.println("5. Restore an employee from the deleted data list");
            System.out.println("6. Update the name of an empployee from the list");
            System.out.println("7. Analyze the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // // Read data from the text file
            // EmployeeList employeeList = readDataFromFile("CS401_Final_Project/src/employeeNames.txt");
        	
            switch (choice) {
                case 1:
                    // Sorting menu
                    System.out.println("\nSorting Algorithms:");
                    System.out.println("1. Insertion Sort");
                    System.out.println("2. Quick Sort");
                    System.out.print("Choose sorting algorithm (1 or 2): ");
                    int sortAlgorithm = scanner.nextInt();

                    // Perform sorting based on user choice
                    employeeList.sortList(sortAlgorithm);

                    // Display the sorted list
                    employeeList.displayList();
                    
                    break;
                case 2:
                    // Searching menu
                    System.out.println("\nSearching Algorithms:");
                    System.out.println("1. Linear Search (done on unsorted data)");
                    System.out.println("2. Binary Search Tree (Binary search, requires sorting first)");
                    System.out.println("3. Hash Function Search");
                    System.out.print("Choose searching algorithm (1, 2, or 3): ");
                    int searchAlgorithm = scanner.nextInt();
                    
                    // Perform searching based on user choice
                    employeeList.searchList(searchAlgorithm);

                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter the new employee name: ");
                    String newEmployee = scanner.nextLine();
                    employeeList.addEmployee(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter the employee name to delete: ");
                    String employeeToDelete = scanner.nextLine();
                    employeeList.deleteEmployee(employeeToDelete);
                    System.out.println("Employee deleted successfully.");
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter the employee name to restore: ");
                    String employeeToRestore = scanner.nextLine();
                    employeeList.restoreEmployee(employeeToRestore);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.print("Enter the employee name to update: ");
                    String employeeToUpdate = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    employeeList.updateEmployee(employeeToUpdate, newName);
                    System.out.println("Employee updated successfully.");
                    break;
                case 7:
                    employeeList.analyzeData();
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            
        } 

    }

    private static EmployeeList readDataFromFile(String fileName) {
        EmployeeList employeeList = new EmployeeList();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line in the file contains an employee name
                employeeList.addEmployee(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading data from file: " + e.getMessage());
        }

        return employeeList;
    }
}

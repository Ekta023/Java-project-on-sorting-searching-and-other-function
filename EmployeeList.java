package CS401prj;

import java.util.Scanner;
import java.util.Arrays;

public class EmployeeList {
	protected String[] employees;
	private int comparisonCount; // Counter for comparisons
    private String[] deletedEmployees ;
    private int addCount = 0;
    private int deleteCount = 0;
    private int updateCount = 0;
    private int restoreCount = 0;

    // Constructor
    public EmployeeList() {
        this.employees = new String[0];
        this.comparisonCount = 0;
        this.deletedEmployees = new String[0] ;
    }

    // Method to get the number of employees 
    public int getEmployeeCount() {
        return this.employees.length;
    }

    // Method to display the original or sorted list
    public void displayList() {
        int numColumns = 4; // Define the number of columns
        int count = 0; // Counter to track printed employees
        
        for (int i = 0; i < this.employees.length; i++) {
            if (employees[i] != null) {
                System.out.printf("%-28s", i+1 + ": " + employees[i].toString());
                count++;
                if (count % numColumns == 0) {
                    System.out.println();
                }
            }
        }
        // Check for remaining employees if the total number of employees is not a multiple of numColumns
        if (count % numColumns != 0) {
            System.out.println();
        }
    }


// ***********************************************************************************
    // Method to perform sorting based on the selected algorithm
    public void sortList(int algorithmChoice) {
        comparisonCount = 0; // Reset comparison count before sorting
        switch (algorithmChoice) {
            case 1:
                insertionSort();
                break;
            case 2:
                quickSort(0, this.employees.length - 1);
                break;
            default:
                System.out.println("Invalid sorting algorithm choice.");
        }
        System.out.println("Total comparisons during sorting: " + comparisonCount);
    }

    // Insertion Sort
    private void insertionSort() {
        int n = this.employees.length;
        for (int i = 1; i < n; ++i) {
            String key = this.employees[i];
            int j = i - 1;

            while (j >= 0 && this.employees[j].compareTo(key) > 0) {
                employees[j + 1] = this.employees[j];
                j = j - 1;
                comparisonCount++; // Count each comparison
            }
            this.employees[j + 1] = key;
        }
    }

    // Quick Sort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        // Choose the pivot as the median of three elements
        int mid = low + (high - low) / 2;
        int pivotIndex = getMedianOfThree(low, mid, high);

        // Swap the pivot element with the last element
        swap(pivotIndex, high);

        String pivot = this.employees[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (this.employees[j].compareTo(pivot) < 0) {
                i++;

                // Swap elements at i and j
                swap(i, j);
            }
            this.comparisonCount++; // Count each comparison
        }

        // Swap the pivot element back to its correct position
        swap(i + 1, high);

        return i + 1;
    }

    private void swap(int i, int j) {
        String temp = employees[i];
        employees[i] = employees[j];
        employees[j] = temp;
    }

    private int getMedianOfThree(int i, int j, int k) {
        // Find the median index among i, j, and k
        if (this.employees[i].compareTo(employees[j]) < 0) {
            if (employees[j].compareTo(employees[k]) < 0) {
                return j;
            } else if (employees[i].compareTo(employees[k]) < 0) {
                return k;
            } else {
                return i;
            }
        } else {
            if (employees[k].compareTo(employees[j]) < 0) {
                return j;
            } else if (employees[k].compareTo(employees[i]) < 0) {
                return k;
            } else {
                return i;
            }
        }
    }

 // ***********************************************************************************
    // Method to perform searching based on the selected algorithm
    public void searchList(int algorithmChoice) {
        comparisonCount = 0; // Reset comparison count before searching
        boolean found;
        switch (algorithmChoice) {
            case 1:
                // Linear Search
                System.out.print("Enter the employee name to search: ");
                String linearSearchKey = new Scanner(System.in).nextLine();
                linearSearchKey = linearSearchKey.strip() ;
                found = linearSearch(linearSearchKey);
                
                if (found) { System.out.println("\n" + linearSearchKey + " is found in the array using linear search."); } 
                else { System.out.println("\n" + linearSearchKey + " not found in the array using linear search."); }
                
                break;
            case 2:
                // Binary Search (requires sorting first)
                System.out.print("Enter the employee name to search: ");
                String binarySearchKey = new Scanner(System.in).nextLine();
                binarySearchKey = binarySearchKey.strip() ;
                found = binarySearchTreeSearch(binarySearchKey);
                
                if (found) { System.out.println("\n" + binarySearchKey + " is found in the balanced Binary Search Tree."); } 
                else { System.out.println("\n" + binarySearchKey + " not found in the balanced Binary Search Tree."); }
                
                break;
            case 3:
                // Hash Function Search
                System.out.print("Enter the employee name to search: ");
                String hashSearchKey = new Scanner(System.in).nextLine();
                hashSearchKey = hashSearchKey.strip() ;
                found = hashFunctionSearch(hashSearchKey);
                
                if (found) { System.out.println("\n" + hashSearchKey + " is found in the Hash Table."); } 
                else { System.out.println("\n" + hashSearchKey + " not found in the Hash Table."); }
                
                break;
            default:
                System.out.println("Invalid searching algorithm choice.");
        }
        System.out.println("Total comparisons during searching: " + comparisonCount);
    }

    // Linear Search
    private boolean linearSearch(String key) {
    	
    	for (int i = 0; i < employees.length; i++) {
            this.comparisonCount++; // Count each comparison
            if (this.employees[i].equals(key)) {
                return true;
            }
        }
    	return false;
    }
    
    // Binary Search Tree Search
    private boolean binarySearchTreeSearch(String key) {
    	insertionSort();
    	System.out.println("\nI have created a balanced BST,which requires sorting the elements first.");
    	System.out.println("Total comparisons during this sorting: " + comparisonCount);
    	
    	comparisonCount = 0; // Reset comparison count before searching
        
        // Example usage
        String[] sortedArray = employees; // Assuming you have a sorted array
        
        // Initialize the sorted array with values...
        BalancedBinarySearchTree bst = new BalancedBinarySearchTree(sortedArray);

        return bst.search(key);
    }

    
    // Hash Function Search
    private boolean hashFunctionSearch(String key) {
    	int TABLE_SIZE = 1500; // Size of the hash table
    	comparisonCount = 0; // Reset comparison count before searching

        // Create an array of buckets
        String[][] hashTable = new String[TABLE_SIZE][0];

        // Insert employees into the hash table
        for (String employee : this.employees) {
            int hash = simpleHashFunction(employee, TABLE_SIZE);
            hashTable[hash] = Arrays.copyOf(hashTable[hash], hashTable[hash].length + 1);
            hashTable[hash][hashTable[hash].length - 1] = employee;
            // System.out.println(hash + " : " + hashTable[hash][hashTable[hash].length - 1]);
        }

        // Search for the key in the appropriate bucket
        int hash = simpleHashFunction(key, TABLE_SIZE);
        for (String employee : hashTable[hash]) {
            comparisonCount++; // Count each comparison
            if (employee.equals(key)) {
                System.out.println("Employee found.");
                return true;
            }
        }
        
        return false;
    }

    // A simple hash function for demonstration purposes
    private int simpleHashFunction(String key, int tableSize) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    // Return the employees
	public String[] getEmployees() {
		return this.employees;
	}
	
// ***********************************************************************************
	// Balanced binary search tree 
	class BalancedBinarySearchTree {
	    private String[] sortedArray;
	    private Node root;

	    // Node class for the binary search tree
	    private static class Node {
	        String data;
	        Node left, right;

	        public Node(String data) {
	            this.data = data;
	            this.left = this.right = null;
	        }
	    }

	    // Constructor to create a balanced binary search tree from a sorted array
	    public BalancedBinarySearchTree(String[] sortedArray) {
	        this.sortedArray = sortedArray;
	        this.root = sortedArrayToBST(0, sortedArray.length - 1);
	        comparisonCount = 0;
	    }

	    // Recursive method to convert a sorted array to a balanced binary search tree
	    private Node sortedArrayToBST(int start, int end) {
	        if (start > end) {
	            return null;
	        }

	        int mid = (start + end) / 2;
	        Node node = new Node(sortedArray[mid]);

	        node.left = sortedArrayToBST(start, mid - 1);
	        node.right = sortedArrayToBST(mid + 1, end);

	        return node;
	    }

	    // Method to search for an element in the balanced binary search tree
	    public boolean search(String key) {
	        return searchRecursive(root, key);
	    }

	    private boolean searchRecursive(Node root, String key) {
	    	comparisonCount++;
	        if (root == null) {
	            return false;
	        }
	        
	        int compareResult = key.compareTo(root.data);

	        // System.out.println("root: " + root.data + ", compareResult: " + compareResult);
	        if (compareResult == 0) {
	            return true;  // Element found
	        } else if (compareResult < 0) {
	            return searchRecursive(root.left, key);  // Search in the left subtree
	        } else {
	            return searchRecursive(root.right, key); // Search in the right subtree
	        }
	    }
	}
	
// ***********************************************************************************

    // Method to add an employee to the list
    public void addEmployee(String employee) {
        this.employees = Arrays.copyOf(getEmployees(), getEmployees().length + 1);
        this.employees[this.employees.length - 1] = employee;
        // System.out.println(this.employees[this.employees.length - 1]);
        addCount ++ ;
        // System.out.println("ADDED: " + employee);
    }


    // Method to delete an employee from the list 
    public void deleteEmployee(String employee) {
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            deletedEmployees = Arrays.copyOf(deletedEmployees, deletedEmployees.length + 1);
            deletedEmployees[deletedEmployees.length - 1] = employees[index];
            this.employees = removeElementFromArray(employees, index);
            deleteCount ++ ;
        } else {
            System.out.println("Employee not found in the list.");
        }
    }
    
    // Helper method to create a list without the specified index
    private String[] removeElementFromArray(String[] arr, int index) {
        String[] newArr = new String[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    // Method to update the name of an employee if he exists in the list
    public void updateEmployee(String oldName, String newName) {
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(oldName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.employees[index] = newName;
            updateCount ++ ;
        } else {
            System.out.println("Employee not found in the list.");
        }
    }

    // Method to restore the deleted employees
    public void restoreEmployee(String employee) {
        // Check if the employee is in the deletedEmployees array
        int index = -1;
        for (int i = 0; i < deletedEmployees.length; i++) {
            if (deletedEmployees[i].equals(employee)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            // Restore the employee by adding it back to the employees array
            this.employees = Arrays.copyOf(employees, employees.length + 1);
            this.employees[employees.length - 1] = deletedEmployees[index];
            restoreCount ++ ;
            // Remove the employee from the deletedEmployees array
            deletedEmployees = removeElementFromArray(deletedEmployees, index);
            
            System.out.println("Employee " + employee + " has been restored.");
        } else {
            System.out.println("Employee " + employee + " not found in the deleted list.");
        }
    }

    // Method to print out the operations done on the data
    public void analyzeData() {
        System.out.println("\nData Analysis Report:");
        System.out.println("Number of employees added: " + addCount);
        System.out.println("Number of employees del_eted: " + deleteCount);
        System.out.println("Number of employees updated: " + updateCount);
        System.out.println("Number of employees restored: " + restoreCount);
    }


}

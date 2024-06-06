# CS401 Software Project - Employee Data Management

## Overview

This project is developed as part of the CS401 course to implement sorting and searching algorithms along with additional functionalities for managing employee data. The application allows users to create, sort, search, and manage a list of employee IDs and names through a menu-driven interface.

## Features

1. **Sorting Algorithms**:
   - **Simple Sorting**: Selection Sort, Insertion Sort, or Bubble Sort
   - **O(Nlog2N) Sorting**: Quick Sort, Merge Sort, or Heap Sort
   - Users can select two sorting algorithms (one from each group) to sort the employee list and compare their performance based on the number of comparisons.

2. **Searching Algorithms**:
   - **Linear Search**: Search through the original list.
   - **Binary Search Tree (BST)**: Search through a BST created from the sorted list.
   - **Hash Function Search**: Search through a hash table created from the data.
   - Users can compare the complexities and performance of different searching methods.

3. **Data Management Functions**:
   - **Status of Data Quantity**: Display the total number of employees in the list.
   - **Add Data**: Add new employee data to the list.
   - **Delete Data**: Remove employee data from the list.
   - **Update Data**: Modify existing employee data.
   - **Restore Data**: Restore previously deleted employee data.
   - **Analyze Data**: Generate an analysis report of the data and operations performed.

## Project Structure

- **CS401prj.java**: The main application program containing the menu-driven interface and main method.
- **EmployeeList.java**: User-defined class providing implementations for sorting, searching, and data management functions.

## How to Run the Project

1. **Compile the Java Files**:
   ```sh
   javac CS401prj.java EmployeeList.java
   ```

2. **Run the Main Program**:
   ```sh
   java CS401prj
   ```

3. **Follow the On-Screen Menu**:
   - The main menu allows you to choose between different sorting and searching algorithms, and manage employee data.
   - Select the desired option and follow the prompts to perform operations.

## Example Usage

1. **Create a List**:
   - The program prompts the user to input employee data or load from a file.
   - Example format: `John Doe`

2. **Sort the List**:
   - Choose sorting algorithms and compare their performance.

3. **Search the List**:
   - Perform linear search, BST search, and hash function search on the employee list.

4. **Manage Data**:
   - Add, delete, update, and restore employee data as needed.
   - Generate and view an analysis report.

## Notes

- Ensure the data file follows the correct format: `Name`
- The application handles invalid inputs and provides appropriate error messages for user corrections.
- All functionalities are designed, implemented, and tested based on the project requirements.

## Conclusion

This project provides a comprehensive solution for managing and analyzing employee data using various sorting and searching algorithms. The implementation highlights the complexities and performance differences of these algorithms, offering valuable insights into their theoretical and practical applications.

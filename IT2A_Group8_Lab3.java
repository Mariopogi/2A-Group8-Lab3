/*  SORTING ALGORITHMS MENU PROGRAM - This program provides a menu for users to select and run various sorting algorithms on a array set.
    Group 8
    Authors: Domingo, Mario Jr. C. (Leader)
             Dela Cruz, Bic Julian (Members)
             VioVicente, Kevin Christian
    Laboratory Exercise #3
    Date: 9/21/2025

*/

import java.util.Scanner;

public class IT2A_Group8_Lab3 {
    static Scanner scanner = new Scanner(System.in);
    static Integer[] arr = null; // reference to the array
    static boolean isArrayCreated = false; // track if array exists
    public static void main(String[] args) {
        
        createArray();

        int choice;

        while (isArrayCreated) {
            System.out.println("-----------------------------------------");
            System.out.println("     SORTING ALGORITHMS MENU PROGRAM     ");
            System.out.println("-----------------------------------------\n");
            System.out.println("[1] Bubble Sort");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Insertion Sort");
            System.out.println("[4] Exit");
            System.out.print("Enter Choice: ");

            // Validate input once
            Integer validatedChoice = getValidatedInput();

            // If validation failed, go back to menu
            if (validatedChoice == null) {
                continue;
            }

            choice = validatedChoice;

            switch (choice) {
                case 1:
                    bubbleSort();
                    break;
                case 2:
                    System.out.println("Selection sort");
                    break;
                case 3:
                    System.out.println("Insertion sort");
                    break;
                case 4:
                    if (exit()) {
                        return; // stop program
                    } else {
                        System.out.println(""); 
                        createArray();
                        break; 
                    }
                default:
                    System.out.println("Invalid choice. Please select from 1, 2, 3, or 4 only.\n");
            }
        }
    }

    // Create and insert array elements
    public static void createArray() {
        System.out.println("-----------------------------------------");
        System.out.println("     SORTING ALGORITHMS MENU PROGRAM     ");
        System.out.println("-----------------------------------------\n");

         while (true) {
            // Create array - Ask for array size (only if not created yet or if user wants new array)
            if (!isArrayCreated) {
                Integer arraySize = null;

                while (arraySize == null) {
                    System.out.print("Enter Array Size: ");
                    Integer input = getValidatedInput();

                    if (input != null) {
                        if (input >= 5 && input <= 15) {
                            arraySize = input;
                        } else {
                            System.out.println("Error: Array size should be in a range of 5 - 15.\n");
                        }
                    }
                }

                // Input array elements
                while (true) {
                    System.out.print("Enter " + arraySize + " Array Elements: ");
                    String line = scanner.nextLine().trim();

                    if (line.isEmpty()) {
                        System.out.println("Error: Input cannot be empty. Please enter numbers separated by spaces.\n");
                        continue;
                    }

                    // Makes sure that even if the user types multiple spaces between numbers, it still works.
                    String[] parts = line.split("\\s+");

                    // Check if all input are numbers
                    boolean allNumbers = true;
                    for (String part : parts) {
                        try {
                            Integer.parseInt(part);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input. Please enter only numbers.\n");
                            allNumbers = false;
                            break;
                        }
                    }
                    if (!allNumbers) continue;

                    // Now check if the count is correct
                    if (parts.length != arraySize) {
                        System.out.println("Error: You must enter exactly " + arraySize + " numbers.\n");
                        continue;
                    }

                    // Store the numbers into the array
                    arr = new Integer[arraySize];
                    for (int i = 0; i < arraySize; i++) {
                        arr[i] = Integer.parseInt(parts[i]);
                    }
                    break; // exit only when everything is valid
                }

                isArrayCreated = true;
            }

            // Display entered array
            System.out.print("\nArray Elements: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
            break;
        }
    }

    // Input Validation Method
    public static Integer getValidatedInput() {
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input cannot be empty. Please enter a valid number.\n");
            return null; // invalid input = back to menu
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.\n");
            return null; // invalid input = back to menu
        }
    }

    // Bubble sort method
    public static void bubbleSort() {
        int n = arr.length;

        System.out.println("\nBubble Sort");
        System.out.print("\nGiven Array Elements:");

        for (int num : arr) {
            System.out.printf(" %2d ", num);
        }
        System.out.println("\n");

        // Bubble Sort (largest value to the end using pair-wise comparisons and swapping)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // Print array after each pass
            System.out.print((i + 1) + ".");
            for (int num : arr) {
                System.out.printf(" %5d ", num);
            }
            System.out.println();
        }

        // Final sorted array
        System.out.print("\nThe Sorted Array Elements: ");
        for (int num : arr) {
            System.out.printf(" %2d ", num);
        }

        System.out.print("\nPress any key to continue...");
        scanner.nextLine();
        System.out.println("");
    }

    // Selection sort method

    // Insertion sort method

    // Exit method
    public static boolean exit() {
        while (true) {
            System.out.print("\nTry Again (Y/N)? ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                isArrayCreated = false; // reset so new array will be created next time
                return false;  // repeat process
            } else if (input.equalsIgnoreCase("N")) {
                System.out.println("Exiting the program. Goodbye!");
                return true; // terminate program
            } else if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please enter Y or N only\n");
            } else {
                System.out.println("Error: Invalid input. Please enter Y or N only.\n");
            }
        }
    }

}
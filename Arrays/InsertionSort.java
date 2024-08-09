package Arrays;
import java.util.*;
public class InsertionSort{

    // Function to print the elements of an array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each element
        }
        System.out.println();  // Print a new line after the array
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 9, 5};  // Initialize the array to be sorted

        // Insertion sort algorithm
        for (int i = 1; i < arr.length; i++) {  // Start from the second element
            int current = arr[i];  // The element to be inserted into the sorted part of the array
            int j = i - 1;  // Pointer to compare with elements in the sorted part of the array

            // Move elements of arr[0..i-1], that are greater than current, to one position ahead
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];  // Shift element to the right
                j--;  // Move to the previous element
            }

            // Place the current element at its correct position
            arr[j + 1] = current;
        }

        // Print the sorted array
        printArray(arr);
    }
}


/*
 * Explanation:
Initial Setup:

int arr[] = {2, 7, 1, 9, 5};
This is the array to be sorted.
Outer Loop:

for (int i = 1; i < arr.length; i++)
The outer loop starts from the second element and goes through to the end of the array. This is because the first element is trivially sorted.
Current Element:

int current = arr[i];
current is the element that needs to be placed in the correct position in the sorted portion of the array.
Inner Loop:

while (j >= 0 && current < arr[j])
This loop moves elements that are greater than current one position to the right to make space for current.
Placement:

arr[j + 1] = current;
Once the correct position is found (where all elements before j are less than current), current is placed at that position.
Print Sorted Array:

printArray(arr);
After sorting, the sorted array is printed.
Visualization:
For the array {2, 7, 1, 9, 5}, here’s how the insertion sort algorithm works step by step:

Initial Array: 2, 7, 1, 9, 5

Pass 1 (i = 1):

current = 7
Compare with 2 (no change needed).
Array remains: 2, 7, 1, 9, 5
Pass 2 (i = 2):

current = 1
Compare with 7 → Shift 7 to the right.
Compare with 2 → Shift 2 to the right.
Place 1 in the correct position.
Array becomes: 1, 2, 7, 9, 5
Pass 3 (i = 3):

current = 9
Compare with 7 (no change needed).
Array remains: 1, 2, 7, 9, 5
Pass 4 (i = 4):

current = 5
Compare with 9 → Shift 9 to the right.
Compare with 7 → Shift 7 to the right.
Place 5 in the correct position.
Array becomes: 1, 2, 5, 7, 9
Final Sorted Array: 1, 2, 5, 7, 9

Insertion sort builds the sorted array one element at a time, making it suitable for small datasets or nearly sorted data.
 */
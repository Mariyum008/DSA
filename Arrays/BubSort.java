package Arrays;
import java.util.*;
public class BubSort{
  // Function to print the elements of an array
  public static void printArray(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");  // Print each element
      }
      System.out.println();  // Print a new line after the array
  }

  public static void main(String[] args) {

      int arr[] = {2, 7, 1, 9, 5};  // Initialize the array to be sorted

      // Bubble sort algorithm
      for (int i = 0; i < arr.length - 1; i++) {  // Outer loop for each pass
          for (int j = 0; j < arr.length - 1 - i; j++) {  // Inner loop to compare adjacent elements
              if (arr[j] > arr[j + 1]) {  // If the current element is greater than the next
                  // Swap the elements
                  int temp = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = temp;
              }
          }
      }

      // Print the sorted array
      printArray(arr);
  }
}


// Explanation:
// Outer Loop:

// for (int i = 0; i < arr.length - 1; i++)
// This loop controls the number of passes through the array. After each pass, the largest element in the unsorted portion of the array "bubbles up" to its correct position.
// Inner Loop:

// for (int j = 0; j < arr.length - 1 - i; j++)
// This loop compares adjacent elements and swaps them if they are in the wrong order (i.e., if the left element is greater than the right element).
// The - i part ensures that with each subsequent pass, the inner loop doesn't re-check elements that have already been sorted in previous passes.
// Swap Operation:

// int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
// If two adjacent elements are out of order, they are swapped.
// Print Array:

// printArray(arr);
// After sorting, the array is printed to show the sorted order.
// Visualization:
// For the array {2, 7, 1, 9, 5}, here’s how the sorting happens:

// Initial Array: 2, 7, 1, 9, 5

// Pass 1:

// Compare 2 and 7 → No swap needed.
// Compare 7 and 1 → Swap → 2, 1, 7, 9, 5
// Compare 7 and 9 → No swap needed.
// Compare 9 and 5 → Swap → 2, 1, 7, 5, 9
// Pass 2:

// Compare 2 and 1 → Swap → 1, 2, 7, 5, 9
// Compare 2 and 7 → No swap needed.
// Compare 7 and 5 → Swap → 1, 2, 5, 7, 9
// Pass 3:

// Compare 1 and 2 → No swap needed.
// Compare 2 and 5 → No swap needed.
// Pass 4:

// Compare 1 and 2 → No swap needed.
// Final Sorted Array: 1, 2, 5, 7, 9

// This way, the Bubble Sort algorithm sorts the array in ascending order.
package Arrays;
import java.util.*;
public class quickSort{

    // This function takes the last element as pivot, places it in the correct
    // position in the sorted array, and places all smaller elements to the left of the pivot
    // and all larger elements to the right of the pivot.
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];  // Choose the last element as the pivot
        int i = low - 1;  // Pointer for the smaller element (initially set before the start)

        // Traverse through all elements and compare each one with the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {  // If current element is smaller than or equal to pivot
                i++;  // Move the smaller element pointer to the right
                // Swap the current element with the element at the smaller element pointer
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place the pivot in its correct position by swapping with the element at i+1
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;  // Return the index of the pivot element
    }

    // Main function that implements QuickSort
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {  // Check if there are at least two elements to sort
            int pidx = partition(arr, low, high);  // Partition the array and get the pivot index

            // Recursively sort elements before and after partition
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 6, 10, 5, 9, 2, 1, 5, 7};  // Example array to be sorted
        int n = arr.length;  // Get the size of the array
        quickSort(arr, 0, n - 1);  // Call quickSort on the entire array

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


// Pivot Selection:

// The pivot is the last element in the array/subarray.
// Goal: Place the pivot in the correct position so that all elements to its left are smaller, and all elements to its right are larger.
// Partition Process:

// A pointer i starts before the first element.
// Traverse through the array with another pointer j.
// If an element is smaller than or equal to the pivot, increment i and swap arr[i] with arr[j].
// Final Swap:

// After the loop, the pivot is swapped with the element at i+1, placing it in its correct position.
// The index i+1 is returned as the pivot's final position
// Initial Array: 7, 6, 10, 5, 9, 2, 1, 5, [7]
//                                            ^ 
//                                       Pivot Element
                                      
// Step 1: j = 0, Compare 7 with Pivot 7 (No Swap Needed)

// Step 2: j = 1, Compare 6 with Pivot 7 
//    - i increments to 0
//    - Swap arr[i] and arr[j] (no change needed)

// Step 3: j = 2, Compare 10 with Pivot 7 (No Swap Needed)

// Step 4: j = 3, Compare 5 with Pivot 7 
//    - i increments to 1
//    - Swap arr[i] and arr[j] 
   
//     Array becomes: 7, 5, 10, 6, 9, 2, 1, 5, [7]

// ...

// Step 7: j = 7, Compare 5 with Pivot 7
//    - i increments to 5
//    - Swap arr[i] and arr[j]
   
//     Array becomes: 7, 5, 6, 5, 9, 2, 1, 10, [7]

// Final Step: Place Pivot in Correct Position
//    - Swap arr[i+1] with Pivot
   
//     Sorted array: 7, 5, 6, 5, 7, 2, 1, 10, 9
//                     ^                ^
//                 Pivot Index        Pivot Index

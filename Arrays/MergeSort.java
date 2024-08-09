package Arrays;
public class MergeSort {

    // Function to merge two sorted subarrays into a single sorted array
    public static void Conquer(int arr[], int si, int mid, int ei) {
        // Create a temporary array to hold the merged result
        int Merged[] = new int[ei - si + 1];
        int idx1 = si;  // Start index for the first subarray
        int idx2 = mid + 1;  // Start index for the second subarray
        int x = 0;  // Index for the temporary array

        // Merge the two subarrays while comparing their elements
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                Merged[x++] = arr[idx1++];  // Take element from the first subarray
            } else {
                Merged[x++] = arr[idx2++];  // Take element from the second subarray
            }
        }

        // Copy remaining elements from the first subarray (if any)
        while (idx1 <= mid) {
            Merged[x++] = arr[idx1++];
        }

        // Copy remaining elements from the second subarray (if any)
        while (idx2 <= ei) {
            Merged[x++] = arr[idx2++];
        }

        // Copy the merged result back into the original array
        for (int i = 0, j = si; i < Merged.length; i++, j++) {
            arr[j] = Merged[i];
        }
    }

    // Function to divide the array into subarrays and sort them
    public static void Divide(int arr[], int si, int ei) {
        if (si >= ei) {  // Base case: single element or invalid subarray
            return;
        }
        int mid = si + (ei - si) / 2;  // Find the middle index
        Divide(arr, si, mid);  // Recursively divide the left subarray
        Divide(arr, mid + 1, ei);  // Recursively divide the right subarray
        Conquer(arr, si, mid, ei);  // Merge the sorted subarrays
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 2, 8, 3, 9};  // Example array to be sorted
        int n = arr.length;

        Divide(arr, 0, n - 1);  // Start the divide and conquer process

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
/*
 Explanation:
Conquer Function:

Purpose: Merges two sorted subarrays into a single sorted subarray.
Parameters:
arr[] - The original array.
si - Start index of the first subarray.
mid - End index of the first subarray (one less than the start index of the second subarray).
ei - End index of the second subarray.
Process:
Compare elements from both subarrays and merge them into a temporary array Merged.
Copy any remaining elements from both subarrays.
Copy the sorted Merged array back to the original array.
Divide Function:

Purpose: Recursively divides the array into smaller subarrays and sorts them.
Parameters:
arr[] - The original array.
si - Start index of the subarray.
ei - End index of the subarray.
Process:
Base case: If the subarray has one or zero elements, it’s already sorted.
Find the middle index and recursively sort the left and right subarrays.
Merge the sorted subarrays using the Conquer function.
Main Function:

Initializes the array and calls the Divide function to sort it.
Prints the sorted array.
Visualization:
Initial Array: 6, 5, 2, 8, 3, 9

Step-by-Step Process:

Divide the Array:

Split into subarrays: {6, 5, 2} and {8, 3, 9}
Further divide these subarrays until you get single elements.
Merge Subarrays:

Merge {6, 5} and {2} into {2, 5, 6}
Merge {8, 3} and {9} into {3, 8, 9}
Merge {2, 5, 6} and {3, 8, 9} into {2, 3, 5, 6, 8, 9}
Final Sorted Array: 2, 3, 5, 6, 8, 9

Merge Sort is an efficient, stable sorting algorithm with a time complexity of 
O(nlogn) and works well for large datasets.
 */
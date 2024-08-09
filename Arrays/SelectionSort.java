package Arrays;

public class SelectionSort{

    // Function to print the elements of an array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each element
        }
        System.out.println();  // Print a new line after the array
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 9, 5};  // Initialize the array to be sorted

        // Selection sort algorithm
        for (int i = 0; i < arr.length - 1; i++) {  // Loop through each element
            int smallest = i;  // Assume the smallest element is at the current index

            // Find the index of the smallest element in the unsorted portion of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;  // Update the index of the smallest element
                }
            }

            // Swap the smallest element found with the element at the current index
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
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

for (int i = 0; i < arr.length - 1; i++)
The outer loop iterates through each element in the array except the last one.
Find Smallest Element:

int smallest = i;
Assume the current element arr[i] is the smallest.
The inner loop finds the actual smallest element in the remaining unsorted portion of the array.
Inner Loop:

for (int j = i + 1; j < arr.length; j++)
Compare each element with the currently assumed smallest element.
Update smallest if a smaller element is found.
Swap:

int temp = arr[smallest]; arr[smallest] = arr[i]; arr[i] = temp;
Swap the smallest element found with the element at the current index i.
Print Array:

printArray(arr);
After sorting, the sorted array is printed.
Visualization:
For the array {2, 7, 1, 9, 5}, here’s how the Selection Sort algorithm processes it:

Initial Array: 2, 7, 1, 9, 5

Pass 1 (i = 0):

Find smallest in {2, 7, 1, 9, 5}: 1 (index 2).
Swap 2 and 1.
Array becomes: 1, 7, 2, 9, 5
Pass 2 (i = 1):

Find smallest in {7, 2, 9, 5}: 2 (index 2).
Swap 7 and 2.
Array becomes: 1, 2, 7, 9, 5
Pass 3 (i = 2):

Find smallest in {7, 9, 5}: 5 (index 4).
Swap 7 and 5.
Array becomes: 1, 2, 5, 9, 7
Pass 4 (i = 3):

Find smallest in {9, 7}: 7 (index 4).
Swap 9 and 7.
Array becomes: 1, 2, 5, 7, 9
Final Sorted Array: 1, 2, 5, 7, 9

Selection Sort finds the minimum element from the unsorted portion of the array and places it at the beginning, thus gradually building a sorted portion of the array.
 */
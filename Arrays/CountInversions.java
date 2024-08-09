package Arrays;
public class CountInversions {

    // Brute-force method to count inversions
    public static int method1(int arr[], int n) {
        if (n == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Merge function used in merge sort to count inversions
    public static int conquer(int arr[], int si, int mid, int ei) {
        int merge[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int count = 0;
        int j = 0;

        // Merge the two sorted subarrays and count inversions
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merge[j++] = arr[idx1++];
            } else {
                merge[j++] = arr[idx2++];
                // Count inversions: all elements from idx1 to mid are greater than arr[idx2]
                count += (mid + 1 - idx1);
            }
        }

        // Copy remaining elements of the left subarray
        while (idx1 <= mid) {
            merge[j++] = arr[idx1++];
        }

        // Copy remaining elements of the right subarray
        while (idx2 <= ei) {
            merge[j++] = arr[idx2++];
        }

        // Copy the sorted merged array back to the original array
        for (int i = 0, k = si; i < merge.length; i++, k++) {
            arr[k] = merge[i];
        }

        return count;
    }

    // Merge sort function that uses conquer to count inversions
    public static int mergeSort(int arr[], int si, int ei) {
        int count = 0;
        if (si >= ei) {
            return count;
        }
        int mid = si + (ei - si) / 2;
        count += mergeSort(arr, si, mid);  // Count inversions in the left subarray
        count += mergeSort(arr, mid + 1, ei);  // Count inversions in the right subarray
        count += conquer(arr, si, mid, ei);  // Count inversions while merging
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 5};
        System.out.println("Brute-force method: " + method1(arr, arr.length));  // Output: 1
        // Reset the array for merge sort
        arr = new int[]{2, 1, 3, 4, 5};
        System.out.println("Merge sort method: " + mergeSort(arr, 0, arr.length - 1));  // Output: 1
    }
}

/*
 Key Points:
Brute-force Method:

Simple but inefficient for large arrays.
Compares each pair of elements to count inversions.
Merge Sort Method:

Efficient with 
O(nlogn) complexity.
Counts inversions while merging two sorted halves of the array.
Correctly updates the count of inversions during the merge step.
Corrections:
Conquer Function:

Corrected while (idx2 <= mid) to while (idx2 <= ei) to properly copy remaining elements from the right subarray.
Variable Names:

Changed methode1 to method1 for consistency with Java naming conventions.
The revised code should correctly count the number of inversions and sort the array using merge sort while keeping track of the inversions.
 */
package Arrays;

public class ConsecutiveNumberOf1s {
  public static void main(String[] args) {
      // Binary array
      int[] arr = {1, 1, 0, 1, 1, 1};
      int maxCount = 0;  // To store the maximum count of consecutive 1s
      int count = 0;     // To store the current count of consecutive 1s

      for (int i = 0; i < arr.length; i++) {
          if (arr[i] == 1) {
              count++;  // Increase count if current element is 1
              maxCount = Math.max(maxCount, count);  // Update maxCount if needed
          } else {
              count = 0;  // Reset count if current element is 0
          }
      }

      System.out.println(maxCount);  // Output the maximum count of consecutive 1s
  }
}

/*
 Explanation:
Initialization:

maxCount: Tracks the maximum number of consecutive 1s encountered.
count: Tracks the current number of consecutive 1s.
Loop through the Array:

If the current element is 1, increment count and update maxCount to be the maximum of maxCount and count.
If the current element is 0, reset count to 0 as the sequence of 1s is broken.
Output:

After the loop completes, print the maxCount, which represents the maximum number of consecutive 1s in the array.
 */
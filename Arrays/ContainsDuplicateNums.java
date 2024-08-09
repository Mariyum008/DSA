package Arrays;
import java.util.*;
public class ContainsDuplicateNums {

    // Function to check if the array contains any duplicate elements
    public static boolean containsDuplicate(int[] nums) {
        // Handle null or empty array
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Sort the array
        Arrays.sort(nums);

        // Check for consecutive duplicates
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;  // Duplicate found
            }
        }

        return false;  // No duplicates found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));  // Output: true
    }
}
/*
 Explanation:
Sorting the Array:

Sorting the array arranges elements in ascending order. After sorting, any duplicate elements will be next to each other.
Checking for Duplicates:

After sorting, iterate through the array and check if any consecutive elements are the same. If found, return true.
Edge Cases:

The function handles arrays with duplicates and no duplicates correctly.
It does not handle cases where the array is null or has a length of 0, but these cases are often managed before this function is called.
 */
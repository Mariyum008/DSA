package Arrays;
public class CountMaze {
    // Recursive function to count the number of unique paths in an m x n maze
    private static int mazeCount(int m, int n, int i, int j) {
        // If we are out of bounds, return 0 (no valid path)
        if (i >= m || j >= n) {
            return 0;
        }
        // If we reach the bottom-right corner, return 1 (a valid path)
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Recursively count paths moving down and right
        int downPaths = mazeCount(m, n, i + 1, j);
        int rightPaths = mazeCount(m, n, i, j + 1);

        // Return the total number of paths from this cell
        return downPaths + rightPaths;
    }

    public static void main(String[] args) {
        int m = 4, n = 4;  // Define the dimensions of the maze
        int totalPaths = mazeCount(m, n, 0, 0);  // Calculate the total number of paths
        System.out.println("Total path count for " + m + "x" + n + " matrix is: " + totalPaths);
    }
}


/*
 Explanation:
Recursive Function mazeCount:

Base Cases:
if (i >= m || j >= n): If the current cell is out of bounds, return 0 because it's not a valid path.
if (i == m - 1 && j == n - 1): If the current cell is the bottom-right corner, return 1 because it's a valid path.
Recursive Calls:
mazeCount(m, n, i + 1, j): Count paths moving down.
mazeCount(m, n, i, j + 1): Count paths moving right.
Return: The sum of paths from both recursive calls.
Main Function:

Initializes the maze dimensions (m and n).
Calls the mazeCount function to get the total number of paths.
Prints the result with the correct dimensions of the maze.
Output:
The corrected print statement will output the total number of paths for a 4x4 matrix.

This version of the code will accurately compute the number of unique paths in an m x n grid, considering movements only to the right and down.
 */
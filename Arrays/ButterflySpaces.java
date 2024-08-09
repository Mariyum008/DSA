package Arrays;
public class ButterflySpaces {
    public static void main(String[] args) {
        int n = 5;  // Size of the butterfly pattern

        // Top part of the butterfly
        for (int i = 1; i <= n; i++) {
            // Print left wing
            for (int j = 1; j <= i; j++) {
                if (i == 1 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // Print spaces between the wings
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Print right wing
            for (int j = 1; j <= i; j++) {
                if (i == 1 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        // Bottom part of the butterfly
        for (int i = n; i >= 1; i--) {
            // Print left wing
            for (int j = i; j >= 1; j--) {
                if (i == 1 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // Print spaces between the wings
            int spaces = 2 * (n - i);
            for (int j = spaces; j >= 1; j--) {
                System.out.print(" ");
            }

            // Print right wing
            for (int j = i; j >= 1; j--) {
                if (i == 1 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}

/*
 Explanation:
Top Part of the Butterfly:

For each row i, you print stars and spaces to create the left wing.
After printing the left wing, you print spaces between the wings.
Then, you print stars to create the right wing.
Bottom Part of the Butterfly:

This is similar to the top part but in reverse order.
For each row i, you print stars and spaces to create the left wing.
After printing the left wing, you print spaces between the wings.
Then, you print stars to create the right wing

Key Points:
Top Part: The loop runs from 1 to n to generate the upper wing pattern.
Stars are printed for the edges and spaces inside.

Bottom Part: The loop runs from n to 1 to generate the lower wing pattern.
The structure is similar to the top part but in reverse order.

Pattern Structure: Each row contains two sections: the left wing and the right wing with spaces in between.
This optimized code is functionally equivalent to your original but is a bit cleaner and more consistent.
 */

import java.util.*;

public class nextGreaterElement {

    public static void findNextgrtr(int arr[], int nextGrtr[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGrtr[i] = -1;
            } else {
                nextGrtr[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGrtr[] = new int[arr.length];
        findNextgrtr(arr, nextGrtr);

        for (int i = 0; i < nextGrtr.length; i++) {
            System.out.print(nextGrtr[i] + " ");
        }
    }
}

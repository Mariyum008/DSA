import java.util.*;
import java.util.LinkedList;
public class MaxSubarrayKsize {
    public static int[] maxOfK(int arr[] , int k){
        int n = arr.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i =0;i<arr.length;i++){

            // remove the out of range elements
            if(!q.isEmpty() && q.peek() == i - k){
                q.pop();
            }
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }

            q.offer(i);
            if(i>=k-1){
                r[ri++] = arr[q.peek()];
            }
        }
    return r;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,3,5,2,3,6};
        arr = maxOfK(arr,3);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
}

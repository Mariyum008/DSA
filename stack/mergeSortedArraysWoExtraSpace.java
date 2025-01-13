import java.util.ArrayList;
import java.util.Arrays;

/**
 * mergeSortedArraysWoExtraSpace
 */
public class mergeSortedArraysWoExtraSpace {
    public static void mergeMethode1(int arr1[] , int arr2[] , int n , int m){
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(left<n && right<m){
            if(arr1[left]>=arr2[right]){
                ans.add(arr2[right]);
                right++;
            }
            else{
                ans.add(arr1[left]);
                left++;
            }
        }
        while (left<n) {
            ans.add(arr1[left]);
            left++;
        }
        while(right<m){
            ans.add(arr2[right]);
            right++;
        }

        for(int i = 0;i<n+m;i++){
            if(i<n){
                arr1[i] = ans.get(i);
            }
            else{
                arr2[i-n] = ans.get(i);   
            }
        }

    }

    public static void mergeMethode2(int arr1[] , int arr2[] , int n , int m){
        int left =n-1;
        int right = 0;
        while(left>=0 && right <= m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void swapIfGreater(int arr1[] , int arr2[] , int idx1 , int idx2){
        if(arr1[idx1]> arr2[idx2]){
        int temp = arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
        }
 
    }
    public static void mergeMethode3(int arr1[] , int arr2[] , int n , int m){
        int len = n + m;
        int gap = (len/2) + (len%2);

        while(gap>0){
            int left = 0;
            int right = left + gap;
            while(right<len){
                // left in array 1 and right in array 2
                if(left<n && right>=n){
                    swapIfGreater(arr1, arr2, left, right-n);
                }
                else if(left>=n){
                  swapIfGreater(arr2, arr2, left-n, right-n);
                }
                else{
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;

            gap = (gap/2) + gap%2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        mergeMethode3(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
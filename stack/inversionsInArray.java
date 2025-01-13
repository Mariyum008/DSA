import java.util.ArrayList;

/**
 * inversionsInArray
 */
public class inversionsInArray {
    public static int methode1(int arr[] , int n){
        int count = 0;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static int merge(int arr[], int low , int mid , int high){
        ArrayList<Integer> ans = new ArrayList<>();
        int left = low;
        int right = mid +1;

        int count = 0;

        while(left <= mid && right<= high){
            if(arr[left] <= arr[right]){
                ans.add(arr[left]);
                left++;
            }
            else{
                ans.add(arr[right]);
                count += (mid - left +1);
                right++;
            }
        }

        while (left <= mid) {
            ans.add(arr[left]);
            left++;
        }
        while (right<= high) {
            ans.add(arr[right]);
            right++;
        }
        for(int i = low;i<= high;i++){
            arr[i] = ans.get(i- low);
        }
        return count;

    }
    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low>= high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr , low , mid , high);
        return count;
    }

    public static int printCount(int [] arr , int low , int high){
        return mergeSort(arr, 0, high);
    }

    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        System.out.println(methode1(arr, arr.length));
        System.out.println(printCount( arr , 0 ,arr.length -1));
    }
}
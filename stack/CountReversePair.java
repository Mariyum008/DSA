import java.util.ArrayList;

public class CountReversePair {
    public static int methode1(int arr[] , int n ){
        int count = 0;

        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i] > arr[j]*2){
                    count++;
                }
            }
        }
        return count++;
    }

    public static void merge(int arr[] , int low , int mid , int high){
        int left = low;
        int right = mid +1;

        ArrayList<Integer> ans = new ArrayList<>();
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]){
                ans.add(arr[left]);
                left++;
            }
            else{
                ans.add(arr[right]);
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
        for(int i = low;i<=high;i++){
            arr[i] = ans.get(i-low);
        }
    }

    public static int countPair(int arr[] , int low ,int mid ,  int high){
        int right = mid + 1;
        int count = 0;
        for(int i = low;i<= mid;i++){
            while(right <= high && arr[i] > 2*arr[right]){
                right++;
            }
                count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(int arr[] , int low , int high){
        int count = 0;
        if(low>= high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid +1, high);
        count += countPair(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static int print(int arr[] , int n){
        return mergeSort(arr, 0 , n-1);
    }

    public static void main(String[] args) {
        int arr[] = {40,25,19,12,9,6,2};
        System.out.println(methode1(arr, arr.length));
        System.out.println(print(arr, arr.length));
    }
}

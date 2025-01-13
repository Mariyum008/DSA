import java.util.*;;
public class numSubarrayXOR_K {
   public static int methode1(int arr[] , int k, int  n){
      int count = 0;
      for(int i =0;i<n;i++){
         for(int j = i;j<n;j++){
            int xr = 0;
            for(int l = i;l<=j;l++){
               xr = xr^arr[l];
            }
               if(xr == k){
                  count++;
            }
         }
      }
      return count;
   }

   public static int methode2(int arr[] , int k , int n){
      int count = 0;
      for(int i =0;i<n;i++){
         int xr =0;
         for(int j = i;j<n;j++){
            xr^=arr[j];
         
         if(xr == k)
            count++;
         }
      }
      return count;
   }

   public static int methode3(int arr[] , int k , int n){

      int count = 0;
      HashMap<Integer , Integer> map = new HashMap<>();
      int xr = 0;
      map.put(xr, 1);

      for(int i =0;i<n;i++){
       xr ^= arr[i];
       int x= xr^k;
        if(map.containsKey(x)){
         count += map.get(x);
        }
        if(map.containsKey(xr)){
         map.put(xr, map.get(xr) + 1);
        }else{
         map.put(xr,1);
        }

      }
      return count;
   }
   public static void main(String[] args) {
      int [] arr = {4, 2, 2, 6, 4};
      System.out.println(methode1(arr, 6, arr.length));
      System.out.println(methode2(arr, 6, arr.length));
      System.out.println(methode3(arr, 6, arr.length));
   }
}

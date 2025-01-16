import java.util.PriorityQueue;

public class Nropes {
    
    public static int minCost(int arr[] , int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<n;i++){
            pq.add(arr[i]);
        }

        int res = 0;
        while (pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            res += (first + second);
            pq.add(first+second);
        }
        return res;
    }
    public static void main(String[] args) {
        int len[] = {4,3,2,6};
        System.out.println(minCost(len, len.length));
    }
}

import java.util.*;
import java.util.LinkedList;
public class ReversingKElementQueue {
    public static void reverse(Queue<Integer> q , int k){
        if(q.isEmpty()){
            return;
        }
        solve(q,k);
        int size = q.size()-k;
        while (size-->0) {
            int top = q.remove();
            q.add(top);
        }
    }

    public static void solve(Queue<Integer> q, int k){
        if(k == 0){
            return;
        }
        int top = q.remove();
        solve(q, k-1);
        q.add(top);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
       q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverse(q,5);
        // System.out.println(q.remove());
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}

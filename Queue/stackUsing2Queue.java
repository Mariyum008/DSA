import java.util.Queue;
import java.util.LinkedList;
public class stackUsing2Queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // add using O(n)
    public boolean isEmpty(){
        return q1.isEmpty();
    }
    public void push(int data){
        
            q2.add(data);
       
            while(!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
            // q1.add(null);
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q; 
      
    }

    public int pop(){
        if (q1.isEmpty())
            return -1;

        return q1.remove();
    }
    public static void main(String[] args) {
        stackUsing2Queue s = new stackUsing2Queue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

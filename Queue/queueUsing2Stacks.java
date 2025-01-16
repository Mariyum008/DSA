import java.util.Stack;

public class queueUsing2Stacks {
    // push O(N)
     Stack<Integer> s1 = new Stack<>();
     Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty(){
       return s1.isEmpty() && s2.isEmpty();
     }
    // public void add(int data){
    //     if(s1.isEmpty()){
    //         s1.add(data);
    //     }else{
    //         while (!s1.isEmpty()) {
    //             s2.add(s1.pop());
    //         }
    //         s1.add(data);
    //         while (!s2.isEmpty()) {
    //             s1.add(s2.pop());
    //         }
    //     }
    // }

    // public int remove(){
    //     if(s1.isEmpty() && s2.isEmpty()){
    //         return -1;
    //     }
    //     return s1.pop();
    // }
    
    public void add(int data){
        s1.push(data);
    }
    // pop(O(n))
    public int remove(){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }
    public static void main(String[] args) {
        queueUsing2Stacks q = new queueUsing2Stacks();
        q.add(1);
        q.add(2);
        // q.remove();
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}

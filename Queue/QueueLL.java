public class QueueLL {
    public class  Node {
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }
    public static Node head;
    // add last since queue
    public boolean isEmpty(){
        return head == null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head; 
        while (temp.next!= null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // removing from front i.e from the start
    public int remove(){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        
        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek(){
        if(head == null){
            return Integer.MIN_VALUE;
        }
            
        return head.data;
    }
    public static void main(String[] args) {
        QueueLL ql = new QueueLL();
        ql.add(1);
        ql.add(2);
        ql.add(3);

        while(!ql.isEmpty()) {
            System.out.println(ql.remove());
        }

    }
    
}

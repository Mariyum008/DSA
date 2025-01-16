public class Circualr_queue {
     class Queue{
        static int arr[];
        static int size;
        static int front = -1;
        static int rear = -1;

        Queue(int size){
            Queue.size = size;
            arr = new int[size];

        }
        public boolean isEmpty(){
            return front == -1 && rear ==-1;
        }
        public boolean isFull(){
            return (rear+1)%size == front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("Overflow Queue.");
                return;
            }
            if(front ==-1){
                front =0;
            }

            rear = (rear+1)%size;
            arr[rear] = data;

        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Empty queue!");
                return -1;
            }
            int el = arr[front];
            if(front == rear){
                front = rear =-1;
            }
            else{
                front = (front+1)%size;
            }
            return el;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty queue!");
                return -1;
            }
            return arr[front];
            
        }
    }
    public void main(String[] args) {
      Queue q = new Queue(5);
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
      System.out.println(q.remove());
      q.add((5));
      System.out.println((q.remove()));
      q.add(6);

      while(!q.isEmpty()){
        System.out.println(q.remove());
      }
    }
}

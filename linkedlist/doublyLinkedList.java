public class doublyLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int removeFirst(){
        if(head == null){
            return Integer.MIN_VALUE;
        }if(head.next == null){
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;

    }
    public void printdl(){
    
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseDL(){
        if(head == null || head.next == null){
            return;
        }

        Node prev = null;
        Node cur = head;
        Node next;
        while (cur != null ) {
            next = cur.next;
            cur.next = prev;
            cur.prev = next;

            prev = cur;
            cur = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        doublyLinkedList dl = new doublyLinkedList();
        dl.addFirst(3);
        dl.addFirst(2);
        dl.addFirst(1);
        dl.printdl();
        dl.reverseDL();
        // dl.removeFirst();
        dl.printdl();
    }
}

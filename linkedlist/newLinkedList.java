import javax.security.auth.kerberos.KerberosCredMessage;

public  class newLinkedList {
     
    public static class Node {
         int data;
         Node next;

         public Node(int data){
            this.data = data;
            this.next = null;

         }
    }
    public static Node head;
    public static Node tail;
    public int size = 0;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    public  void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
         tail.next = newNode;
         tail = newNode;

    }

    public  void addBetween(int data , int idx){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        Node prev = head;
        int i =0;
        while(i<idx-1){
            prev = prev.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;

    }

    public  void printLL(){
        if(head == null){
            System.out.println("empty linked list");
        }
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public int removeFirst(){
        if(size == 0){
            return Integer.MIN_VALUE ;
        }else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
       if(size == 0){
        return Integer.MIN_VALUE;
       }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
        }
        Node temp = head;
        while (temp.next.next!=null) {
            temp = temp.next;

        }
           int val = temp.next.data;
           temp.next = null;
           size--;
           return val;
    }
    public int removeBetween(int idx){
        if(size == 0){
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = head;
        int i =0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        size--;
        temp.next = temp.next.next;
        return val;

    }

    public int itrSearch(int key){
        Node temp = head;
        int i =0;
        while (temp != null) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int searchRecr(Node head , int key){  //{O(N)}
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = searchRecr(head.next , key);
        if(idx == -1){
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key){
        return searchRecr(head, key);
    }
 
    public void reverList(){
        if(head.next == null){
            return;
        }

        Node curr = tail = head;
        Node next;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
         head = prev;

    }

    public Node getKthNode(Node head , int k){
        k -=1;
        Node temp = head;
        while(temp!=null && k>0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        Node next;
        while (cur!=null) {
            next = cur.next;
            cur.next =prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    // reverse Kth linkedlist
    public  Node reverseKthLL(Node head , int k){
        Node temp =  head;
        Node prev = null;
        while (temp!=null) {
            // geting kth node
            Node kth = getKthNode(temp , k);

            // if there was a previous group link last node to current node
            if(kth == null){
                if(prev != null){
                    prev.next = temp;
                }
                // exit the loop
                break;
            }

            // store the next node after the kth node.
            Node next = kth.next;

            // disconnect kth node to prepare for reversal
            kth.next = null;

            // reverse nodes from temp to kth
            reverse(temp);

            if(temp == head){
                head = kth;
            }
            else{
                // link the last node of the previous group to the reversed group.
                prev.next = kth;
            }

            prev = temp;
            temp = next;
        }
        return head;
    }
    public Node reverseRec(Node head){
        if(head == null || head.next == null){
            return head;
        }
 
        Node newHead = reverseRec(head.next);
        Node front = head.next;
         front.next = head;
         head.next = null;
 
         return newHead;
    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && slow!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(head.next == null || head == null){
            return true;
        }
        // finding mid
        Node midNode = findMid(head);

        // revering second part;
        Node prev= null;
        Node cur = midNode;
        Node next;
        while (cur!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // comparison
        Node right = prev;
        Node left = head;
        while (right!=null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true; //cycle detected.
            }

        }

        return false; //cycle not detected.
    }

    // detect cycle with position
    public Node detectCylePosi(){
        
        if(head == null || head.next ==  null){
            return null;
        }
        Node slow = head;
        Node fast = head;  
        Node prev = head; 
      
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                 while(slow != prev) {
                slow = slow.next;
                prev = prev.next;
            }
            return slow;
            }
        }
        return null;
    }
    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast.next != null && fast!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = null;
    }

    public Node getMid(Node head){
        //fast = head.next for getting proper mid.
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
             temp.next = head2;
             head2 = head2.next;
             temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){

        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft , newRight);
    }
    // zig-zag linkedlist
    public void zigzagll(){
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node prev = null;
        Node cur = mid.next;
        mid.next  = null;
        Node next;

        while (cur!= null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // alt merge - zigzag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
        // next left pointing to right end.
            left.next = right;
            nextR = right.next;
        // next right pointing to next left end.
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }
    public static void main(String[] args) {
        newLinkedList ll = new newLinkedList();
        ll.addFirst(10);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLL();
        head = ll.reverseKthLL(head, 3);
        ll.printLL();

        // ll.printLL();
        // head =  ll.mergeSort(head);
        // ll.printLL();
        // ll.zigzagll();
        // ll.printLL();
        
        // for detecting cycle 
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(ll.detectCycle());
        // // ll.removeCycle();
        // Node pos = ll.detectCylePosi();
        // System.out.println(pos.data);

    }
}
public class linkedlist {
    Node head;
    public int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    linkedlist() {
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        
        size++;

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;

    }

    public void printList() {

        Node currNode = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void removelast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            curNode = curNode.next;
            lastNode = lastNode.next;
        }
        curNode.next = null;
    }

    public void addBetween(int index, int data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index value");
        }
        size++;
        Node newNode = new Node(data);
        // for an empty list
        if (head == null || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
                break;
            }
            currNode = currNode.next;
        }
    }

    public void removeBetween(int index, int data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index value");
        }
        size--;
        // for an empty list
        if (head == null) {
            System.out.println("List is empty");
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node curNode = head;
        Node preNode = curNode;
        while (curNode.data != data) {
            if (curNode.next == null) {
                System.out.println("Given index not found.");
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        preNode.next = curNode.next;

    }

    public void reverList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prNode;
            prNode = curNode;
            curNode = nextNode;
        }
        head.next = null;
        head = prNode;
    }

    public void swapList() {
        if (head == null || head.next == null) {
            return;
        }
        Node curNode = head;
        while (curNode != null && curNode.next != null) {
            int k = curNode.data;
            curNode.data = curNode.next.data;
            curNode.next.data = k;
            curNode = curNode.next.next;
        }
    }

    public void reverseFindDelete(int n) {
        if(head.next == null || n < 0){
           System.out.println("Invalid");
           return;
        }
        int s =0;    
        Node currNode = head;
        while(currNode!=null){
            currNode =currNode.next;
            s++;
        }
        int indexToSearch = s - n;
        Node prNode = head;
        int i = 1;
        while(i < indexToSearch){
           prNode = prNode.next;
           i++;
        }
        System.out.println(prNode.next.data);
        prNode.next = prNode.next.next;
    }
    public Node getMiddle(Node head){
        Node turtle = head;
        Node hare = head;
        while(hare.next!= null && hare.next.next!=null){
            turtle = turtle.next;
            hare = hare.next.next;
        }
        return turtle;
    }
    public Node reverList(Node head){
        Node preNode = null;
        Node curNode = head;
        while(curNode!=null){
            Node nextNode = curNode.next;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node firstHalfEnd = getMiddle(head);
        Node secondHalfStart = reverList(firstHalfEnd);
        Node firstHalfStart = head;

        while(secondHalfStart!=null){
            if(secondHalfStart.data != firstHalfStart.data){
                return false;
            }
            secondHalfStart = secondHalfStart.next;
            firstHalfStart = firstHalfStart.next;
        }
        return true;
    }
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
       
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
           
            if(fast == slow) {
                return true;
            }
        }
       
        return false;
     }
    
    public static void main(String[] args) {
        linkedlist l = new linkedlist();
        l.addFirst(1);
        l.addLast(2);
        // l.addLast(2);
        // l.addLast(1);
        // l.addLast(5);
        // // l.removeFirst();
        // // l.removelast();
        // // l.printList();
        // // l.addFirst(1);
        // l.printList();
        // l.removeBetween(2, 3);
        // // l.reverList();
        // l.addLast(6);
        // l.printList();
        // // l.swapList();
        // // System.out.println(l.size);
        // l.reverseFindDelete(2);
        // l.printList();
        //  boolean result = l.isPalindrome(l.head);
        // System.out.println(result);
        // boolean result2 = l.hasCycle(l.head);
        // System.out.println(result2);
        l.addBetween(1, 5);
        l.printList();
        System.out.println(l.getMiddle(l.head));
    }
}

// import java.util.LinkedList;

// public class linkedlist{
// public static void main(String[] args) {
// LinkedList<Integer> L = new LinkedList<Integer>();
// L.add(1);
// L.addFirst(2);
// L.addLast(3);
// L.add(4);
// System.out.println(L);
// L.remove(2);
// System.out.println(L);
// System.out.println(L.get()0);
// }
// }
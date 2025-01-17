public class linkedlist_hasCycle{
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

    linkedlist_hasCycle() {
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
        if (head == null) {
            head = newNode;
            return;
        }
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
        Node curNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Node nextNode = curNode.next;
                newNode = curNode.next;
                curNode.next = newNode;
                curNode.next = newNode;
                break;
            }
            curNode = curNode.next;
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
    
     
    
    public static void main(String[] args) {
        linkedlist_hasCycle l = new linkedlist_hasCycle();
        l.addFirst(1);
        l.addLast(2);
        l.addBetween(2, 3);
        l.printList();
    //     l.addLast(3);
    //     l.addLast(4);
    //     l.addLast(5);
    // h
        
    }
}
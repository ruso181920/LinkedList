public class IterativeSeach { 
    
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int search(int key) {
        Node temp = head;
        int i = 0; 

        while (temp != null) {
            if (temp.data == key) {
                return i; 
            }
            temp = temp.next; 
            i++;
        }
        return -1; 
    }

    public static void main(String[] args) {
        // Create an instance of the class to access its non-static methods
        IterativeSeach l1 = new IterativeSeach(); 
        
        l1.addFirst(1);
        l1.addFirst(2); // List is now: 2 -> 1
        l1.addLast(3);  // List is now: 2 -> 1 -> 3
        l1.addLast(5);  // List is now: 2 -> 1 -> 3 -> 5
        l1.addLast(7);  // List is now: 2 -> 1 -> 3 -> 5 -> 7

        int key = 5;
        int index = l1.search(key);

        if (index != -1) {
            System.out.println("Found " + key + " at index: " + index);
        } else {
            System.out.println("Key not found.");
        }
    }
}
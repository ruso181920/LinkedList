public class ReverseLL {
    public class Node{
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
    public void print (){
   
    Node temp=head;
    while(temp !=null) {
        System.out.print(temp.data+" ->");
        temp=temp.next;
    }
    System.out.println("null");
}

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while (curr !=null) { 
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
         ReverseLL l1=new ReverseLL();
        l1.addFirst(1);
        l1.addFirst(2); // List is now: 2 -> 1
        l1.addLast(3);  // List is now: 2 -> 1 -> 3
        l1.addLast(5);  // List is now: 2 -> 1 -> 3 -> 5
        l1.addLast(7);  // List is now: 2 -> 1 -> 3 -> 5 -> 7

       l1.reverse();
        l1.print();
    }
}

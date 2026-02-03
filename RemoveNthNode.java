public class RemoveNthNode {
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

    public void deleteNthfromEnd(int n) {
        // calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null) {
            temp=temp.next;
            sz++;
        }
        if(n==sz) {
            head=head.next;
            return;
        }

        // sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind) {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;

    }
     public void print (){
   
    Node temp=head;
    while(temp !=null) {
        System.out.print(temp.data+" ->");
        temp=temp.next;
    }
    System.out.println("null");
}

    public static void main(String[] args) {
        RemoveNthNode l1=new RemoveNthNode();
        l1.addFirst(1);
        l1.addFirst(2); // List is now: 2 -> 1
        l1.addLast(3);  // List is now: 2 -> 1 -> 3
        l1.addLast(5);  // List is now: 2 -> 1 -> 3 -> 5
        l1.addLast(7);

        l1.deleteNthfromEnd(4);
        l1.print();

    }
}

public class ZigZagLL {
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


     public void print (){
   
    Node temp=head;
    while(temp !=null) {
        System.out.print(temp.data+" ->");
        temp=temp.next;
    }
    System.out.println("null");
}
  
    public void zigZag() {
        //find mid
        Node slow =head;
        Node fast=head.next;
        while (fast !=null && fast.next !=null) {
            slow=slow.next;
            fast=fast.next.next;

        }
        Node mid=slow;

        // reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }

        Node left=head;
        Node right=prev;
        Node nextL,nextR;


        // zigzag merge
        while(left != null && right != null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left =nextL;
            right=nextR;
        }
    }

 public static void main(String[] args) {
        ZigZagLL ll=new ZigZagLL();
        ll.addLast(1);
        ll.addLast(4);
        ll.addFirst(5);
         ll.addFirst(12);
         ll.addFirst(6);
        ll.addFirst(5);

       ll.print();
      ll.zigZag();
       ll.print();
   }
}

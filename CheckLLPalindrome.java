public class CheckLLPalindrome {
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

 public Node findMidNode(Node head) {
    Node slow=head;
    Node fast=head;

    while(fast != null && fast.next!=null) {
      slow=slow.next;
      fast=fast.next.next;  
    }
    return slow;
 }

 public boolean checkLLPalindrome(){
    if(head ==null|| head.next==null) {
        return true;
    }
    // find middle
     Node mid=findMidNode(head);

     //reverse 2nd half
     Node curr=mid;
     Node prev=null;
     while(curr !=null) {
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
     }
     Node right=prev;
     Node left=head;

     //check if equal
     while (right !=null) { 
         if(left.data != right.data) {
            return false;
         }
         left=left.next;
         right=right.next;
     }
     return true;
 }

    public static void main(String[] args) {
       CheckLLPalindrome  l1=new CheckLLPalindrome();
        l1.addFirst(1);
        l1.addFirst(2); // List is now: 2 -> 1
        l1.addLast(1);  // List is now: 2 -> 1 -> 3
        l1.addLast(2);  // List is now: 2 -> 1 -> 3 -> 5
        l1.addLast(2);

        System.out.println(l1.checkLLPalindrome());

    }
}

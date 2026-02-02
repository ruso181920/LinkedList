public class BasicLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node (int data) {
            this.data=data;
            this.next=null;
        }
    }
public static Node head;
public static Node tail;

public void addFirst(int data) {
    //1.create new node
    Node newNode= new Node (data);
    if(head==null){
        head=tail=newNode;
        return;

    }
    //2.newNode next=head
    newNode.next=head;

    //3.head=newNode
    head=newNode;
}

public void addLast(int data) {
    Node newNode= new Node (data);
    if(head==null){
        head=tail=newNode;
        return;

    }
    
    tail.next=newNode;
    tail=newNode;
}

public void print (){
   
    Node temp=head;
    while(temp !=null) {
        System.out.print(temp.data+" ->");
        temp=temp.next;
    }
    System.out.println("null");
}


public static void main(String [] args) {
    BasicLinkedList l1=new BasicLinkedList();
    l1.print();
    l1.addFirst(1);
     l1.print();
    l1.addFirst(2);
     l1.print();
   
    l1.addLast(3);
     l1.print();
   
    l1.addLast(4);
     l1.print();
}


}
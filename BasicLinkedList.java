
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
public static int size;

public void addFirst(int data) {
    //1.create new node
    Node newNode= new Node (data);
    size++;
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
    size++;
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

public void add(int idx,int data){
    if(idx==0){
        addFirst(data);
        return;
    }
    Node newNode =new Node(data);
    size++;
    Node temp=head;
    int i=0;
    while(i<idx-1) {
        temp=temp.next;
        i++;  
    }
    newNode.next=temp.next;
    temp.next=newNode;
}
public int removeFirst(){
    if(size==0){
        System.out.println("ll is empty");
        return Integer.MIN_VALUE;
    }
    else if(size==1){
        int val=head.data;
        head=tail=null;
        size=0;
        return val;
    }
    int val=head.data;
    head=head.next;
    size--;
    return val;
}
public int removeLast(){
    if(size==0){
        System.out.println("ll is empty");
        return Integer.MIN_VALUE;
    }
    else if(size==1){
        int val=head.data;
        head=tail=null;
        size=0;
        return val;
    }
    Node prev=head;
       for (int i = 0; i <size-2; i++) {
           prev=prev.next;
       }
       int val=prev.next.data;
       prev.next=null;
       tail=prev;
       size--;
       return val;
   
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
    l1.add(2, 9);
     l1.print();
   System.out.println("size :-> "+l1.size);
   l1.removeFirst();
   l1.print();
  System.out.println("size :-> "+l1.size);
   l1.removeLast();
   l1.print();
  System.out.println("size :-> "+l1.size);
    }


}
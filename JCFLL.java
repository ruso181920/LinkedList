import java.util.*;
public class JCFLL {
    public static void main (String [] args) {
        //create
        LinkedList <Integer> ll = new LinkedList <> ();

        //add 
        ll.addLast(1);
        ll.addLast(4);
        ll.addFirst(6);

        //print
        System.out.println(ll);

        //remove 
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }

}

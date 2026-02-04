public class RemoveCycle {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // 1. Detect Cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (!cycle) return;

        // 2. Find the meeting point (Entry point of cycle)
        slow = head;
        Node prev = null; 
        
        // Handle the case where the loop starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        while (slow != fast) {
            prev = fast; // Track the node before fast to break the link
            slow = slow.next;
            fast = fast.next;
        }

        // 3. Remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // Creating a cycle: 3 -> 2
        head.next.next.next = head; 

        System.out.println("Cycle detected: " + isCycle()); // Should be true
        removeCycle();
        System.out.println("Cycle detected after removal: " + isCycle()); // Should be false
    }
}
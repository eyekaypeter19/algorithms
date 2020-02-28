package FastAndSlowPointers;

public class LinkedListCycleLength {

    private static int findCycleLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        int cycleLength = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //we have found the cycle
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }
        return cycleLength;
    }

    private static int calculateCycleLength(ListNode node) {
        ListNode currentNode = node;
        int cycleLength = 0;
        do {
            currentNode = currentNode.next;
            cycleLength ++;
        } while (currentNode != node);
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}

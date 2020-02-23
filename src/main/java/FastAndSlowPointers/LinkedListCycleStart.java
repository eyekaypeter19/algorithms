package FastAndSlowPointers;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //A cycle exists
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }
        ListNode cycleStart = findCycleStart(head, cycleLength);
        return cycleStart;
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do{
            current = current.next;
            cycleLength ++;
        } while(current != slow);
        return cycleLength;
    }

    private static ListNode findCycleStart(ListNode head, int cycleLength) {
        ListNode fast = head;
        ListNode slow = head;
        while (cycleLength > 0){
            slow = slow.next;
            cycleLength --;
        }
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
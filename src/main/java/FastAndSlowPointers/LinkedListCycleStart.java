package FastAndSlowPointers;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleStart = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //we hav e found the cycle
                int cycleLength = findCycleLength(slow);
                cycleStart = findCycleStart(head, cycleLength);
                break;
            }
        }
        return cycleStart;
    }

    private static int findCycleLength(ListNode slow) {
        if (slow == null || slow.next == null) {
            return 0;
        }
        int cycleLength = 0;
        ListNode currentNode = slow;
        do {
            currentNode = currentNode.next;
            cycleLength ++;
        } while (currentNode != slow);
        return cycleLength;
    }

    private static ListNode findCycleStart(ListNode currentNode, int cycleLength){
        ListNode previousNode = currentNode;
        while(cycleLength > 0) {
            previousNode = previousNode.next;
            cycleLength --;
        }
        ListNode fastNode = currentNode;
        while(fastNode != previousNode) {
            fastNode = fastNode.next;
            previousNode = previousNode.next;
        }
        return fastNode;
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
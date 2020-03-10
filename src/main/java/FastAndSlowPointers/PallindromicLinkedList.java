package FastAndSlowPointers;

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null  || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode copyHeadSecondHalf = secondHalf; // we are storing this so that we can revert back later
        while(head != null && secondHalf != null) {
            if (head.value != secondHalf.value)
                break;
            head = head.next;
            secondHalf = secondHalf.next;
        }
        reverse(copyHeadSecondHalf);
        if(head == null || secondHalf == null)
            return true;
        return false;
    }

    //you cant go back in a listnode
    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous =head;
            head = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
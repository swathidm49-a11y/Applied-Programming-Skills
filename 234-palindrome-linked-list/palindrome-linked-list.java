class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        // find middle & reverse first half
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // skip middle node for odd length
        if (fast != null) slow = slow.next;

        // compare both halves
        while (prev != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}

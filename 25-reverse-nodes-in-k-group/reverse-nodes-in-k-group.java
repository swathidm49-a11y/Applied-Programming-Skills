class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }
}

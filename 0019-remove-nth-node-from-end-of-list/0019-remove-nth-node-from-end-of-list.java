class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int positionToRemove = length - n;

        ListNode curr = dummy;
        for (int i = 0; i < positionToRemove; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;  
    }
}

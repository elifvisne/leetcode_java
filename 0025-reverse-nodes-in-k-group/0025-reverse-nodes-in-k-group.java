/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        ListNode current = head;
        
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        
        while (length >= k) {
            ListNode groupStart = prevGroupTail.next;
            ListNode groupPrev = prevGroupTail;
            ListNode groupNext = null;
            
            for (int i = 0; i < k; i++) {
                ListNode nextNode = current.next;
                current.next = groupPrev;
                groupPrev = current;
                current = nextNode;
            }
            
            groupNext = current;
            prevGroupTail.next = groupPrev;
            groupStart.next = groupNext;
            
            prevGroupTail = groupStart;
            length -= k;
        }
        
        return dummy.next;
    }
}

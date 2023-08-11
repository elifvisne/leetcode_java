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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode beginning = new ListNode();
        ListNode t = beginning;
        int previous = 0;

        while(l1 != null || l2 != null || previous != 0){
            if(l1 != null){
                previous += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                previous += l2.val;
                l2 = l2.next;
            }

            t.next = new ListNode(previous % 10);
            previous = previous > 9 ? 1 : 0;
            t = t.next;
        }
        return beginning.next;
    }
}
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
   // Appraoch: Traverse the list and cut the list of k size and reverse it an so on.

public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 0)
            return head;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        
        while(curr != null){
            ListNode forw = curr;
            int temp = k;
            ListNode nhead;
            while(temp-- > 1 && forw != null){
                forw = forw.next;
            }
            if(forw != null){
                nhead = forw.next;
                forw.next = null;
            }else{
                break;
            }
            dp.next = reverse(curr);
            while(dp.next != null)
                dp = dp.next;
            curr = nhead;
        }
        dp.next = curr;
        return dummy.next;
    }

}
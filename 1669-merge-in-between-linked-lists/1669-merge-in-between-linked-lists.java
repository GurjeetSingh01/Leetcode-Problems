class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){
        ListNode dummy = new ListNode(0), p = dummy;
        p.next = list1;
        
        // move p to node before position a, set next of this node to list 2, set t to p.next
        for (int i = 0 ; i < a; i++) p = p.next;
        ListNode t = p.next;
        p.next = list2;
        
        // move t to node at position b, move p to last node in list 2 and connect p to t.next
        for (int i = 0; i < b-a; i++) t = t.next;
        while (p.next != null) p = p.next;
        p.next = t.next;
		
        return dummy.next;
    }
}
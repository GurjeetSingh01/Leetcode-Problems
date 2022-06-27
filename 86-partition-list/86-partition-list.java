class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0), lessCurr = less;
        ListNode greater = new ListNode(0), greaterCurr = greater;
        while (head != null) {
            if (head.val < x) {
                lessCurr.next = new ListNode(head.val);
                lessCurr = lessCurr.next;
            } else {
                greaterCurr.next = new ListNode(head.val);
                greaterCurr = greaterCurr.next;
            }
            head = head.next;
        }
        lessCurr.next = greater.next;
        return less.next;
    }
}
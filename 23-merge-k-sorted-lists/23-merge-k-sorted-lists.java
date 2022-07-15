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
   public ListNode mergeKLists(ListNode[] lists) {
    ListNode ans = new ListNode(Integer.MIN_VALUE);
    for(ListNode list : lists){
        ans = mergeTwoList(ans, list);
    }
    return ans.next;
}

public ListNode mergeTwoList(ListNode list1,ListNode list2){
    ListNode list3 = new ListNode(Integer.MIN_VALUE);
    ListNode temp = list3;
    while(list1 != null && list2 != null){
        if(list1.val <= list2.val){
            temp.next = list1;
            list1 = list1.next;
            
        }else{
            temp.next = list2;
            list2 = list2.next;
        }
        temp = temp.next;
    }
    if(list1 != null ){
        temp.next = list1;
    }
    if(list2 != null){
        temp.next = list2;
    }
    return list3.next;
}
}
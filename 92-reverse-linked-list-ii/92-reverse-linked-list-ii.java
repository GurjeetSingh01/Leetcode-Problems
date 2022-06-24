class Solution{
public ListNode reverseBetween(ListNode head, int left, int right){
if(head== null || head.next == null || left == right){
return head; 
}
ListNode f1 = new ListNode();
f1.next = head; 
ListNode pre  = f1; 
ListNode current = head; 
for(int i =0; i<left -1; i++){
pre = pre.next ;
current  = current.next; 
}
for(int i =0; i<right-left; i++){
ListNode Next = current.next; 
current.next = Next.next; 
Next. next = pre.next; 
pre.next = Next; 
}
return f1.next; 
}}

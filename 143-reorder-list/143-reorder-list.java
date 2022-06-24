public class Solution {
public void reorderList(ListNode head) {
if(head == null || head.next == null) 
return ;
Deque <ListNode> st = new ArrayDeque<ListNode>();
ListNode ptr = head; 
while (ptr!= null) {
st.push(ptr);
ptr= ptr.next; 
}
int count = (st.size()-1)/2;
ptr = head; 
while(count--> 0) {
ListNode top = st.pop();
ListNode tmp = ptr. next; 
ptr.next = top;
top.next = tmp;
ptr = tmp;
}
st.pop().next=null;
}}

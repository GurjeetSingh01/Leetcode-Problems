
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slw = head; 
        ListNode fst = head; 
        while (fst!=null && slw!= null){
            if(fst.next ==null)
                return false;
            slw= slw.next;
            fst = fst.next.next;
            if(slw==fst)
                return true;
        }
        return false;
        
    }
}

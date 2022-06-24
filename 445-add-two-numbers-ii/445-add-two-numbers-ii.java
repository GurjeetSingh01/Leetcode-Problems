class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Create a stack to store the revesed version of listnode 1 
        Stack<Integer> stack1 = new Stack<>();
        //Create a stack to store the reversed version of listnode 2
        Stack<Integer> stack2 = new Stack<>();
        //Create a stack to store the reversed version of result
        Stack<Integer> stack3 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }//store the listnode 1 values in reversed form
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }//store the listnode 2 values in reversed form
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            if(!stack1.isEmpty()){
                carry += stack1.pop();
            }
            if(!stack2.isEmpty()){
                carry += stack2.pop();
            }
            stack3.push(carry%10);
            carry = carry/10;
        }// until two stacks are empty , pop out the top elements from stack and push into result stack
        ListNode result = new ListNode();//create new listnode to store the result
        ListNode head = result;//header pointer
        while(!stack3.isEmpty()){
            result.next = new ListNode(stack3.pop());
            result = result.next;
        }
        return head.next;
    }
}
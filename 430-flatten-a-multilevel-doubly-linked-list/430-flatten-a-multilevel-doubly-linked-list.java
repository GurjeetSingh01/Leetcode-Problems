class Solution {
    public Node flatten(Node head) 
    {
        Node curr=head;
        while(curr!=null)
        {
            if(curr.child==null)//if the current node doesnt have a child then lets just move to the next node
            {
                curr=curr.next;
                continue;
            }
            //if incase a node has child
            Node temp=curr.child;
            while(temp.next!=null)
            {
                temp=temp.next;//transverse till the tail of that child node
            }
            
            temp.next=curr.next;//again coming back to parent node and transversing thro next nodes
            if(curr.next!=null)
            {
                curr.next.prev=temp;
            }
            //merging all nodes
                curr.next=curr.child;
                curr.child.prev=curr;
                curr.child=null;
        }
        
        return head;
    }
}
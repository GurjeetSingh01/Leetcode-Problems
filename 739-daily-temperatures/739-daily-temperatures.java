class Solution {

public int[] dailyTemperatures(int[] t){
    Stack<Integer> st= new Stack();
    int n=t.length;
    int ans[]=new int[n];
    for(int i=0;i<n;i++)
    {
        while(st.size()>0 && t[i]>t[st.peek()])
            ans[st.peek()]=i-st.pop();
        
        st.push(i);
    }
    return ans;
	}
}
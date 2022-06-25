class Solution {
    public int rob(int[] a) {
       int n=a.length-1;
		int prev=a[0],prev2=0;
		for(int i=1;i<=n;i++) {
			int take=a[i]+(i>1?prev2:0);
			int nonTake=prev;
			int curr=Math.max(take, nonTake);
			prev2=prev;
			prev=curr;
		}
		return prev;
    }
    
   
}
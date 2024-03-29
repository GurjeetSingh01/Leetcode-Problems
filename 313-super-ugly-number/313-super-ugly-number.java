class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int []dp=new int[n+1];
        dp[1]=1;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        for(int i=0;i<primes.length;i++){
            pq.add(new Pair(primes[i],1,primes[i]));
        }
        
        for(int i=2;i<=n;){
            Pair curr=pq.remove();
            
            if(curr.val!=dp[i-1]){
                dp[i]=curr.val;
                i++;
            }
            
            int newval=curr.prime*dp[curr.ptr+1];
            if(newval>0){
                pq.add(new Pair(curr.prime, curr.ptr+1,newval));
            }
        }
        
        return dp[n];
    }
}

class Pair implements Comparable<Pair>{
    int prime;
    int ptr;
    int val;
    
    public Pair(int prime, int ptr, int val){
        this.prime=prime;
        this.ptr=ptr;
        this.val=val;
    }
    
    public int compareTo(Pair o){
        return this.val-o.val;
    }
}

class Solution {
public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings,(a,b)->a[0]-b[0]);
    LinkedList<long[]> list=new LinkedList<>();
    PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)-> a[1]==b[1]? Long.compare(a[0],b[0]): Long.compare(a[1],b[1]));
    HashMap<Long,Integer> hm=new HashMap<>();
    for(int i=0;i<n;i++)
        pq.add(new long[]{i,0});
    for(int i=0;i<meetings.length;i++)
    {
        int curr[]=meetings[i];
        long end[]=pq.remove();
        long del=end[1]-curr[0];
        if(del>0)
        pq.add(new long[]{end[0],curr[1]+del});
        else
        {
            while(pq.size()>0 && pq.peek()[1]<=curr[0])
            {
                long aa[]=pq.remove();
                if(aa[0]<end[0])
                {
                    list.add(new long[]{end[0],end[1]});
                    end[0]=aa[0];
                }
                else
                {
                    list.add(new long[]{aa[0],aa[1]});
                }
            }
            for(long m[]: list)
                pq.add(m);
            list=new LinkedList<>();
            pq.add(new long[]{end[0],curr[1]});
        }

        hm.put(end[0],hm.getOrDefault(end[0],0)+1);
        
    }
    long max=0,ans=0;
    for(long k:hm.keySet())
    {
        long s=hm.get(k);
        if(s>max)
        {
            max=hm.get(k);
            ans=k;
        }
        else if(s==max)
        {
            ans=Math.min(k,ans);
        }
        
    }
    return (int)ans;
}
}
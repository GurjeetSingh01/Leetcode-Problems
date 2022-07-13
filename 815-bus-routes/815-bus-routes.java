class Solution {
    public int numBusesToDestination(int[][] arr, int src, int des) {
        
          Queue<Integer> q=new LinkedList<>();
        Map<Integer,ArrayList<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(hm.containsKey(arr[i][j]))
                {
                    ArrayList<Integer> al=hm.get(arr[i][j]);
                    al.add(i);
                    hm.put(arr[i][j],al);
                }
                else
                {
                    ArrayList<Integer> al=new ArrayList<>();
                    al.add(i);
                    hm.put(arr[i][j],al);
                }
                
            }
        }
        q.offer(src);
        int visited[]=new int[arr.length+1];
        int level=0;
        
        while(q.size()>0)
        {
            int size=q.size();
            while(size-->0)
            {
            int ele=q.remove();
            
            if(ele==des)
            return level;
            
            ArrayList<Integer> bus=hm.get(ele);
            
            for(int i=0;i<bus.size();i++)
            {
                int index=bus.get(i);
                
                if(visited[index]==1)
                continue;
                
                for(int j=0;j<arr[index].length;j++)
                {
                    q.offer(arr[index][j]);
                }
                visited[index]=1;
            }
            
            } //inner while close
            level++;
        }
        return -1;
        
        
        
    }
}

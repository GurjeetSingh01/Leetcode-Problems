class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        for(Map.Entry<Integer,Integer> mapElement : hm.entrySet()){
                        // System.out.println(mapElement.getKey()+"  "+mapElement.getValue());

            pq.add(mapElement);
        }
        int n = arr.length ,set =0 ;
        while(arr.length/2 < n) {
            Map.Entry<Integer,Integer> curr = pq.remove();
         // System.out.println(curr.getKey()+"  "+curr.getValue());
                set++;
            // System.out.println(curr.getKey());
                n -= curr.getValue();
            }
        
        return set;
    }
}
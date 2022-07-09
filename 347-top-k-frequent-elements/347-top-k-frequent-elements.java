class Solution {
public int[] topKFrequent(int[] nums, int k ){
// O(1) tym 
if(k == nums.length){
return nums;
}
// 1. build hash map: character and how often it appears
// O(N)  time 
Map<Integer, Integer> cn = new HashMap<>();
for(int n : nums){
cn.put(n, cn.getOrDefault(n,0) +1);
}
// init heap 'the less frequent element first'
Queue<Integer> hp = new PriorityQueue<>((n1,n2) -> cn.get(n1) - cn.get(n2));

// 2. keep k top frequent elements in the heap
// O(N logK) < O(NlogN) time
for(int n:cn.keySet()){
hp.add(n);
if(hp.size() >k) hp.poll();
}
// 3.build an output array 
// O(k logk) time 
int[] top = new int[k];
for(int i = k-1;  i>=0; --i){
top[i] = hp.poll();
}
return top;
}}
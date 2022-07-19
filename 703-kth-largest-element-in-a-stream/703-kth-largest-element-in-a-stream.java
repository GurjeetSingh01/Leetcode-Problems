class KthLargest {
    private int maxElements;
    private PriorityQueue<Integer> minHeap; //min heap; smallest will be always the first element in the minHeap

    public KthLargest(int k, int[] nums) {
        this.maxElements = k; //how many elements can we keep in minHeap
        this.minHeap = new PriorityQueue(maxElements); //initialCapacity
        for (int num : nums) {
            minHeap.add(num); //add all numbers
            if (minHeap.size() > maxElements) //while adding numbers check if the queue has more than k elements remove the smallest
                 minHeap.remove();
        } 
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > maxElements) //if queue has more than k elements remove the smallest
            minHeap.remove();
        return minHeap.peek(); //always return the smallest number in minheap which is kth largest element
    }
}
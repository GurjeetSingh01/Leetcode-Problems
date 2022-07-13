class TimeMap {
     Map<String,Queue<TimeStamp>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //instantiate a timestamp object with the time and the value.
        TimeStamp ts = new TimeStamp(timestamp,value);
        if(map.containsKey(key)){
            Queue<TimeStamp> current = map.get(key);
            //if we have seen this key before at to its queue.
            current.add(ts);
            map.put(key,current);
        }
        else{
            //if we havent seen it, add it and create a new queue with its value.
            //default ordering of priority queue in java is minheap, use collections to fix this.
            Queue<TimeStamp> current = new PriorityQueue<>(Collections.reverseOrder());
            current.add(ts);
            map.put(key, current);
        }
    }
    
    public String get(String key, int timestamp) {
        //this key is not found.
        if(!map.containsKey(key)){
            return "";
        }
        else{
            Queue<TimeStamp> current = map.get(key);
            List<TimeStamp> copy = new ArrayList<>();
            //search for greatest timestamp less than or equal to the one we are looking for.
            while(!current.isEmpty() && current.peek().time > timestamp){
                //copy the elements that we have popped to re add them later.
                copy.add(current.poll());
            }
            //while loop breaks at first time stamp less than or equal to our timestamp. return current.peek UNLESS the queue is empty which means every time stamp 
            //was greater. In this case return empty string.
            String val = current.isEmpty() ? "" : current.peek().value;
            //add back values we popped in our search.
            current.addAll(copy);
            return val;
        }
        
    }
}
class TimeStamp implements Comparable<TimeStamp>{
    //timestamp object maintains both time and value.
    public int time; 
    public String value;
    TimeStamp(int time, String value){
      this.time=time;
      this.value=value;
    }
    //compare the nodes based on time so that the heap will be ordered correctly. This is an interface in Java, if not clear research comparable interface.
    public int compareTo(TimeStamp t ){
        if(this.time==t.time){
            return 0;
        }
        else{
            return this.time > t.time ? 1 : -1;
        }
    }
        
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
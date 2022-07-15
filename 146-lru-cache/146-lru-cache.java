class LRUCache {
    class Node{
        int value;
        int key;
        Node prev;
        Node next;
        
        Node(int key, int value){
            //Actual node in the cache
            this.value = value;
            this.key = key;
        }
        
        Node(){
            //Dummy node to serve as head & tail of the cache
        }
    }
    
    Node head;
    Node tail;
    int maxCapacity;
    Map<Integer, Node> nodeMap;
    
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        head= new Node();
        tail = new Node();
        nodeMap = new HashMap();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            //Node with required value
            Node valNode = nodeMap.get(key);
            
            //Move this value to the front of the cache by:
            //1. Delete this node from the current position
            //2. Insert it in the front of the cache
            deleteFromCurrentPosition(valNode);
            insertNearHead(valNode);
            
            //return the found value
            return valNode.value;
        }
        
        //Return -1 since the required value not found in the cache
        return -1;        
    }
    
    void deleteFromCurrentPosition(Node node){
        //delete the current node from the cache by re-wiring the previous & next nodes of the current node to each other, thereby bypassing the current node.
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
     
    void removeNearTail(){
        //Move the tail pointer one step backward, and set the next pointer of the new tail to null,
        // so that the reference to the previous tail node is gone
        tail = tail.prev;
        tail.next = null;
    }
    
    void insertNearHead(Node node){
        node.next=head.next;
        node.prev=head;
        
        head.next.prev=node;
        head.next = node;
    }
    
    public void put(int key, int value) {
        //check if this key already present in the nodeMap
        if(nodeMap.containsKey(key)){
            //The key is already exisiting in the map.
            //Get the node from the nodeMap using this key & delete it from its current position in the cache
            
            Node valNode = nodeMap.get(key);
            deleteFromCurrentPosition(valNode);
            
            //Update the existing node with the new value
            valNode.value = value;
            
            //Insert the modified node to the front of the cache
            insertNearHead(valNode);
        }else{
            //Existing node not found, hence create a new one
            Node newNode = new Node(key, value);
            
             //check if the current cache is already full
            if(nodeMap.size()==maxCapacity){
                //remove node from the node map, since it will be irrelevant after deletion
                nodeMap.remove(tail.prev.key);

                //The cache is full here. Remove a  node from the tail of the cache
                removeNearTail();
            }
            //Insert the new node in the front of the cache
            insertNearHead(newNode); 
            
             //Add this node to the map for tracking its reference
            nodeMap.put(key, newNode);
        }
    }
}
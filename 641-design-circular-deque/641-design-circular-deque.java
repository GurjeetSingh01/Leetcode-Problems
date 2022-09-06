class MyCircularDeque {
    int[] q;
    int head, tail, size, count, cap;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.q = new int[k+1];
        this.head = this.count = 0;
        this.tail = 1;
        this.cap = k;
        this.size = k+1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        this.q[this.head] = value;
        this.count++;
        this.head = (this.head - 1 + this.size) % this.size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        this.q[this.tail] = value;
        this.count++;
        this.tail = (this.tail + 1) % this.size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        this.head = (this.head + 1) % this.size;
        this.count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        this.tail = (this.tail - 1 + this.size) % this.size;
        this.count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        int id = (this.head + 1) % this.size;
        return this.q[id];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        int id = (this.tail - 1 + this.size) % this.size;
        return this.q[id];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.count == this.cap;
    }
}
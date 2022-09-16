class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> loc;
    Random rand;
    public RandomizedSet() {
        
        map = new HashMap<>();
        loc = new ArrayList<>();
        rand = new Random();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, loc.size());
        loc.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int temp;
        int index = map.get(val);
        temp = loc.get(loc.size() - 1);
        loc.set(index, temp);
        
        loc.remove(loc.size() - 1);
        
        map.put(temp, index);
        map.remove(val);
        return true;

    }
    
    public int getRandom() {
        return loc.get(rand.nextInt(loc.size()));
    }
}
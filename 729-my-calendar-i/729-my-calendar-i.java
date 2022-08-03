class MyCalendar {
    
    TreeMap tt;

    public MyCalendar() {
        tt = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = tt.lowerEntry(end);
        if (entry != null && entry.getValue() > start) return false;
        tt.put(start, end);
        return true;
    }
}
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length() != s2.length())
            return false;
        
        return solve(s1,s2);
    }
    Map<String,Boolean> map = new HashMap<>();
    boolean solve(String a,String b)
    {
        if(a.equals(b))
            return true;
        if(a.length() !=b.length())
            return false;
        String key = a+"*"+b;
        if(map.containsKey(key))
            return map.get(key);
        
        int n = a.length();
        for(int i=1;i<n;i++)
        {
            if( (solve(a.substring(0,i),b.substring(n-i)) && solve(a.substring(i),b.substring(0,n-i))) ||
             (solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i),b.substring(i))) )
            {
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
}
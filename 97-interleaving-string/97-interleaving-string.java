public class Solution {
    Set<String> mem = new HashSet<String>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        if(mem.contains(s1+"#"+s2)) 
            return false;
        if(s3.length() > 0){
            if(s1.length() > 0 &&  s1.charAt(0) == s3.charAt(0))
                if(isInterleave(s1.substring(1),s2,s3.substring(1))) return true;
            if(s2.length() > 0 && s2.charAt(0) == s3.charAt(0))
                if(isInterleave(s1,s2.substring(1),s3.substring(1))) return true;
        }
        mem.add(s1+"#"+s2);
        return false;
    }
}
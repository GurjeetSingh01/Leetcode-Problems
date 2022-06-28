class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(0, s, memo);
    }
    
    private int helper(int index, String s, Map<Integer, Integer> memo) {
        
        //base case for left case
        if (index == s.length()) {
            return 1;
        }
        
        //find calcaluted value in memo
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        //base case when char is '0'
        if (s.charAt(index) == '0') {
            return 0;
        }
        
        //base case for right branch
        if (index == s.length() - 1) {
            return 1;
        }
        //left branch
        int ans = helper(index + 1, s, memo);
        //right branch
        if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
            ans += helper(index + 2, s, memo);
        }
        // add to memo
        memo.put(index, ans);
        
        return ans;
    }
}
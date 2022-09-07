class Solution {
    List<String> ans;
    public List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();
        ans.add(S);
        dfs(S.toCharArray(), 0);
        return ans;
    }
    
    private void dfs ( char[] s, int index ) {
        for ( int i = index; i < s.length; i++ ) {
            if ( Character.isAlphabetic(s[i]) ) {
                char temp = s[i];
                s[i] = ( Character.isLowerCase(s[i]) )? Character.toUpperCase(s[i]) :
                        Character.toLowerCase(s[i]);
                ans.add( new String(s) );
                dfs( s, i+1 );
                s[i] = temp;
            }
        }
    }
}
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int sLen = stamp.length(), tLen = target.length();
        if(stamp.charAt(sLen-1)!= target.charAt(tLen-1))return new int[0];
        StringBuilder sb = new StringBuilder(target);
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < 10*tLen; ++i){
            boolean add=false;
            for(int j = 0; j < tLen-sLen+1; ++j){
                if(sb.charAt(j)=='!'||sb.charAt(j)==stamp.charAt(0)){
                    if(matches(stamp, target, sb, j)&&set.add(j)){
                        add = true;
                        list.add(0, j);
                        for(int k = j; k < sLen+j; ++k){
                            if(sb.charAt(k)!='!'){
                                ++count;
                                sb.setCharAt(k, '!');
                            }
                        }
                    }
                }
                if(count == tLen)break;
            }
            if(count == tLen)break;
            if(!add)break;
        }
        boolean done = true;
        for(int i = 0; i < sb.length(); ++i){
            char chr = sb.charAt(i);
            if(chr != '!'){
                done = false;
                break;
            }
        }
        if(!done) return new int[0];
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; ++i){
            ans[i] = list.get(i);
        }
        return ans;
    }
    private boolean matches(String stamp, String target, StringBuilder sb, int index){
        for(int i = 0; i < stamp.length(); ++i){
            if(sb.charAt(i+index) == '!')continue;
            if(sb.charAt(i+index)!= stamp.charAt(i))return false;
        }
        return true;
    }
}
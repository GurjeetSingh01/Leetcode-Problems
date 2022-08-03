class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean flag=true;
        int j=0;
        for(int i=0;i<c1.length;i++)
        {
            if(c1[i]<c2[i])
            {
                flag=true;
                j=i;
                break;
            }
            else if(c1[i]>c2[i])
            {
                flag=false;
                j=i;
                break;
            }
        }
        if(flag)
        {
            for(;j<c1.length;j++)
                if(c1[j]>c2[j])
                    return false;
        }
        else
            for(;j<c1.length;j++)
                if(c1[j]<c2[j])
                    return false;
        return true;
    }
}
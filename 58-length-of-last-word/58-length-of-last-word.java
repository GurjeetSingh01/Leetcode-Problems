class Solution {
    public int lengthOfLastWord(String s) {
         int first_index = -1;
    
    for(int i = s.length()-1;i>=0;i--)
    {
        if(Character.isLetter(s.charAt(i)) == true)
        {
            first_index = i;
            break;
        }
    }
    
    int last_index = -1;
    
    if(first_index != -1)
    {
    
        for(int i = first_index;i>=0;i--)
        {
            if(Character.isWhitespace(s.charAt(i)) == true)
            {
                last_index = i;
                break;
            }
        }
    }
    
    //System.out.println("First" + first_index);
    //System.out.println("Last" + last_index);
    
    return (first_index-last_index);
}
}
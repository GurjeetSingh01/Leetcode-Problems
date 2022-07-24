class Solution {
    //AMAZON Question
    public List<Integer> partitionLabels(String s) {
	//Hashmap to map characters with their last index each
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int l = s.length();
        //Mapping final Index of all characters with their last Index 
        for(int i=0; i<l; ++i)map.put(s.charAt(i),i);
        int maximum = 0;
        int prev = -1;
        List<Integer> answer = new ArrayList<Integer>();//List for final answer
        for(int i=0; i<l; ++i)
        {
            int val = map.get(s.charAt(i));//Getting final Index of character from map
            if(val > maximum)maximum = val; // If Index is greater than maximum value then change
            if(maximum == i) //If traversal reaches maximum Index then it means we have our first list
            {
                answer.add(maximum-prev);//Pushing Length of chunk in the ArrayList
                prev = i;
            }
        }
        return answer;
    }
}
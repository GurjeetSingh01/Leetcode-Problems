class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        ArrayList<Integer> al3=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            al1.add(nums1[i]);
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            al2.add(nums2[i]);
        }
        
        for(int i=0;i<al1.size();i++)
        {
            if(al2.contains(al1.get(i)))
            {
                al3.add(al1.get(i));
            }
        }
        
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<al3.size();i++)
        {
            hs.add(al3.get(i));
        }
        ArrayList<Integer> al4=new ArrayList<>(hs);
        int a[]=new int[al4.size()];
        for(int i=0;i<al4.size();i++)
        {
            a[i]=al4.get(i);
        }
        return a;
    }
}
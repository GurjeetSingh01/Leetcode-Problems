class Solution {

 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  	int[] c = new int[nums1.length + nums2.length];
  	System.arraycopy(nums1, 0, c, 0, nums1.length);
  	System.arraycopy(nums2, 0, c, nums1.length, nums2.length);
  	Arrays.sort(c);
  	if(c.length%2==1){
  		return c[c.length/2];             
  	}
  	else{
  		return(double) (c[c.length/2]+c[(c.length/2)-1])/2;
  	}
}
}
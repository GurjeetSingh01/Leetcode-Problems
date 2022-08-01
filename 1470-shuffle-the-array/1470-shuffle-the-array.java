class Solution {
				public int[] shuffle(int[] nums, int n) {
					int [] ans = new int[2*n];
				int i = 0;
				 int left = 0;
				int right = n;

				while(left < n){
					ans[i++] = nums[left++];
					ans[i++] = nums[right++];
				}
				return ans;
				}
			}
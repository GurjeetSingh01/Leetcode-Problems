class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        # in sorted_num every num's i(index) shows just how many numbers are smaller than it, 
        # so we just add the indexes and return it.
        sorted_nums = sorted(nums)
        return [sorted_nums.index(num) for num in nums]
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        l=[]
        for val in nums:
            l.append(len(str(val)))
        count=0
        for val in l:
            if(val%2==0):
                count+=1
        return count
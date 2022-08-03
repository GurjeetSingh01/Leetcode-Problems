class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        my_count = 0
        my_dict = {}
        
        for G in nums:
            # Check to see if number has already been encountered
            # and increase count by the number of previous instances
            my_count += my_dict.get(G, 0) 

            # Increase the count of previous observation
            # Or store newly encountered number along with its count
            my_dict[G] = my_dict.get(G, 0) + 1
                
        return my_count
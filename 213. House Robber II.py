class Solution:

    def helper(self, nums: List[int]) -> int:
        pair: List[int] = [0, 0]
        for i in nums:
            pair.append(max(pair[0] + i, pair[1]))
            pair = pair[1:]
        return pair[1]

    def rob(self, nums: List[int]) -> int:
        return max(nums[0], self.helper(nums[1:]), self.helper(nums[:-1]))

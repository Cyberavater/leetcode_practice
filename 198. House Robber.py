from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        pair: List[int] = [0, 0]
        for i in nums:
            pair.append(max(pair[0] + i, pair[1]))
            pair = pair[1:]
        return pair[1]

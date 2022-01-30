# Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # abcabcbb moves from left to right
        charset = set()
        i = 0
        res = 0
        for point in range(len(s)):
            while (s[point] in charset):
                charset.remove(s[i])
                i = i+1
            charset.add(s[point])
            res = max(res, point-i +1)
        return res

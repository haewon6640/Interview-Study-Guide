# https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions


#Intervals

# Insert Interval
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        i = 0
        while (i < len(intervals) and intervals[i][1] < newInterval[0]):
            result.append(intervals[i])
            i = i+1
        while (i < len(intervals) and intervals[i][0] <= newInterval[1]):
            newInterval = [min(intervals[i][0],newInterval[0]),max(newInterval[1],intervals[i][1])]
            i = i+1
        result.append(newInterval)
        while (i < len(intervals)):
            result.append(intervals[i])
            i = i+1
        return result

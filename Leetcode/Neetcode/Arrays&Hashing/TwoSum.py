# https://leetcode.com/problems/two-sum/

def twoSum(nums, target):
    map = {}
    for i, num in enumerate(nums):
        if num in map:
            return [map[num], i]
        map[target-num] = i
    return None

print(twoSum([2,7,11,15],9))
print(twoSum([3,2,4],6))
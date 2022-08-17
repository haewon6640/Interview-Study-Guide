# https://leetcode.com/problems/contains-duplicate/

# nums = List[int]

def containsDuplicate(nums):
    map = set()
    for num in nums:
        if num in map:
            return True
        map.add(num)
    return False

print(containsDuplicate([1,2,3,4]))
# https://leetcode.com/problems/group-anagrams/

def groupAnagrams(strs):
    map1 = {}
    for str in strs:
        word = tuple(sorted(str))
        if word not in map1:
            map1[word] = []
        map1[word].append(str)
    return list(map1.values())

print(groupAnagrams( ["eat","tea","tan","ate","nat","bat"]))
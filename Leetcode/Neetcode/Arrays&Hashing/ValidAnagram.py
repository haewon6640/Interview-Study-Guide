# https://leetcode.com/problems/valid-anagram/

def isAnagram(s, t):
    map1 = {}
    for c in s:
        if c not in map1:
            map1[c] = 0
        map1[c] +=1 
    map2 = {}
    for c in t:
        if c not in map2:
            map2[c] = 0
        map2[c] +=1
    return map1 == map2

print(isAnagram("anagram", "nagarm"))
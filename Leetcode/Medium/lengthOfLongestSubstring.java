// Keep two pointers on the start of character index of the string
// Scan through the string with the right pointer and put the scanned characters to the hashmap.
// If the right pointer finds a duplicate character, let the left pointer be the right of the new 

// Kwwkew
// K, Kw, Kww: max = 2
// 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int a = 0;
        int b = 0;
        int max = 0;
        while (b < s.length()) {
            if (!set.contains(s.charAt(b))) {
                set.add(s.charAt(b++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(a++));
            }
        }
        return max;
        
        
        
        
        
        
        // int currLongest = 1;
        // int curr;
        // if (s.length() <= 1) {
        //     return s.length();
        // }
        // for (int i = 0; i < s.length()-1; i++) {
        //     curr = 1;
        //     for (int j = i+1; j < s.length(); j++) {
        //         if (!s.substring(i,j).contains("" + s.charAt(j))) {
        //             curr++;
        //             currLongest = Math.max(currLongest, curr);
        //         } else {
        //             break;
        //         }
        //     }
        // }
        // return currLongest;
    }
}
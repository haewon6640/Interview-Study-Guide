public class DFS_Examples {
    public static void main(String[] args) {
        numTile
    }
}
    //You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
    public int numTilePossibilities(String tiles) {
        int counts[] = new int[26];
        for (char c: tiles.toCharArray()) {
            counts[c-'A']++;
        }
        // we run dfs on each letter of tiles
        return dfs(counts);
    }
    // Example: tiles="AAB"
    // counts = [2,1,0,..,0];
    public int dfs(int[] counts) {
        int sum = 0; 
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            counts[i]--;
            sum = sum + 1 + dfs(counts);
            counts[i]++;
        }
        return sum;
        
    }
}
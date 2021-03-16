import java.util.*;
/*
* Design an algorithm that creates uniformly random permutations of {0,1,...,n-1}
* You are given a random number generator that returns integers in the set {0,1,...,n-1} with equal probability;
* use as few calls to it as possible.
* Ex) Input: 4 Output: [1,3,2,0]
*/
public class computeRandom {
    public static void main(String[] args) {
        
    }
    // Brute: Iteratively pick numbers randomly from [0,1,..,n-1] and discard if repeated
    // Ex) 1,2,1(discard),3,1(discard),2(discard),0
    // Space complexity is O(n) for the hash table, Time complexity: Coupon Collector's Problem
    // since as we get to later numbers, there's higher chance having to discard. On average, it's O(nlog(n))
    //
    public static List<Integer> computeRandomPermutation(int n) {
      // Creates a list with values 0,...,n-1
      List<integer> permutatation = IntStream.range(0,n).boxed().collect(Collectors.toList());
      // Just generate a random subset of size n 
      Sampling.offlineSampling(permutation.size(), permutation);
      return permutation;
    }
  
}

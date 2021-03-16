/*
* 1. Sample Offline Data
* Implement an algorithm that takes as input an array of distinct elements and a size,
* and returns a subset of the given size of the array elements.
* 
* 2. Sample Online Data
* Design a program that takes as input a size k, and reads packets,
* continuously maintaining a uniform random subset of size k of the read packets.
*
*/
import java.util.*;
public class Sampling {
    public static void main(String[] args) {
      List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 1));
      for(int i = 0; i < 10;i++) {
        offlineSampling(A,3);
        System.out.println(A);
      }
    }
    // k = subset size, size = n
    // O(nk)
    public static void offlineSampling(List<Integer> list, int size){
      Random rand = new Random();
      int next;
      for (int i = 0; i < size; i++) {
        next = rand.nextInt(list.size()-i)+i; // O(n)
        Collections.swap(list,i,next);
      }
    }
    /*
    * Note that in a continuous packet, a new packet has k/(n+1) probability of being picked.
    * We use that probability to determine whether it should be added or not,
    * then 
    */
    // Assuming at least k elements in the stream
    public static void onlineSampling(Iterator<Integer> stream, int k) {
        List<Integer> runningSample = new ArrayList<>(k);
        for (int i = 0; stream.hasNext() && i < k; i++) {
            runningSample.add(stream.next());
        }
        
        //Have read the first k elements
        int numSeenSoFar = k;
        Random randIdxGen = new Random();
        while (stream.hasNext()) {
            Integer x = stream.next();
            ++numSeenSoFar;
            // Geberate a random number in [0,numSeenSoFar], and if this number is in
            //[0,k-1], we replace that element from the sample with x.
            final int idxToReplace = randIdxGen.nextInt(numSeenSoFar);
            if (idxToReplace < k) {
                runningSample.set(idxToReplace, x);
            }
        return runningSample;
        }
    }
}

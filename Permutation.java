/*
* 1.Permute the elements of an array.
* Given an array A of n elements and a permutation P, apply P to A
* Ex) Input: A = <a,b,c,d>, P = <2,0,1,3> 
*     Output: <b,c,a,d>       
* 2.Compute the next permutation. 
* Given an array of integers, return the next array nder lexicographical ordering, 
* from the set of all arrays that are permutations of the input array.
* Ex) Input: <6,2,1,5,4,3,0>
*     Output: <6,2,3,0,1,4,5>
*/
import java.util.*;

public class Permutation {
  public static void main(String[] args) {
    // 1
    List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 1));
    List<Integer> P = new ArrayList<Integer>(Arrays.asList(2, 0, 1, 3));
    permute(A);
    System.out.println(A);
    List<Integer> arr = new ArrayList<Integer>(Arrays.asList(6,2,1,5,4,3,0));
    nextPermute(arr);
    System.out.println(arr);
                                              
  }
  
  public static void permute(List<Integer> A, List<Integer> P) {
      for (int i = 0; i < P.size(); i++) {
        while (P.get(i) != i) {
          Collections.swap(A,i,P.get(i));
          Collections.swap(P,i,P.get(i));
        }
      }
  }
  // Algorithm: Find 
  public static void nextPermute(List<Integer> arr) {
    int inversionPoint = arr.size()-2;
    while (inversionPoint >= 0 && arr.get(inversionPoint) > arr.get(inversionPoint+1)) {
      --inversionPoint;
    }
    for (int i = arr.size()-1; i > inversionPoint; --i) {
      if (arr.get(i) > arr.get(inversionPoint)) { 
        Collections.swap(arr, i, inversionPoint);
        break;
      }
    }
    Collections.reverse(arr.subList(inversionPoint+1,arr.size()));
  }
}

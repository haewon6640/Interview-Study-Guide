import java.util.Queue; 
public class SortArrayWithoutChangingNegativeNumberPosition
{
    public static void main(String[] args)
    {
    }
    //Goal:
    // Take all negative numbers and put them in a new array
    // create an array of positive valued indices
    // sort for those indices
    public static void sortArrayModified(int[] arr) {
        int[] negativeArr = new int[arr.length];
        Queue<Integer> q = new LinkedList<Integer>();
        // Take all negative numbers and put them in a new array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeArr[i] = arr[i];
            } else {
                q.add(i);
            }
        }
        // create an array of positive valued indices
        while (q)

    }
}
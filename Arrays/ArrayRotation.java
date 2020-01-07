import java.util.Arrays;

//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

public class ArrayRotation
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // number of elements to rotate by
        int rotate = 5;
        reversalAlgorithm(arr, rotate);
    }
    public static void secondMethod(int[] arr, int rotate) {
        for (int i = 0; i < rotate; i++)
        {
            leftRotateByOne(arr);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void leftRotateByOne(int[] arr)
    {
        int start = arr[0];
        for (int i = 0; i < arr.length - 1; i++)
        {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = start;
    }
    // Incomplete
    // public static void rotateByGCD(int[] arr, int rotate)
    // {
    //     int gcd = findGCD(arr.length, b);
    //     for (int i = 0; zx)
    //     }

    // public static int findGCD(int a, int b)
    // {
    //     if (b == 0)
    //     {
    //         return a;
    //     }
    //     return findGCD(b, a % b);
    // }


    // reverses arr[0..d-1], reverses arr[d, arr.length], then reverses the whole array
    public static void reversalAlgorithm(int[] arr, int d)
    {
        reverse(arr, 0, d);
        reverse(arr,d, arr.length);
        reverse(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int[] arr, int a, int b) {
        int[] temp = arr.clone();
        int x = 1;
        for (int i = a; i < b; i++) {
            arr[i] = temp[b-x];
            x++;
        }
    }
}
public class SortArrayWithoutChangingNegativeNumberPosition {
    public static void main(String[] args) {
        int[] arr = {2,6,-3,8,4,1}
        HashMap<> ab = new HashMap<Integer>();
    }

    public static int convertToBinary(int num) {
        String val = "";
        while(num > 0) {
            val = (num%2) + val;
            num /= 2;
        }
        if (val == "") {
            return 0;
        }
        return Integer.parseInt(val);
    }
}
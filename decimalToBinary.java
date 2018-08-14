public class decimalToBinary {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(convertToBinary(i));
        }
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
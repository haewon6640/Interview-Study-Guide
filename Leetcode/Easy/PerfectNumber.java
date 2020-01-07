public class PerfectNumber {
	// Given integer x, write a funciton that returns true when it is a perfect number and false when it is not.
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println(perfectNum(x));
    }
    public static boolean perfectNum(int x) {
    	int total = 1;
    	int sum;
    	for (int i = 2; i*i <= x;i++) {
    		if (x % i == 0) {
    			sum = i + (x / i);
    			total += sum;
    			sum = 0;
    		}
    	}

    	return (total == x);
    }
}
public class LCM {
    public static void main(String[] args) {
        System.out.println(LCM(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
    }
    public static int LCM(int a, int b) {
    	int high = Math.abs(Math.max(a,b));
    	int low = Math.abs(Math.min(a,b));
    	int lcm = high;
    	while (lcm % low != 0) {
    		lcm += high;
    	}
    	return lcm;
    }
}
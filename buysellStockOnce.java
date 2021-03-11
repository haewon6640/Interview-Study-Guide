/*
* Buy and Sell a Stock Once
* Design  an algorithm that determines the maximum profit 
* that could have been made by buying and then selling a single share over a given day range, 
* subject to the constraint that the buy and the sell have to take place at the start of the day;
* the sell must occur on a later day.
* Ex) 
* Input: [310,315,275,295,260,270,290,230,255,250]
* Output: 30 (290-260)
*/
public class buysellStockOnce {
    public static void main(String[] args) {
        int[] arr = {310,315,275,295,260,270,290,230,255,250};
        System.out.println(brute(arr));
    }
   
    // Iterate through all the possible sell options
    public static int brute(int[] arr) {
        int maxProfit = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length;j++) {
                if (arr[j]-arr[i] > maxProfit) {
                    maxProfit = arr[j]-arr[i];
                }
            }
        }
        return maxProfit;
    }
    
    // Keep track of maxProfit and while updating the minPrice
    public static int tracking(int[] arr) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: arr) {
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}

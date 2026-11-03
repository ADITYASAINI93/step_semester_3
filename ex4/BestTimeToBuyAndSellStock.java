/**
 * L2. Best Time to Buy and Sell Stock
 *
 * Given an array prices where prices[i] is the price of a stock on day i,
 * return the maximum profit you can achieve from a single buy and sell transaction.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if sold today
            else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);
        System.out.println("Test 1: " + result1); // Expected: 5

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(prices2);
        System.out.println("Test 2: " + result2); // Expected: 0

        // Test case 3
        int[] prices3 = {2, 4, 1};
        int result3 = solution.maxProfit(prices3);
        System.out.println("Test 3: " + result3); // Expected: 2

        // Test case 4
        int[] prices4 = {2, 1, 2, 1, 0, 1, 2};
        int result4 = solution.maxProfit(prices4);
        System.out.println("Test 4: " + result4); // Expected: 2
    }
}
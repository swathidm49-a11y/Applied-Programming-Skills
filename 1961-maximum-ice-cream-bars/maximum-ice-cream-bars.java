class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Step 1: Find the maximum cost in the array to size our frequency array
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }
        
        // Step 2: Build the frequency map (Counting Sort core)
        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }
        
        int iceCreamCount = 0;
        
        // Step 3: Greedily buy the cheapest ice cream bars first
        for (int price = 1; price <= maxCost; price++) {
            if (count[price] == 0) {
                continue;
            }
            
            // If we can't even afford one bar at this price, we are done
            if (coins < price) {
                break;
            }
            
            // Calculate how many bars we want to buy vs how many we can afford
            int quantityToBuy = Math.min(count[price], coins / price);
            
            // Update total bars bought and remaining coins
            iceCreamCount += quantityToBuy;
            coins -= quantityToBuy * price;
        }
        
        return iceCreamCount;
    }
}
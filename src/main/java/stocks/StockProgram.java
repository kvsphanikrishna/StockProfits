package stocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stock Program to find the maximum profit obtained.
 *
 * To verify the function, See StockProgramTest and configure test data.
 *
 * Note: I have used Java Collections & Junit libs for parameterizing and test case assertions.
 */
public class StockProgram {

    /**
     * Function to calculate the maximum profit attained from a list of Buy/Sell orders.
     *
     * Assumptions made:
     * 1. Buy order happens first and it will be followed by sell order.
     * 2. Incase of only single order, like buy, profit is calculated as 0.
     *
     * @param stockPrices - Stock Prices that contain a list of buy/sell orders.
     * @return - maximum profit
     */
    public int getMaxProfit(int[] stockPrices) {

        // Empty list to hold the profits earned, for processing them later.
        List<Integer> profitsGained = new ArrayList<>();

        //Since we have to calculate the difference between a buy & its following sell order, we are iterating through
        // each element in the array.
        for(int i=0; i<stockPrices.length-1; i++) {
            // Starting from the n+1th element, to calculate the difference from nth element.
            for(int j=i+1; j<stockPrices.length; j++) {
                //If the difference is > 0, its assumed to be a profit order, if its less than or equal to zero, then
                // it is assumed as loss/no profit, hence ignoring them.
                int profit = stockPrices[j] - stockPrices[i];
                if (profit > 0) {
                    profitsGained.add(profit);
                }
            }
        }
        // Once all the stocks records are processed, we are using Java Collections, to find the max element.
        // If the list is empty, then there is no profit obtained, so returning profit as 0,
        // however if the list is not empty, then the max value in the list, is the max profit earned.
        return profitsGained.size() > 0 ? Collections.max(profitsGained) : 0;
    }


}

package stocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StockProgramTest {

    /**
     * Test to verify the profit function for given test data.
     * This test was explicitly written for the assertion requirement mentioned in the problem statement.
     */
    @Test
    public void validateProfitForGivenTestData() {
        StockProgram stockProgram = new StockProgram();
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        int profit = stockProgram.getMaxProfit(stockPrices);
        Assertions.assertEquals(6, profit);
    }

    /**
     * Test function to verify the profit earned based on a list of stock prices.
     * @param stockPricesList - The list of stock prices.
     */
    @ParameterizedTest
    @MethodSource("getStockPricesList")
    public void verifyProfitsEarned(int[] stockPricesList) {
        StockProgram stockProgram = new StockProgram();
        int profit = stockProgram.getMaxProfit(stockPricesList);
        System.out.println("Profit obtained is: " + profit + " for stock prices: " + Arrays.toString(stockPricesList));
    }

    /**
     * Generate a list of arguments to be used in the 'verifyProfitsEarned' parameterized method.
     * @return - List of integer arrays.
     */
    private static List<int[]> getStockPricesList() {
        return Arrays.asList(
                new int[]{10,7, 5, 8, 11, 9}, //Given test data
                new int[]{1, 1}, // Assuming there is only one buy and sell order.
                new int[]{1}, // Assuming there is only one buy and no sell order.
                generateRandomList(10, 1, 10), // a random integer array.
                generateRandomList(20, 30, 100)
                );
    }

    /**
     * Generate a random array list based on user input.
     *
     * @param size - Number of elements in the array.
     * @param start - the origin (inclusive) of each random value
     * @param end -  the bound (exclusive) of each random value
     * @return - Returns randomly generated integer array.
     */
    private static int[] generateRandomList(int size, int start, int end) {
        Random random = new Random();
        return random.ints(size, start, end).toArray();
    }
}

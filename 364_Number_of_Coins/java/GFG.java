/**
 * @author Loris Reiff
 * 
 * Number of Coins
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=364
 */

import java.util.Scanner;

class GFG {
	
	/**
	 * Returns the least amount of coins that are needed to sum up to a value.
	 * If it is not possible to sum up to the value -1 is returned
	 * 
	 * @param value The value the coins should sum up to
	 * @param coins Am array with the values of the different coins available
	 * @return The least amount of coins needed 
	 */
	public static int minNumberOfCoins(int value, int[] coins) {
		int[] table = new int[value + 1];
		return minNumberOfCoins(value, coins, table);
	}
	
	private static int minNumberOfCoins(int value, int[] coins, int[] table) {
		if(value == 0) return 0;
		if(value < 0) return -1;
		if(table[value] != 0) return table[value];
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < coins.length; i++) {
			int n = minNumberOfCoins(value - coins[i], coins, table);
			if(0 <= n && n < min) {
				min = n + 1;
			}
		}
		if(min != Integer.MAX_VALUE)
			table[value] = min;
		else
			table[value] = -1;

		return table[value];
	}
	
	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);
		int runs = console.nextInt();
		
		for(int i = 0; i < runs; i++) {
			int value = console.nextInt();
			int numberOfCoins = console.nextInt();
			int coins[] = new int[numberOfCoins];
			for(int j = 0; j < numberOfCoins; j++) {
				coins[j] = console.nextInt();
			}
			
			System.out.println(minNumberOfCoins(value, coins));
		}
		console.close();
	}
}
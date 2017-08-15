/**
 * @author Loris Reiff
 *
 * Coin Change
 * http://practice.geeksforgeeks.org/problems/coin-change/0
 */

import java.util.Scanner;

class GFG {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t-- > 0) {
			int r = testCase(sc);
			System.out.println(r);
		}
	}

	public static int testCase(Scanner sc) {
		int m = sc.nextInt();
		int[] A = new int[m+1];

		for(int i = 1; i <= m; i++) {
			A[i] = sc.nextInt();
		}
		int n = sc.nextInt();

		int[][] DP = new int[m+1][n+1];

		// initialize DP
		for(int i = 0; i <= m; i++) {
			DP[i][0] = 1;
		}

		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				DP[i][j] += DP[i-1][j];
				if(j >= A[i])
					DP[i][j] += DP[i][j-A[i]];
			}
		}

		return DP[m][n];
	}

}

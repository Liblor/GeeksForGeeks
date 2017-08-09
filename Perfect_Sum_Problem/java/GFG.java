/**
 * @author Loris Reiff
 *
 * Perfect Sum Problem
 * http://practice.geeksforgeeks.org/problems/perfect-sum-problem/0
 */

import java.util.Scanner;

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0) {
			int r = testCase(sc);
			System.out.println(r);
		}
		sc.close();
	}

	public static int testCase(Scanner sc) {
		int n = sc.nextInt();
		int[] A = new int[n+1];
		for(int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		int sum = sc.nextInt();

		int[][] DP = new int[n+1][sum+1];

		// initialize DP
		for(int i = 0; i <= n; i++) {
			DP[i][0] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				DP[i][j] += DP[i-1][j];
				if(j >= A[i])
					DP[i][j] += DP[i-1][j-A[i]];
			}
		}
		return DP[n][sum];
	}
}

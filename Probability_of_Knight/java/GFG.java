/**
 * @author Loris Reiff
 *
 * Probability of Knight
 * http://practice.geeksforgeeks.org/problems/probability-of-knight/0
 */

import java.text.DecimalFormat;
import java.util.Scanner;

class GFG {
	// all legal knight moves
	public static int[][] moves = {
			{-1, -2},
			{-1, 2},
			{1, -2},
			{1, 2},
			{-2, -1},
			{-2, 1},
			{2, -1},
			{2, 1},
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0) {
			double r = testCase(sc);
			DecimalFormat df = new DecimalFormat("0.000000");
			System.out.println(df.format(r));
		}
		sc.close();
	}

	public static double testCase(Scanner sc) {
		int n = sc.nextInt();	// chessboard size
		int x = sc.nextInt();	// (x,y) location of knight
		int y = sc.nextInt();
		int k = sc.nextInt();	// number of steps

		// DP[z][y][x] represents the probability to get to
		// coordinate (x,y) in z steps
		double[][][] DP = new double[k][n][n];
		initializeDP(DP, x, y, n);

		for(int step = 1; step < k; step++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					updateDpEntry(DP, step, i, j, n);
				}
			}
		}

		double r = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				r += DP[k-1][i][j];
			}
		}
		return r;
	}

	public static void initializeDP(double[][][] DP, int x, int y, int n) {
		// probability for first step
		double p = 1.0/8.0;

		for(int[] coord : moves) {
			int i = y + coord[1];
			int j = x + coord[0];
			if(inField(j, i, n))
				DP[0][i][j] = p;
		}
	}

	public static void updateDpEntry(double[][][] DP, int step, int x, int y, int n) {
		for(int[] coord : moves) {
			int i = y + coord[1];
			int j = x + coord[0];
			if(inField(j, i, n))
				DP[step][y][x] += DP[step-1][i][j] / 8;
		}
	}

	public static boolean inField(int x, int y, int n) {
		return (x >= 0 && y >= 0 && x < n && y < n);
	}
}

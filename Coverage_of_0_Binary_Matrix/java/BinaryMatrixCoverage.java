import java.util.Scanner;

/**
 * @author Loris Reiff
 * 
 * Coverage of all Zeros in a Binary Matrix
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=1569
 */


public class BinaryMatrixCoverage {
	
	public static int calculateTotalCoverage(int[][] matrix) {
		int totalCoverage = 0;
		for(int i = 1; i < matrix.length - 1; i++) {
			for(int j = 1; j < matrix[0].length - 1; j++) {
				if(matrix[i][j] == 0) {
					if(matrix[i-1][j] == 1 )
						totalCoverage++;
					if(matrix[i+1][j] == 1)
						totalCoverage++;
					if(matrix[i][j-1] == 1)
						totalCoverage++;
					if(matrix[i][j+1] == 1)
						totalCoverage++;
				}
			}
		}
		return totalCoverage;
	}
	
	public static void main(String args[]) {
		Scanner console = new Scanner(System.in);
		int runs = console.nextInt();
		
		for(int i = 0; i < runs; i++) {
			int n = console.nextInt();
			int m = console.nextInt();
			// zero ring around matrix
			int matrix[][] = new int[n + 2][m + 2];
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= m; k++) {
					matrix[j][k] = console.nextInt();
				}
			}
			System.out.println(calculateTotalCoverage(matrix));
		}
		console.close();
	}

}

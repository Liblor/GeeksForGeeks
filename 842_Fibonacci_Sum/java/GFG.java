/**
 * @author Loris Reiff
 * 
 * Fibonacci Sum
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=842
 */

import java.util.Scanner;

class GFG {
	public static long[] T = new long[100001];
	public static int Upto;

	/**
	 * Sums up the fibonacci numbers up to n <= 100000
	 * 
	 * @param n Sum up to the n's Fibonacci number <= 100000
	 * @param modulo Must be a prime number otherwise it is not a field
	 * @return
	 */
	public static long fibSum(int n, long modulo) {
		if(n <= Upto) {
			return T[n];
		}
		long previous = T[Upto-1] - T[Upto-2];
		long current = T[Upto] - T[Upto-1];
		if(previous < 0) {
			previous += modulo;
		}
		if(current < 0)
			current += modulo;
		long sum = T[Upto];
		for(int i = Upto + 1; i <= n; i++) {
			long tmp = current;
			current = ((current + previous) % modulo);
			previous = tmp;
			sum = (sum + current) % modulo;
			T[i] = sum;
			Upto = i;
		}
		return sum;
}
	
	public static void main (String[] args) {
		T[0] = 0;
		T[1] = 1;
		T[2] = 2;
		Upto = 2;
		Scanner console = new Scanner(System.in);
		int runs = console.nextInt();
		
		for(int i = 0; i < runs; i++) {
			int x = console.nextInt();
			System.out.println(fibSum(x, 1000000007));
		}
		console.close();
	}
}
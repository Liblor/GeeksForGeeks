/**
 * @author Loris Reiff
 *
 * Smallest distinct window
 * http://practice.geeksforgeeks.org/problems/smallest-distant-window/0
 */

import java.util.HashMap;
import java.util.Scanner;

class GFG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0) {
			int r = testCase(sc);
			System.out.println(r);
		}
		sc.close();
	}

	public static int testCase(Scanner sc) {
		String input = sc.next();
		HashMap<Character, Integer> d = new HashMap<Character, Integer>(26);

		for(char c : input.toCharArray()) {
			d.put(c, 0);
		}

		int min = input.length();
		int i = 0;
		int j = 0;
		int unique;

		d.put(input.charAt(0), 1);
		unique = 1;

		while(i <= j) {
			while(unique != d.size() && j+1 < input.length()) {
				j++;
				int tmp = d.get(input.charAt(j));
				if(tmp == 0) unique++;
				d.put(input.charAt(j), ++tmp);
			}

			if(unique == d.size())		// every letter used?
				min = Math.min(min, j-i+1);

			int tmp = d.get(input.charAt(i));
			d.put(input.charAt(i), --tmp);
			if(tmp == 0) unique--;
			i++;
		}

		return min;
	}
}

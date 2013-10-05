package p_051_to_060;

import java.util.Vector;

public class P058 {

	/*
	 * 	37 36 35 34 33 32 31
		38 17 16 15 14 13 30
		39 18  5  4  3 12 29
		40 19  6  1  2 11 28
		41 20  7  8  9 10 27
		42 21 22 23 24 25 26
		43 44 45 46 47 48 49 
		
		br: n^2 (1, 9, 25, 49, 81)
		tr: (n-2)^2 + n - 1 (1, 3, 13, 31, 57)
		bl: n^2 - n + 1 (1, 7, 21, 43, 73)
		tl: n^2 - 2n + 2 (1, 5, 17, 37)
		
	 */
	
	public static Vector<Integer> primes = new Vector<Integer>();
	
	public static void getPrimesUpTo(int n) {
		primes.add(2);
		primes.add(3);
		for (int i = 5; i < n; i += 2) {
			if (isPrime(i)) primes.add(i);
		}
	}
	
	public static boolean isPrime(int i) {
		int limit = (int) Math.sqrt(i);
		for (int p : primes) {
			if (i == p || p > limit) return true;
			if (i % p == 0) return false;
		}
		
		return true;
	}
	
	public static int trDiag(int n) {
		return (int) Math.pow(n - 2, 2) + n - 1;
	}
	
	public static int blDiag(int n) {
		return (int) (Math.pow(n, 2) - n + 1);
	}
	
	public static int tlDiag(int n) {
		return (int) (Math.pow(n, 2) - 2 * n + 2);
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(27000);
		int size = 1;
		int ps = 0;
		double density = 0;
		do {
			size += 2;
			double diagSize = size * 2 - 1;
			int tr = trDiag(size);
			int bl = blDiag(size);
			int tl = tlDiag(size);
			if (isPrime(tr)) ps++;
			if (isPrime(bl)) ps++;
			if (isPrime(tl)) ps++;
			
			 density = ps / diagSize;			
		} while (density >= 0.1);
		
		System.out.println(size);
	}

}

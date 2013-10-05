package p_051_to_060;

import java.util.Vector;

public class P051 {

	public static Vector<Integer> primes = new Vector<Integer>();
	public static Integer[] primeArr = {};


	public static void getPrimesUpTo (int n) {
		primes.add(2);
		primes.add(3);

		for (int i = 5; i <= n; i += 2) {
			if (isPrime(i)) 
				primes.add(i);
		}
		
		primeArr = primes.toArray(primeArr);
		System.out.println("Primes Ready!");
		
	}

	public static boolean isPrime(int n) {
		int limit = (int) Math.sqrt(n);
		for (int p : primes) {
			if (p > limit) return true;
			if (n % p == 0 && n != p) return false;
		}

		return true;
	}
	
	public static int replaceDigit(int num, int digit, int loc) {
		char[] ca = Integer.toString(num).toCharArray();
		ca[loc + 1] = (char) digit;
		return Integer.parseInt(String.valueOf(ca));
	}
	
	public static int replaceManyDigits(int num, int digit, int... locs) {
		int ans = num;
		for (int loc : locs) {
			ans = replaceDigit(ans, digit, loc);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		

	}

}

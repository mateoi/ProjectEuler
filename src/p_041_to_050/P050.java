package p_041_to_050;

import java.util.Vector;

public class P050 {

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

	}

	public static boolean isPrime(int n) {
		int limit = (int) Math.sqrt(n);
		for (int p : primes) {
			if (p > limit) return true;
			if (n % p == 0 && n != p) return false;
		}

		return true;
	}
	
	public static int longestChain(int seedLoc, int limit) {
		int ans = 0;
		int sum = 0;
		for (int i = seedLoc; sum < limit && i < primeArr.length; i++) {
			sum += primeArr[i];
			if (isPrime(sum)) ans = 1 + i - seedLoc;
		}
		
		return ans;
		
	}
	
	public static int applyChain(int seedLoc, int times) {
		int ans = 0;
		
		for (int i = 0; i < times; i++) {
			ans += primeArr[i + seedLoc];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int limit = 1000000;
		getPrimesUpTo(limit);
		
		System.out.println("Primes Ready!");

		int max = 0;
		int max_ans = 0;
		int max_i = 0;
		
		for (int i = 0; i < primeArr.length; i++) {
			int chain = longestChain(i, limit);
			if (primeArr[i] * max > limit) break;
			if (chain > max) {
				max = chain;
				max_ans = primeArr[i];
				max_i = i;
			}
		}
		
		System.out.println(max);
		System.out.println(max_ans);
		System.out.println(applyChain(max_i, max));
	}

}

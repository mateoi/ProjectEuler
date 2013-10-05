package p_061_to_070;

import java.util.Vector;

public class P069 {

	public static Vector<Integer> primes = new Vector<Integer>();
	
	public static void getPrimesUpTo(int n) {
		primes.add(2);
		primes.add(3);
		for (int i = 5; i < n; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		int limit = (int) Math.sqrt(n);
		for (int p : primes) {
			if (p > limit || p == n) return true;
			if (n % p == 0) return false;
		}
		
		return true;
	}
	
	public static double phiOverN(int n) {
		double ans = 1;
		Integer[] divisors = primeDivisors(n);
		for (Integer i : divisors) {
			ans *= (1 - 1.0 / i);
		}
		
		return ans;
	}
	
	public static Integer[] primeDivisors(int n) {
		Integer[] ans = {};
		Vector<Integer> divisors = new Vector<Integer>();
		int limit = (int) Math.sqrt(n);
		for (int p : primes) {
			if (p > limit) {
				break;
			}
			
			if (n % p == 0) {
				divisors.add(p);
				do {
					n /= p;
				} while (n % p == 0);				
			}
			
			
		}
		if (n > 1) divisors.add(n);
		ans = divisors.toArray(ans);
		return ans;
		
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(1000);
		System.out.println("done with primes!");
		double min = Double.MAX_VALUE;
		int min_i = 0;
		
		
		
		for (int i = 2; i < 1000001; i++) {
			double pon = phiOverN(i);
			if (pon < min) {
				System.out.println("i: " + i + ", pon: " + pon);

				min = pon;
				min_i = i;
			}
		}
		
		System.out.println(min_i);
	}

}

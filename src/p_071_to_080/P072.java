package p_071_to_080;

import java.util.Vector;

public class P072 {
	
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
	
	public static double phi(int n) {
		double ans = 1;
		
		int limit = (int) Math.sqrt(n);
		for (int p : primes) {
			if (p > limit) break;
			
			if (n % p == 0) {
				ans *= (1 - 1.0 / p);
				do {
					n /= p;
				} while (n % p == 0);				
			}
			
			
		}
		
		if (n > 1) ans *= (1 - 1.0 / n);
		
		return ans;
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(1000);
		double ans = 0;
		for(int i = 2; i <= 1000000; i++) {
			ans += i * phi(i);
		}
		
		System.out.println(ans);
		
	}

}

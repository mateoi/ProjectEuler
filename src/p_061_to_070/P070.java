package p_061_to_070;

import java.util.Vector;

public class P070 {

	
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
	
	public static boolean isPerm(int i1, int i2) {
		int[] d1 = new int[10];
		int[] d2 = new int[10];
		while (i1 != 0 || i2 != 0) {
			d1[i1 % 10]++;
			d2[i2 % 10]++;
			i1 /= 10;
			i2 /= 10;
		}
		
		for (int i = 0; i < d2.length; i++) {
			if (d1[i] != d2[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(10000);
		System.out.println("primes done!");
		
		double maxPoN = 0;
		int ans = 0;
		for (int i = 6000001; i < 10000000; i += 6) {
			double pon1 = phiOverN(i);
			int phi1 = (int) (pon1 * i);
			if (pon1 > maxPoN && isPerm(i, phi1)) {
				maxPoN = pon1;
				ans = i;
				System.out.println(i + ", " + phi1 + ", " + maxPoN);
			}
			
			double pon2 = phiOverN(i + 2);
			int phi2 = (int) (pon2 * (i + 2));
			if (pon2 > maxPoN && isPerm(i, phi2)) {
				maxPoN = pon2;
				ans = i + 2;
				System.out.println((i + 2) + ", " + phi2 + ", " + maxPoN);
			}
		}
		
		System.out.println(ans);
	}

}

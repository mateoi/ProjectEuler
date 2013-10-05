package p_041_to_050;

import java.util.Vector;

public class P046 {

	
	public static Vector<Integer> primes = new Vector<Integer>();
	public static Vector<Integer> oddComps = new Vector<Integer>();
	
	
	public static void populateUpTo (int n) {
		primes.add(2);
		primes.add(3);
		
		for (int i = 5; i <= n; i += 2) {
			if (isPrime(i))
				primes.add(i);
			else
				oddComps.add(i);
		}
				
	}
	
	public static boolean isPrime(int n) {
		for (int p : primes) {
			if (n % p == 0) return false;
		}
		
		return true;
	}
	
	public static boolean hasGoldbach(int c) {
		for (int p : primes) {
			if (p > c) return false;
			int sq = 2;
			int count = 1;
			while (p + sq <= c) {
				if (p + sq == c) return true;
				count++;
				sq = 2 * count * count;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		populateUpTo(10000);
		for (int c : oddComps) {
			if (!hasGoldbach(c)) {
				System.out.println(c);
				return;
			}
		}
		
	}

}

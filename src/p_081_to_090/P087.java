package p_081_to_090;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class P087 {

	public static Vector<Integer> primes = new Vector<Integer>();
	
	public static void getPrimesUpTo(int n) {
		primes.add(2);
		primes.add(3);
		
		for (int i = 5; i <= n; i += 2) {
			if (isPrime(i)) primes.add(i);
		}
	}
	
	public static boolean isPrime(int i) {
		int limit = (int) Math.sqrt(i);
		for (int p : primes) {
			if (p == i) return true;
			if (i % p == 0) return false;
			if (p > limit) return true;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		getPrimesUpTo(7500);
		int limit = 50000000;
		Set<Integer> nums = new TreeSet<Integer>();
		
		for (int psq : primes) {
			int sq = psq * psq;
			for (int pcu : primes) {
				int cu = pcu * pcu * pcu;
				if (sq + cu > limit) break;
				for (int pfo : primes) {
					int fo = pfo * pfo * pfo * pfo;
					if (sq + cu + fo < limit) {
						nums.add(sq + cu + fo);
					}
					else break;
				}
				
			}
			
		}
		
		System.out.println(nums.size());
	}

}

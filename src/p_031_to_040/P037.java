package p_031_to_040;

import java.util.LinkedHashSet;
import java.util.Set;

public class P037 {

public static Set<Integer> primes = new LinkedHashSet<Integer>();
public static Set<Integer> truncatable_l = new LinkedHashSet<Integer>();
public static Set<Integer> truncatable_candidates = new LinkedHashSet<Integer>();
public static Set<Integer> truncatable = new LinkedHashSet<Integer>();
	
	public static void getPrimesUpTo(int n) {
		primes.add(2);
		for (int i = 3; i < n; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
				if (isTruncatableLeft(i)) {
					truncatable_l.add(i);
				}
			}
		}
		System.out.println("done!");
	}
	
	public static boolean isPrime(int n) {
		if (n == 1) return false;
		for (int p : primes) {
			if (n == p) return true;
			if (n % p == 0) return false;
		}
		return true;
	}
	
	public static boolean isTruncatable(int p) {
		int truncLeft = p;
		int truncRight = p;
		int left = 1;
		
		while (truncLeft != 0) {
			if (!isPrime(truncLeft) || !isPrime(truncRight)) return false;
			truncLeft /= 10;
			left *= 10;
			truncRight = p % left;
		}
		
		
		return true;
	}
	
	public static boolean isTruncatableLeft(int p) {
		int truncLeft = p;
		
		while (truncLeft != 0) {
			if (!isPrime(truncLeft)) return false;
			truncLeft /= 10;
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(100000);
		int ans = 0;
		truncatable_l.add(2);
	
		for (int tl : truncatable_l) {
			truncatable_candidates.add(tl * 10 + 3);
			truncatable_candidates.add(tl * 10 + 7);
		}
		
		for (int tc : truncatable_candidates) {
			if (isTruncatable(tc)) truncatable.add(tc);
		}
		
		for (int t : truncatable) {
			System.out.println(t);
			ans += t;
		}
		
		System.out.println(truncatable.size());
		System.out.println(ans);
	}

}

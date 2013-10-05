package p_001_to_010;

import java.util.ArrayDeque;

public class P005 {

	public static ArrayDeque<Integer> primes = new ArrayDeque<Integer>();
	
	public static void genPrimesUpTo(int n) {
		primes.add(2);
		primes.add(3);
		for (int i = 5; i <= n; i += 2) {
			boolean passed = true;
			for (int j : primes) {
				if (i % j == 0) {
					passed = false;
					break;
				}
			}
			
			if (passed) primes.add(i);
		}
	}
	
	public static void main(String[] args) {
		
		genPrimesUpTo(20);
		
		int ans = 1;
		for (int p : primes) {
			int needed = 1;
			
			do {
				needed *= p;
			} while (needed * p <= 20);
			
			ans *= needed;
		}
		
		System.out.println(ans);
	}

}

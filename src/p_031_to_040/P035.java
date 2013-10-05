package p_031_to_040;

import java.util.LinkedHashSet;
import java.util.Set;

public class P035 {

	public static Set<Integer> primes = new LinkedHashSet<Integer>();
	
	public static void getPrimesUpTo(int n) {
		primes.add(2);
		for (int i = 3; i < n; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for (int p : primes) {
			if (n == p) return true;
			if (n % p == 0) return false;
		}
		return true;
	}
	
	public static boolean isCyclicPrime(int n) {
		int[] arr = new int[(int)Math.log10(n) + 1];
		int newn = n;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = newn % 10;
			newn /= 10;
		}
		
		for (int i = 0; i < arr.length; i++) {
			int num = 0;
			for (int j = 0; j < arr.length; j++) {
				num *= 10;
				num += arr[(i + j) % arr.length];
			}
			if (!isPrime(num)) return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		getPrimesUpTo(1000000);
		System.out.println("Primes generated.");
		int ans = 0;
		
		for (int p : primes) {
			if (isCyclicPrime(p)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}

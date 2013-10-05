package p_001_to_010;
import java.util.ArrayDeque;


public class P010 {

	public static ArrayDeque<Integer> primes = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		int limit = 2000000;
		primes.add(2);
		double sum = 2;
		for (int i = 3; i < limit; i += 2) {
			if (isPrime(i)) {
				sum += i;
				primes.add(i);
			}
		}
		
		System.out.println(sum);

	}

	public static boolean isPrime (int n) {

		for (int i : primes) {
			if (n % i == 0) return false;
		}

		return true;
	}


}

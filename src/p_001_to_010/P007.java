package p_001_to_010;
import java.util.ArrayDeque;

public class P007 {


	public static int nthPrime(int n) {
		if (n == 1) return 2;
		if (n <= 0) return -1;

		int count = 2;
		int ans = 1;
		while (count < n) {
			ans += 2;
			if (isPrime(ans)) {
				count++;
				primes.add(ans);
			}
		}
		return ans;
	}

	public static boolean isPrime (int n) {

		for (int i : primes) {
			if (n % i == 0) return false;
		}

		return true;
	}

	public static ArrayDeque<Integer> primes = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		primes.add(2);
		primes.add(3);
		System.out.println(nthPrime(10001));

	}

}

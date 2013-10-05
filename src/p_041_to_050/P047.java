package p_041_to_050;

import java.util.Vector;

public class P047 {

	public static Vector<Integer> primes = new Vector<Integer>();


	public static void getPrimesUpTo (int n) {
		primes.add(2);
		primes.add(3);

		for (int i = 5; i <= n; i += 2) {
			if (isPrime(i))
				primes.add(i);
		}

	}

	public static boolean isPrime(int n) {
		for (int p : primes) {
			if (n % p == 0) return false;
		}

		return true;
	}



	public static int noOfFactors(int n) {
		if (n <= 1) return 0;
		for (int p : primes) {
			if (n % p == 0) {
				while (n % p == 0) {
					n /= p;
				}
				return 1 + noOfFactors(n);
			}
		}

		return -1;


	}

	public static void main(String[] args) {
		getPrimesUpTo(1000);

		int f1 = noOfFactors(644);
		int f2 = noOfFactors(645);
		int f3 = noOfFactors(646);
		int f4 = noOfFactors(647);

		for (int i = 645; i < 150000; i++) {
			f1 = f2;
			f2 = f3;
			f3 = f4;
			f4 = noOfFactors(i + 3);
			if (f1 >= 4 && f2 >= 4 && f3 >= 4 && f4 >= 4) {
				System.out.println(i);
				return;
			}
		}

	}

}

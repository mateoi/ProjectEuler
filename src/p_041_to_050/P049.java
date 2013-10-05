package p_041_to_050;

import java.util.Vector;

public class P049 {

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
			if (n % p == 0 && n != p) return false;
		}

		return true;
	}
	
	public static boolean isPerm(int n1, int n2) {

		int[] b1 = {0,0,0,0,0,0,0,0,0,0};
		int[] b2 = {0,0,0,0,0,0,0,0,0,0};
		
		do {
			b1[n1 % 10]++;
			b2[n2 % 10]++;
			
			n1 /= 10;
			n2 /= 10;
		} while (n1 != 0 || n2 != 0);
		
		for (int i = 0; i < 10; i++) {
			if (b1[i] != b2[i]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		getPrimesUpTo(10000);
		
		Integer[] arr = {};
		arr = primes.toArray(arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int p1 = arr[i];
				int p2 = arr[j];
				int p3 = p2 + (p2 - p1);
				if (isPrime(p3) && isPerm(p1, p2) && isPerm(p1, p3) && p1 > 1000 && p3 < 10000) {
					System.out.println("Combo found!: " + p1 + ", " + p2 + ", " + p3);
				}
			}
		}

		
	}

}

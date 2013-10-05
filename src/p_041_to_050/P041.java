package p_041_to_050;

import java.util.ArrayDeque;

public class P041 {

	public static ArrayDeque<Double> pandigitals = new ArrayDeque<Double>();
	public static ArrayDeque<Double> primes = new ArrayDeque<Double>();
	
	public static void genPandigitals() {
		int[] digits = {7,6,5,4,3,2,1};
		do {
			double d = decodeArray(digits);
			pandigitals.add(d);
			iterArray(digits);
		} while (digits[0] >= 2);
	}
	
	public static double decodeArray(int[] arr) {
		double ans = 0;
		for (int i : arr) {
			ans *= 10;
			ans += i;
		}
		
		return ans;
	}
	
	public static void iterArray(int[] arr) {
		int k = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]){
				k = i;
			}
		}
				
		if (k == -1) return;
		
		int l = 0;
		for (int i = k + 1; i < arr.length; i++) {
			if (arr[k] > arr[i]) {
				l = i;
			}
		}
		
		int temp = arr[k];
		arr[k] = arr[l];
		arr[l] = temp;
		
		int fst = k + 1;
		int lst = arr.length - 1;
		while (fst < lst) {
			temp = arr[fst];
			arr[fst] = arr[lst];
			arr[lst] = temp;
			fst++;
			lst--;
		}
	}
	
	public static void getPrimesUpTo(double n) {
		primes.add((double) 2);
		primes.add((double) 3);
		
		for (double i = 5; i < n; i += 2) {			
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}
	
	public static boolean isPrime(double n) {
		for (double p : primes) {
			if (n % p == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {

		genPandigitals();
		getPrimesUpTo(100000);
		
		for (double d : pandigitals) {
			if (isPrime(d)) {
				System.out.println("prime!: " + d);
				return;
			}
		}
		
		System.out.println("No primes found!");
	}

}

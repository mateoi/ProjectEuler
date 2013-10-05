package p_041_to_050;

import java.util.ArrayDeque;

public class P043 {

	public static ArrayDeque<Double> pandigitals = new ArrayDeque<Double>();
	
	public static boolean hasWeirdProperty(double d) {
		int part1 = (int) ((d / 1000000) % 1000);
		int part2 = (int) ((d / 100000) % 1000);
		int part3 = (int) ((d / 10000) % 1000);
		int part4 = (int) ((d / 1000) % 1000);
		int part5 = (int) ((d / 100) % 1000);
		int part6 = (int) ((d / 10) % 1000);
		int part7 = (int) (d % 1000);
		
		return
				part1 % 2 == 0 &&
				part2 % 3 == 0 &&
				part3 % 5 == 0 &&
				part4 % 7 == 0 &&
				part5 % 11 == 0 &&
				part6 % 13 == 0 &&
				part7 % 17 == 0;
	}
	
	public static void genPandigitals() {
		int[] digits = {1,0,2,3,4,5,6,7,8,9};
		double d;
		do {
			d = decodeArray(digits);
			pandigitals.add(d);
			iterArray(digits);
		} while (d < 9876543210.0);
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
			if (arr[i] < arr[i + 1]){
				k = i;
			}
		}
				
		if (k == -1) return;
		
		int l = 0;
		for (int i = k + 1; i < arr.length; i++) {
			if (arr[k] < arr[i]) {
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
	
	public static void main(String[] args) {
		genPandigitals();
		double ans = 0;
		
		for (double p : pandigitals) {
			if (hasWeirdProperty(p)) ans += p;
		}
		
		System.out.println(ans);
		
	}

}

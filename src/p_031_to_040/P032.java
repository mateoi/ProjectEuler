package p_031_to_040;

import java.util.HashSet;
import java.util.Set;


public class P032 {

	public static Set<Integer> nums = new HashSet<Integer>();
	
	public static boolean pandigital(int... is) {
		boolean[] digits = new boolean[9];
		int totalDigits = 0;

		for (int i : is) {
			while (i != 0) {
				int digit = i % 10;
				if (digit == 0 || totalDigits > 9) return false;
				digits[digit - 1] = true;
				totalDigits++;
				i /= 10;
			}
		}

		for (boolean b : digits) {
			if (!b) return false;
		}
		
		return totalDigits == 9;
	}

	public static void main(String[] args) {
		int ans = 0;

		for (int i = 1; i < 9876; i++) {
			for (int j = 1; j < i; j++) {
				int prod = i * j;
				if (pandigital(i, j, prod)) {
					nums.add(prod);
					//System.out.println(i + " * " + j + " = " + prod);
				}
			}
		}

		for (int i : nums) {
			ans += i;
		}

		System.out.println(ans);
	}

}

package p_031_to_040;

public class P038 {

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
		float max = 0;
		int maxi = 0;
		for (int i = 9123; i <= 9876; i++) {
			if (pandigital(i, i*2)) {
				float conc = 100000 * i + i * 2;
				if (conc > max) {
					max = conc;
					maxi = i;
				}
			}
		}
		
		System.out.println(max);
		System.out.print(maxi);
		System.out.println(maxi * 2);

	}

}

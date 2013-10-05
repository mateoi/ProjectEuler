package p_011_to_020;

public class P014 {

	
	public static int collatzLength(double n) {
		int length = 1;
		double num = n;
		while (num != 1) {
			num = num % 2 == 0 ? num / 2 : 3 * num + 1;
			length++;
		}
		return length;
	}
	
	public static void main(String[] args) {
		int max = 0;
		int num = 0;
		
		for (int i = 1; i < 1000001; i++) {
			System.out.println(i);
			int length = collatzLength(i);
			if (length > max) {
				num = i;
				max = length;
			}
		}
		
		System.out.println(num);
		System.out.println(max);
	}

}

package p_001_to_010;

public class P004 {

	public static boolean isPalindrome(int num) {
		String str = Integer.toString(num);
		int length = str.length();
		
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - 1 - i)) return false;
		}
		return true;

	}

	public static void main(String[] args) {
		int max = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				int prod = i * j;
				if (isPalindrome(prod)) {
					if (prod > max) {
						max = prod;
					}
				}
			}
		}
		
		System.out.println(max);
		
	}

}

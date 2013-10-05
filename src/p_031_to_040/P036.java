package p_031_to_040;

public class P036 {

	public static boolean isPalindrome(int n) {
		int newn = n;
		int reverse = 0;
		while (newn != 0) {
			reverse *= 10;
			reverse += newn % 10;
			newn /= 10;
		}
		
		return reverse == n;
	}

	public static boolean isPalindrome (String s) {
		char[] reverse = s.toCharArray();
		for (int i = 0; i < reverse.length / 2; i++) {
			char temp = reverse[i];
			reverse[i] = reverse[reverse.length - i - 1];
			reverse[reverse.length - i - 1] = temp;
		}
		return String.valueOf(reverse).compareTo(s) == 0;
	}
	
	public static boolean isDoubleBasePalindrome(int n) {
		return isPalindrome(n) && isPalindrome(Integer.toBinaryString(n));
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isDoubleBasePalindrome(i)) sum += i;
		}
		
		System.out.println(sum);
		
	}

}

package p_051_to_060;

public class P055 {

	public static boolean isPalindrome(double n) {		
		return reverse(n) == n;
	}

	public static double reverse(double n) {
		double newn = n;
		double reverse = 0;
		while (newn != 0) {
			reverse *= 10;
			reverse += newn % 10;
			newn /= 10;
			newn = Math.floor(newn);
		}
		return reverse;
	}
	
	public static boolean isLychrel(int n) {
		int count = 1;
		double newn = n + reverse(n);
		while (count < 50) {
			if (isPalindrome(newn)) return false;
			newn = newn + reverse(newn);
			count++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i < 10000; i++) {
			if (isLychrel(i)) {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}

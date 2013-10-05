package p_091_to_100;

public class P092 {

	public static int nextNum(int n) {
		int ans = 0;
		while(n != 0) {
			int d = n % 10;
			n /= 10;
			ans += d * d;
		}
		
		return ans;
	}
	
	public static boolean getsTo89(int n) {
		return n == 89 ? true : n == 1 ? false : getsTo89(nextNum(n));
	}
	
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i < 10000000; i++) {
			if (getsTo89(i)) ans++;
		}
		
		System.out.println(ans);
	}

}

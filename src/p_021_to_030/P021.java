package p_021_to_030;

public class P021 {

	public static int d(int n) {
		int ans = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				ans += i;
				ans += n / i;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i < 10000; i++) {
			int j = d(i);
			if (d(j) == i && j != i) {
				ans += i;
			}
		}
		
		System.out.println(ans);
	}

}

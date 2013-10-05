package p_051_to_060;

public class P053 {

	public static double factorial(int i) {
		return i <= 1 ? 1 : i * factorial(i - 1);
	}
	
	public static double nCr(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}
	
	public static void main(String[] args) {
		int ans = 0;
		for (int n = 23; n <= 100; n++) {
			for (int r = 2; r < n; r++) {
				if (nCr(n, r) > 1000000) ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}

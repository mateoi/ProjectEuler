package p_071_to_080;

public class P073 {

	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {

		int ans = 0;
		
		for (double bot = 2.0; bot <= 12000; bot++) {
			for (int top = (int) bot / 3; top < bot / 2; top++) {
				if (gcd(top, (int) bot) == 1) ans++;
			}
		}
		
		System.out.println(ans);
	}

}

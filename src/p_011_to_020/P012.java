package p_011_to_020;

public class P012 {

	
	public static int noDiv (int n) {
		int ans = 0;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) ans += 2;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int num = 0;
		int incr = 1;
		while (noDiv(num) <= 500) {
			num += incr;
			incr++;
		}
		
		System.out.println(num);
	}

}

package p_051_to_060;

import java.math.BigDecimal;

public class P056 {

	public static int digitSum(BigDecimal b) {
		String s = b.toString();
		char[] cs = s.toCharArray();
		int ans = 0;
		for (char c : cs) {
			ans += ((int) c) - 48;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int max = 0;
		
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				BigDecimal b = new BigDecimal(i).pow(j);
				int ds = digitSum(b);
				if (ds > max) {
					max = ds;
				}
			}
		}
		
		System.out.println(max);
	}

}

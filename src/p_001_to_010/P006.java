package p_001_to_010;

public class P006 {
	
	public static int sumToN(int n) {
		return n * (n + 1) / 2;
	}
	
	public static int sumSquaresToN(int n) {
		int ans = 0;
		for (int i = 0; i <= n; i++) {
			ans += i * i;
		}
		return ans;
	}
	
	public static void main (String[] args) {
		int sumfst = sumToN(100);
		int sumlst = sumSquaresToN(100);
		System.out.println(sumfst * sumfst - sumlst);
	}
}

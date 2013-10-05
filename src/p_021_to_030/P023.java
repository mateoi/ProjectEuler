package p_021_to_030;
import java.util.HashSet;

public class P023 {

	public static HashSet<Integer> abundantNums;
	public static HashSet<Integer> sums;
	
	public static int d(int n) {
		int ans = 1;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				ans += i;
				ans += n / i;
			}
		}
		
		if (sqrt * sqrt == n) {
			ans -= sqrt;
		}
		
		return ans;
	}
	
	public static boolean isAbundant (int n) {
		return d(n) > n;
	}
	
	public static boolean isSumOfAbundants(int n) {
		return sums.contains(n);
	}
	
	public static void createSums() {
		sums = new HashSet<Integer>();
		for (int i : abundantNums) {
			for (int j : abundantNums) {
				sums.add(i + j);
			}
		}
	}
	
	public static void main(String[] args) {
		abundantNums = new HashSet<Integer>();
		for (int i = 1; i < 28124; i++) {
			if (isAbundant(i)) {
				System.out.println(i);
				abundantNums.add(i);
			}
		}
		
		createSums();
		
		int ans = 0;
		for (int i = 1; i < 28124; i++) {
			if (!isSumOfAbundants(i)) ans += i;
		}
		
		System.out.println(ans);

	}

}

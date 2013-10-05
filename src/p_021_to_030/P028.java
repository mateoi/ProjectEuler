package p_021_to_030;

public class P028 {

	
	public static int cornerSum (int layer) {
		int n = layer * 2 - 1;
		return 4 * (n * n) - 6 * (n - 1);
	}
	
	public static void main(String[] args) {
		int ans = 1;
		for (int i = 2; i <= 501; i++) {
			ans += cornerSum(i);
		}
		
		System.out.println(ans);
	}

}

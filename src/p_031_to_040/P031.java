package p_031_to_040;

public class P031 {

	public static final int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
	
	public static int makeChange(int amount, int small) {
		if (amount == 0) return 1;
		if (amount < 0) return 0;
		int ans = 0;
		for (int i = small; i < 8; i++) {
			ans += makeChange(amount - coins[i], i);
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(makeChange(200, 0));
	}

}

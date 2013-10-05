package p_071_to_080;

public class P078 {


	public static int TOTAL = 60000;
	public static int[] GPN = new int[10000];

	public static void main(String[] args) {
		int[] nums = new int[TOTAL];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = TOTAL - i;
		}

		int[] ways = new int[TOTAL + 1];
		ways[0] = 1;

		for(int n: nums)
			for(int j = n; j <= TOTAL; j++) {
				ways[j] += ways[j - n];
				ways[j] %= 1000000;
			}

		for (int i = 0; i < ways.length; i++) {
			if (ways[i] == 0) System.out.println("success! :" + i);
		}


	}

	public static void getGPN() {
		for (int i = 0; i < GPN.length; i += 2) {
			GPN[i] = (3 * (i / 2) + 2) * ((i / 2) + 1) / 2;
		}

		for (int i = 1; i < GPN.length; i += 2) {
			int n = i / 2 + 1;
			n = -n;
			GPN[i] = n * (3 * n - 1) / 2;
		}
	}

	public static int p(int n) {
		if (n == 0) return 1;
		if (n < 0) return 0;
		int ans = 0;
		for (int i = 0; i < GPN.length; i++) {
			ans += p(n - GPN[i]) * Math.pow(-1, i / 2);
		}

		return ans;
	}


}

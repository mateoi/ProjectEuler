package p_011_to_020;

public class P020 {


	public static int[] mult(int[] arr, int num) {
		int[] ans = new int[arr.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] += arr[i] * num;
			if (ans[i] >+ 10) {
				ans [i + 1] += ans[i] / 10;
				ans[i] %= 10;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {

		int[] num = new int[200];
		num[0] = 1;
		int ans = 0;
		for (int i = 1; i < 100; i++) {
			num = mult(num, i);
		}
		
		for (int i : num) {
			ans += i;
		}
		
		System.out.println(ans);
		
	}

}

package p_011_to_020;

public class P016 {

	
	public static int sum(int[] arr) {
		int ans = 0;
		for (int i : arr) {
			ans += i;
		}
		return ans;
	}
	
	public static void dbl(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
			if (arr[i] >= 10) {
				arr[i] %= 10;
				arr[i - 1] += 1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[400];
		arr[399] = 1;
		for (int i = 0; i < 1000; i++) {
			dbl(arr);
		}
		System.out.println(sum(arr));
	}

}

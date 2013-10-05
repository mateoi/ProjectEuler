package p_031_to_040;

public class P034 {

	public static int fact(int n) {
		return n <= 0 ? 1 : n * fact (n - 1);
	}

	public static boolean canBeFactSum(int n) {
		int newn = n;
		int sum = 0;
		while (newn != 0) {
			sum += fact(newn % 10);
			newn /= 10;
		}
		
		return sum == n;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 100000; i++) {
			if (canBeFactSum(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

}

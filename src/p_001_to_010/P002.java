package p_001_to_010;

public class P002 {

	public static void main (String[] args) {
		int fib = 1;
		int prev = 0;
		int ans = 0;
		do {
			if (fib % 2 == 0) {
				ans += fib;
			}
			int temp = fib;
			fib += prev;
			prev = temp;
		} while (fib <= 4000000);
		System.out.println(ans);
	}

}

package p_021_to_030;

public class P030 {

	public static int sumFifthPow(int n) {
		if (n < 10) return (int) Math.pow(n, 5);
		return (int) Math.pow(n % 10, 5) + sumFifthPow(n / 10);
	}
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 1000000; i++) {
			if (i == sumFifthPow(i)) sum += i;
		}
		
		System.out.println(sum);
	}

}

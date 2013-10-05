package p_031_to_040;

public class P039 {

	
	public static int numOfSolutions(int p) {
		if (p < 12) return 0;
		int ans = 0;
		for (int a = 3; a < p - 2; a++) {
			for (int b = a + 1; b < p - 1; b++) {
				int c = (p - a) - b;
				if (pythTrip(a, b, c)) ans++;
			}
		}
		
		return ans;
	}
	
	public static boolean pythTrip(int a, int b, int c) {
		return a * a + b * b == c * c;
	}

	public static void main(String[] args) {
		int ans = 0;
		int max = 0;
		
		for (int i = 12; i <= 1000; i++) {
			int num = numOfSolutions(i);
			if (num > max) {
				max = num;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}

}

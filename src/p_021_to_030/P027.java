package p_021_to_030;
public class P027 {

	public static boolean isPrime(int n) {
		if (n % 2 == 0 || n < 2) return false;
		int sqrtn = (int) Math.sqrt(n);
		
		for (int i = 3; i <= sqrtn; i += 2) {
			if (n % i == 0) return false;
		}


		return true;
	}

	public static int quadChain(int a, int b) {
		int n = 0;
		while (isPrime((n * n) + (a * n) + b)) {
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		int prod = 0;
		int max = 0;
		for (int a = -999; a < 1000; a++) {
			int length2 = quadChain(a, 2);
			if (length2 > max) {
				max = length2;
				prod = a * 2;
			}
			for (int b = 3; b < 1000; b += 2) {
				int length = quadChain(a, b);
				if (length > max) {
					max = length;
					prod = a * b;
				}
			}
		}
		
		System.out.println(prod);
	}

}

package p_051_to_060;

public class P052 {

	
	public static boolean isPerm(int n1, int n2) {

		int[] b1 = {0,0,0,0,0,0,0,0,0,0};
		int[] b2 = {0,0,0,0,0,0,0,0,0,0};
		
		do {
			b1[n1 % 10]++;
			b2[n2 % 10]++;
			
			n1 /= 10;
			n2 /= 10;
		} while (n1 != 0 || n2 != 0);
		
		for (int i = 0; i < 10; i++) {
			if (b1[i] != b2[i]) return false;
		}
		
		return true;
	}
	
	public static boolean arePerm(int... is) {
		int first = is[0];
		for (int i : is) {
			if (!isPerm(first, i)) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 150000; i++) {
			if (arePerm(i, i * 2, i * 3, i * 4, i * 5, i * 6)) System.out.println(i);
		}
		
	}

}

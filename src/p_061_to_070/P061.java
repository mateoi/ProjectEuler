package p_061_to_070;


public class P061 {

	
	public static int poly(int p, int n) {
		switch(p) {
		case 3 : return n * (n + 1) / 2;
		case 4 : return n * n;
		case 5 : return n * (3 * n - 1) / 2;
		case 6 : return n * (2 * n - 1);
		case 7 : return n * (5 * n - 3) / 2;
		case 8 : return n * (3 * n - 2);
		default : return n;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

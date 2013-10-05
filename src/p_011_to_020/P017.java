package p_011_to_020;

public class P017 {

	public static int numLet(int i) {
		if (i == 1000) {
			return 11;
		}
		
		if (i >= 100) {
			return numLet(i / 100) + numLet(i % 100) + (i % 100 == 0 ? 7 : 10);
		}
		
		if (i >= 20) {
			switch (i / 10) {
			case 2: return 6 + numLet(i % 10);
			case 3: return 6 + numLet(i % 10);
			case 4: return 5 + numLet(i % 10);
			case 5: return 5 + numLet(i % 10);
			case 6: return 5 + numLet(i % 10);
			case 7: return 7 + numLet(i % 10);
			case 8: return 6 + numLet(i % 10);
			case 9: return 6 + numLet(i % 10);
			default: break;
			}
		}
		
		switch (i) {
		case 0: return 0;
		case 1: return 3;
		case 2: return 3;
		case 3: return 5;
		case 4: return 4;
		case 5: return 4;
		case 6: return 3;
		case 7: return 5;
		case 8: return 5;
		case 9: return 4;
		case 10: return 3;
		case 11: return 6;
		case 12: return 6;
		case 13: return 8;
		case 14: return 8;
		case 15: return 7;
		case 16: return 7;
		case 17: return 9;
		case 18: return 8;
		case 19: return 8;
		default: break;
		}
		return 0;
		
	}
	
	public static void main(String[] args) {

		int ans = 0;
		for (int i = 1; i <= 1000; i++) {
			ans += numLet(i);
		}
		
		System.out.println(ans);
	}

}

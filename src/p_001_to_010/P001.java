package p_001_to_010;

public class P001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int ans = 0;
		
		for (int i = 0; i < 1000; i++) {
			ans += (i % 3 == 0 || i % 5 == 0) ? i : 0;
		}
		
		System.out.println(ans);
		
	}

}

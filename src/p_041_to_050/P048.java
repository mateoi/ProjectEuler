package p_041_to_050;
import java.math.BigDecimal;

public class P048 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal ans = new BigDecimal(0);

		for (int i = 1; i <= 1000; i++) {
			BigDecimal newTerm = new BigDecimal(i).pow(i);
			ans = ans.add(newTerm);
		}
		
		String s = ans.toString();
		System.out.println(s.substring(s.length() - 10, s.length()));
		
	}

}

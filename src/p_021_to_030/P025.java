package p_021_to_030;
import java.math.BigDecimal;;


public class P025 {

	
	public static void main(String[] args) {
		BigDecimal current = new BigDecimal("1");
		BigDecimal last = new BigDecimal("0");
		
		int ans = 1;
		while (current.precision() < 1000) {
			BigDecimal next = current.add(last);
			last = current;
			current = next;
			ans++;
		}
		
		System.out.println(ans);
	}

}

package p_021_to_030;
import java.math.BigInteger;
import java.util.HashSet;


public class P029 {

	public static HashSet<BigInteger> nums;
	
	public static void main(String[] args) {
		nums = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++) {
			BigInteger bigA = new BigInteger(Integer.toString(a));
			for (int b = 2; b <= 100; b++) {
				BigInteger big = bigA.pow(b);
				nums.add(big);
			}
		}

		System.out.println(nums.size());
	}

}

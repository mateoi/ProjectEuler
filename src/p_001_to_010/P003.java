package p_001_to_010;
public class P003 {

	
	public static double smallestFactor (double i) {
		if (i % 2 == 0) return 2;
		double limit = Math.sqrt(i);
		for (double j = 3; j < limit; j += 2) {
			if (i % j == 0) return j;
		}
		return i;
	}
	
	public static void main(String[] args) {
		double sub = 600851475143.0;
		double i = smallestFactor(sub);
		while (i != sub) {
			sub /= i;
			i = smallestFactor(sub);
		}
		
		System.out.println(sub);
		
	}

}

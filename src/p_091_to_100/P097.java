package p_091_to_100;


public class P097 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double offset = 10000000000.0;
		double p = 2;
		for (int i = 1; i < 7830457; i++) {
			p *= 2;
			p %= offset;
		}
		
		p *= 28433;
		p %= offset;
		
		p++;
		
		System.out.println(p);

	}

}

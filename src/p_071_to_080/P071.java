package p_071_to_080;

public class P071 {

	
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		int closestTop = 0;
		double closestDiff = 51;
		
		double limit = 3.0 / 7;
		double start = 299999.0/700000;
		for (double bot = 700000; bot < 1000000; bot++) {
			
			for (int top = (int) (bot * start); top / bot < limit; top++) {
				double frac = top / bot;
				double diff = limit - frac;
				if (diff < closestDiff) {
					closestDiff = diff;
					closestTop = (int) top;
					closestTop /= gcd(top, (int) bot);
				}
			}
		}
		
		System.out.println(closestTop);
	}

}

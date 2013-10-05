package p_061_to_070;

import java.math.BigInteger;

public class P065 {

	public static int contFracE(int n) {
		return n % 3 == 0 ? 2 * n / 3 : n <= 1 ? 2 : 1;
	}
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		return b.compareTo(BigInteger.ZERO) == 0 ? a : gcd(b, a.mod(b));
	}
	
	public static BigInteger digitSum(BigInteger n) {
		BigInteger ans = BigInteger.ZERO;
		while (n.compareTo(BigInteger.ZERO) != 0) {
			ans = ans.add(n.mod(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		
		return ans;
	}
	
	public static class Fraction {
		public BigInteger top;
		public BigInteger bot;
		
		public Fraction(BigInteger top, BigInteger bot) {
			this.top = top;
			this.bot = bot;
			reduce();
		}
		
		private void reduce() {
			BigInteger g = gcd(top, bot);
			top = top.divide(g);
			bot = bot.divide(g);
		}
		
		public Fraction add(int num) {
			BigInteger newTop = top;
			newTop = newTop.add(bot.multiply(new BigInteger(Integer.toString(num))));
			return new Fraction(newTop, bot);
		}
		
		public Fraction flip() {
			return new Fraction(bot, top);
		}
		
		public String toString() {
			return top + "/" + bot;
		}
	}
	
	public static void main(String[] args) {
		Fraction e = new Fraction (BigInteger.ONE, BigInteger.ZERO);
		for (int i = 100; i > 0; i--) {
			e = e.flip();
			e = e.add(contFracE(i));
			System.out.println(i + ": " + e);
		}
		
		System.out.println(digitSum(e.top));
	}

}

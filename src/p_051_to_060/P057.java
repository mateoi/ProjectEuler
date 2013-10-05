package p_051_to_060;

import java.math.BigInteger;

public class P057 {

	public static Fraction[] approx = new Fraction[1000];
	
	public static class Fraction {
		BigInteger top;
		BigInteger bot;
		
		public Fraction add(Fraction that) {
			BigInteger newtop = (this.top.multiply(that.bot)).add(this.bot.multiply(that.top));
			BigInteger newbot = this.bot.multiply(that.bot);
			return new Fraction(newtop, newbot);
		}
		
		public Fraction add(BigInteger num) {
			BigInteger newtop = this.top.add(this.bot.multiply(num));
			return new Fraction(newtop, bot);
		}
		
		public Fraction flip() {
			return new Fraction(bot, top);
		}
		
		private BigInteger gcd(BigInteger a, BigInteger b) {
			return b.compareTo(BigInteger.ZERO) == 0 ? a : gcd(b, a.remainder(b));
		}
		
		public void reduce() {
			BigInteger g = gcd(top, bot);
			top = top.divide(g);
			bot = bot.divide(g);
		}
		
		@Override
		public String toString() {
			return top + "/" + bot;
		}
		
		public Fraction (BigInteger top, BigInteger bot) {
			this.top = top;
			this.bot = bot;
		}
		
	}
	
	public static void getApprox() {
		BigInteger TWO = new BigInteger("2");
		approx[0] = new Fraction(BigInteger.ONE, TWO);
		approx[1] = new Fraction(TWO, new BigInteger("5"));
		
		
		for (int i = 2; i < 1000; i++) {
			approx[i] = approx[i - 1].add(TWO).flip();
			approx[i - 2] = approx[i - 2].add(BigInteger.ONE);
			approx[i - 2].reduce();
		}
		
		approx[998].add(BigInteger.ONE);
		approx[999].add(BigInteger.ONE);
		
	}
	
	public static boolean topGTbot(Fraction f) {
		return f.top.toString().length() > f.bot.toString().length();
	}
	
	public static void main(String[] args) {
		getApprox();
		int ans = 0;
		for (Fraction f : approx) {
			if (topGTbot(f)) ans++;
		}
		
		System.out.println(ans);
	}

}

package p_101_to_110;

public class P101 {

	public static class Polynomial {
		private int[] coef;
		
		public Polynomial(int[] coef) {
			this.coef = coef;
		}
		
		public Polynomial(int degree) {
			coef = new int[degree + 1];
		}
		
		public void setCoef(int degree, int newCoef) {
			coef[degree] = newCoef;
		}
		
		public double valueAt(int n) {
			double ans = 0;
			for (int i = 0; i < coef.length; i++) {
				double val = Math.pow(n, i);
				val *= coef[i];
				ans += val;
			}
			
			return ans;
		}
		
		public String toString() {
			String sign = coef[1] >= 0 ? " + " + coef[1] : " - " + -coef[1];
			String ans = coef[0] + sign + "n";
			for (int i = 2; i < coef.length; i++) {
				sign = coef[i] >= 0 ? " + " + coef[i] : " - " + -coef[i];
				String part = sign + "n^" + i;
				ans = ans.concat(part);
			}
			
			return ans;
		}
		
		public boolean equals(Object other) {
			if (!(other instanceof Polynomial)) return false;
			int[] otherArr = ((Polynomial) other).toArray();
			if (otherArr.length != coef.length) return false;
			for (int i = 0; i < coef.length; i++) {
				if (otherArr[i] != coef[i]) return false;
			}
			
			return true;
		}
		
		public int[] toArray() {
			return coef;
		}
		
		public int getCoef(int degree) {
			return coef[degree];
		}
		
		public double[] valsUpTo(int n) {
			double[] ans = new double[n];
			for (int i = 0; i < ans.length; i++) {
				ans[i] = valueAt(i + 1);
			}
			
			return ans;
		}
		
		public double firstWrongTerm(double[] vals) {
			for (int i = 0; i < vals.length; i++) {
				if (valueAt(i + 1) != vals[i]) {
					return vals[i];
				}
			}
			
			return 0;
		}
		
		public static Polynomial guess(double[] vals) {
			int degree  = vals.length - 1;
			Polynomial ans = new Polynomial(degree);
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		int[] testPoly = {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1};
		Polynomial test = new Polynomial(testPoly);
		System.out.println(test);
		double[] vals = test.valsUpTo(11);
		System.out.println();
		for(double d : vals) {
			System.out.print(d + ", ");
		}
		System.out.println();
	}

}

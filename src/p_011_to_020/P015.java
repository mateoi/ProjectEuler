package p_011_to_020;

public class P015 {



	public static double[][] multMatrices(double[][] m1, double[][] m2) {
		if (m1.length == 0 || m2.length == 0 || m1[0].length != m2.length) return null;
		double[][] ans = new double[m1.length][m2[0].length];
		for (int i = 0; i < ans.length; i++) {
			for (int j = i + 1; j < ans[0].length; j++) {
				ans[i][j] = 0;
				for (int k = i; k < m2.length; k++) {
					ans[i][j] +=  m1[i][k] * m2[k][j];
				}
			}
		}
		
		return ans;
	}

	public static double[][] raiseToPow(double[][] m, int pow) {
		double[][] ans = m.clone();
		for (int i = 1; i < pow; i++) {
			System.out.println(i);
			ans = multMatrices(m, ans);
		}
		
		return ans;
	}
	
	public static double[][] populate(int size) {
		double[][] ans = new double[size * size][size * size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				int fromh = size * i + j;
				int toh = fromh + 1;
				ans[fromh][toh] = 1;
			}
		}
		
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size; j++) {
				int fromv = size * i + j;
				int tov = fromv + size;
				ans[fromv][tov] = 1;
			}
		}
		
		return ans;
	}
	
	public static void printMatrix(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		double[][] ans = populate(21);
		ans = raiseToPow(ans, 40);
		System.out.println(ans[0][ans.length - 1]);
	}

}

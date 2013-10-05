package p_041_to_050;

public class P045 {

	public static double[] hexas = new double[100000];
	public static double[] pents = new double[100000];
	public static double[] trias = new double[100000];
	
	public static boolean isIn(double n, double[] arr) {
		for (double i : arr) {
			if (i == n) return true;
			if (i > n) return false;
		}
		
		return false;
	}
	
	public static void getArrs() {
		for (double i = 0; i < hexas.length; i++) {
			hexas[(int) i] = (i + 144) * (2 * i + 287);
		
		
			pents[(int) i] = (i + 166) * (3 * i + 497) / 2;
		
		
			trias[(int) i] = (i + 286) * (i + 287) / 2;
		}
	}
	
	public static void main(String[] args) {
		
		getArrs();
		
		for (double h : hexas) {
			if (isIn(h, pents) && isIn(h, trias)) {
				System.out.println(h);
				return;
			}
		}
	}

}

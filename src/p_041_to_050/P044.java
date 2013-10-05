package p_041_to_050;

public class P044 {

	public static int[] pents = new int[3000];
	
	public static void getPents() {
		for (int i = 0; i < pents.length; i++) {
			pents[i] = (i + 1) * (3 * i + 2) / 2;
		}
	}
	
	public static boolean isPent(int n) {
		for (int p : pents) {
			if (p == n) return true;
			if (p > n) return false;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int minD = Integer.MAX_VALUE;
		getPents();
		
		for (int i = 0; i < pents.length; i++) {
			System.out.println(i);
			int p_i = pents[i];
			for (int j = i + 1; j < pents.length; j++) {
				int p_j = pents[j];
				if (
						isPent(p_i + p_j) && 
						isPent(p_j - p_i) && 
						p_j - p_i < minD) 
					minD = p_j - p_i;
			}
		}
		
		System.out.println(minD);
	}

}

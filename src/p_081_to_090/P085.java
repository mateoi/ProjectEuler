package p_081_to_090;

public class P085 {

	public static int fit(int gridW, int gridH, int rectW, int rectH) {
		int horiz = gridW - rectW + 1;
		int vert = gridH - rectH + 1;
		
		return horiz * vert;
	}
	
	public static int rectInGrid(int gridW, int gridH) {
		int ans = 0;
		for (int rectH = 1; rectH <= gridH; rectH++) {
			for (int rectW = 1; rectW <= gridW; rectW++) {
				ans += fit(gridW, gridH, rectW, rectH);
			}
		}
		
		return ans;

	}
	
	public static void main(String[] args) {

		int target = 2000000;
		int min_diff = 2000000;
		int ans = 0;
		
		for (int gridH = 1; gridH < 100; gridH++) {
			for (int gridW = gridH; gridW < 100; gridW++) {
				int rects = rectInGrid(gridW, gridH);
				int diff = Math.abs(rects - target);
				if (rects > 2001000) break;
				if (diff < min_diff) {
					ans = gridH * gridW;
					min_diff = diff;
				}
			}
		}
		
		System.out.println(ans);
	}

}

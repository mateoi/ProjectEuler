package p_081_to_090;

public class P082 implements Matrices {

	
	public static int findPath(int[][] dArr) {
		int[][] matrix = rotate(dArr);
		for (int i = matrix.length - 2; i > 0; i--) {
			int[] newLine = closest(matrix[i], matrix[i + 1]);
			matrix[i] = newLine;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] + matrix[1][i] < min) {
				min = matrix[0][i] + matrix[1][i];
			}
		}
		
		return min;
	}
	
	public static int[] closest(int[] fstCol, int[] sndCol) {
		int[] ans = new int[fstCol.length];
		
		for(int i = 0; i < ans.length; i++) {
			int minTop = Integer.MAX_VALUE;
			int top = fstCol[i];
			int right = fstCol[i] + sndCol[i];
			int minBot = Integer.MAX_VALUE;
			int bot = fstCol[i];
			
			for (int j = i - 1; j >= 0; j--) {
				top += fstCol[j];
				if(top + sndCol[j] < minTop) {
					minTop = top + sndCol[j];
				}
			}
			
			for (int j = i + 1; j < ans.length; j++) {
				bot += fstCol[j];
				if(bot + sndCol[j] < minBot) {
					minBot = bot + sndCol[j];
				}
			}
			
			ans[i] = Math.min(Math.min(minBot, minTop), right);
		}
		
		return ans;
	}
	
	public static int[][] rotate(int[][] matrix) {
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				newMatrix[j][i] = matrix[i][j];
			}
		}
		
		return newMatrix;
	}
	
	public static void main(String[] args) {

		System.out.println(findPath(bigMatrix));
	}

}

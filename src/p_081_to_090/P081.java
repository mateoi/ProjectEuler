package p_081_to_090;

public class P081 implements Matrices {

	public static int find_path(int[][] matrix) {
		for(int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix.length - 1; j >= 0; j--) {
				boolean rightEdge = j == matrix.length - 1;
				boolean bottomEdge = i == matrix.length - 1;
				int min = 
						rightEdge && bottomEdge ? 	0 :
						rightEdge ? 				matrix[i + 1][j] :
						bottomEdge ? 				matrix[i][j + 1] :
													Math.min(matrix[i + 1][j], matrix[i][j + 1]);
				matrix[i][j] += min;
			}
		}
		
		return matrix[0][0];

	}
	
	public static void main(String[] args) {
		int ans = find_path(bigMatrix);
		System.out.println(ans);
	}

}

package p_101_to_110;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P102 {


	public static boolean triangleContainsOrigin(double x1, double y1, double x2, double y2, double x3, double y3) {
		double theta1 = Math.atan2(y1, x1);
		double theta2 = Math.atan2(y2, x2);
		double theta3 = Math.atan2(y3, x3);
		
		double max = Math.max(theta1, Math.max(theta2, theta3));
		double min = Math.min(theta1, Math.min(theta2, theta3));
		double mid = theta1 + theta2 + theta3 - max - min;
		
		return max - min > Math.PI && max - mid < Math.PI && mid - min < Math.PI;
	}
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader fr = new FileReader("P102 - triangles.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int ans = 0;
		
		for (int i = 0; i < 1000; i++) {
			double x1 = Double.parseDouble(br.readLine());
			double y1 = Double.parseDouble(br.readLine());
			
			double x2 = Double.parseDouble(br.readLine());
			double y2 = Double.parseDouble(br.readLine());
			
			double x3 = Double.parseDouble(br.readLine());
			double y3 = Double.parseDouble(br.readLine());
			
			if(triangleContainsOrigin(x1, y1, x2, y2, x3, y3)) ans++;
		}
		
		System.out.println(ans);
		
		fr.close();
		br.close();
	}

}

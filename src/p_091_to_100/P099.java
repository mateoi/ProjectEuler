package p_091_to_100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P099 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String filename = "P099 - base_exp.txt";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		double max = 0;
		int max_i = 0;
		
		for (int i = 0; i < 1000; i++) {
			double base = Integer.parseInt(br.readLine());
			int exp = Integer.parseInt(br.readLine());
			double result = Math.log10(base) * exp;
			
			if (result > max) {
				max = result;
				max_i = i + 1;
			}
		}
		
		System.out.println(max_i);
		

		br.close();
		fr.close();
	}

}

package p_081_to_090;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P089 {

	public static int lettersNeeded(int n) {
		if (n <= 0) return 0;
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		for (int i = 0; i < values.length; i++) {
			if (n - values[i] >= 0) {
				int symLen = i % 2 == 0 ? 1 : 2;
				return symLen + lettersNeeded(n - values[i]);
			}
		}
		
		return 0;
	}
	
	public static int value(char[] vals, int index) {
		if (index >= vals.length) return 0;
		char fstSym = vals[index];
		if (fstSym == 'M') return 1000 + value(vals, index + 1);
		else if (fstSym == 'D') return 500 + value(vals, index + 1);
		else if (fstSym == 'L') return 50 + value(vals, index + 1);
		else if (fstSym == 'V') return 5 + value(vals, index + 1);
		else if (fstSym == 'C') {
			if (index < vals.length - 1 && vals[index + 1] == 'M') return 900 + value(vals, index + 2);
			if (index < vals.length - 1 && vals[index + 1] == 'D') return 400 + value(vals, index + 2);
			else return 100 + value(vals, index + 1);
		}
		else if (fstSym == 'X') {
			if (index < vals.length - 1 && vals[index + 1] == 'C') return 90 + value(vals, index + 2);
			if (index < vals.length - 1 && vals[index + 1] == 'L') return 40 + value(vals, index + 2);
			else return 10 + value(vals, index + 1);
		}
		else if (fstSym == 'I') {
			if (index < vals.length - 1 && vals[index + 1] == 'X') return 9 + value(vals, index + 2);
			if (index < vals.length - 1 && vals[index + 1] == 'V') return 4 + value(vals, index + 2);
			else return 1 + value(vals, index + 1);
		}
		else return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		String filename = "P089 - roman.txt";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		int ans = 0;
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			char[] vals = line.toCharArray();
			int value = value(vals, 0);
			int diff = vals.length - lettersNeeded(value);
			ans += diff;
		}
		
		System.out.println(ans);
		
		fr.close();
		br.close();
	}

}

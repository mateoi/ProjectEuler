package p_051_to_060;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class P059 {

	public static char[] cipher = new char[1201];
	public static char[] plaintext = new char[1201];
	
	public static void populateChars(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		for (int i = 0; i < 1201; i++) {
			String s = br.readLine();
			cipher[i] = (char)Integer.parseInt(s);
		}

		br.close();
		fr.close();
	}
	
	public static void decrypt(char[] key) {
		for (int i = 0; i < cipher.length; i += key.length) {
			for (int j = 0; j < key.length; j++) {
				if (i + j >= cipher.length) break;
				plaintext[i + j] = (char) (cipher[i + j] ^ key[j]);
			}
		}
	}
	
	public static double eDensity(char[] text) {
		double total = 0;
		for (char c : text) {
			if (c == 101) total++;
		}
		return total / text.length;
	}
	
	public static int printText(char[] text) {
		int total = 0;
		for (char c : text) {
			System.out.print(c);
			total += c;
		}
		
		System.out.println();
		return total;
	}
	
	public static void main(String[] args) {
		double threshold = 0.095;
		try {
			populateChars("P059 - cipher1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (char i = 97; i <= 122; i++) {
			for (char j = 97; j <= 122; j++) {
				for (char k = 97; k <= 122; k++) {
					char[] key = {i, j, k};
					decrypt(key);
					if (eDensity(plaintext) > threshold) {
						System.out.println(printText(plaintext));
						printText(key);
					}
				}
			}
		}
		
	}

}

package p_041_to_050;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class P042 {

	public static Vector<String> words = new Vector<String>();
	public static int[] triang = new int[30];
	

	public static void main(String[] args) {
		int ans = 0;
		getTriangs();
		
		try {
			populateWords("P042 - words.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String s : words) {
			if (isTriangular(wordToNum(s))) ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void getTriangs() {
		for (int i = 0; i < 30; i++) {
			triang[i] = (i + 1) * (i + 2) / 2;
		}
	}
	
	public static int wordToNum(String word) {
		char[] arr = word.toCharArray();
		int ans = 0;
		for (char c : arr) {
			ans += (Character.getNumericValue(c)) - 9;
		}
		
		return ans;
		
	}
	
	public static boolean isTriangular(int n) {
		for (int t : triang) {
			if (t == n) return true;
		}
		
		return false;
	}

	public static void populateWords(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		for (String s = br.readLine(); s != null; s = br.readLine()) {
			words.add(s);
		}

		br.close();
		fr.close();
	}
}

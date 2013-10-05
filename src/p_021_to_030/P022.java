package p_021_to_030;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class P022 {

	public static Vector<String> names;

	public static void main(String[] args) throws IOException {
		names = new Vector<String>();
		populateNames("P022 - names.txt");

		String[] nameArr = new String[names.size()];
		nameArr = names.toArray(nameArr);

		sort(nameArr);
		int ans = 0;
		for (int i = 0; i < nameArr.length; i++) {
			ans += (i + 1) * score(nameArr[i]);
		}

		System.out.println(ans);

	}

	public static int score (String s) {
		char[] arr = s.toCharArray();
		int ans = 0;
		for (char c : arr) {
			ans += ((int) c) - 64;
		}

		return ans;
	}

	public static void sort(String[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	public static void sort(String[] arr, int from, int to) {
		if (from >= to) return;
		int mid = (from + to) / 2;
		String pivot = arr[mid];
		swap(arr, mid, to);
		int storeIndex = from;
		for (int i = from; i < to; i++) {
			if (arr[i].compareTo(pivot) < 0) {
				swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		swap(arr, to, storeIndex);
		
		sort(arr, from, storeIndex - 1);
		sort(arr, storeIndex + 1, to);
	}

	public static void swap(Object[] arr, int o1, int o2) {
		Object temp = arr[o1];
		arr[o1] = arr[o2];
		arr[o2] = temp;
	}

	public static void populateNames(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		for (String s = br.readLine(); s != null; s = br.readLine()) {
			names.add(s);
		}

		br.close();
		fr.close();
	}

}

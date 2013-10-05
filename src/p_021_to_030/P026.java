package p_021_to_030;
import java.util.ArrayDeque;


public class P026 {

	public static int patLength (int i) {
		ArrayDeque<Integer> states = new ArrayDeque<Integer>();//
		int top = 1;
		int bot = i;
		while(top != 0 && !states.contains(top)) {
			states.add(top);
			top = (top * 10) % bot;
		}

		if (top == 0) {
			return 0;
		} else {
			int ans = 0;
			for (int j : states) {
				if (top == j) {
					break;
				}
				ans++;
			}
			return states.size() - ans;
			
			
		}
	}

	public static void main(String[] args) {
		int ans = 1;
		int max = 0;
		for (int i = 1; i < 1000; i++) {
			int len = patLength(i);
			if (len > max) {
				max = len;
				ans = i;
			}
		}
		
		System.out.println(ans);
	}

}

package p_031_to_040;

public class P033 {

	public static boolean cancelFrac(int num, int den) {
		int[] numDigits = {num / 10, num % 10};
		int[] denDigits = {den / 10, den % 10};

		if (numDigits[0] == denDigits[1]) {
			return (((double) (num)) / ((double) (den)) == ((double) (numDigits[1])) / ((double) (denDigits[0]))) && numDigits[1] != 0;

		} else if (numDigits[1] == denDigits[0]) {
			return (((double) (num)) / ((double) (den)) == ((double) (numDigits[0])) / ((double) (denDigits[1]))) && numDigits[1] != 0;

		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int totNum = 1;
		int totDen = 1;
		for (int i = 11; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {
				if (cancelFrac(i, j)) {
					System.out.println(i + "\n--\n" + j);
					System.out.println();
					totNum *= i;
					totDen *= j;
				}
			}
		}

		System.out.println(totNum);
		System.out.println(totDen);
		System.out.println((double) totDen / (double) totNum);
		
		
	}

}

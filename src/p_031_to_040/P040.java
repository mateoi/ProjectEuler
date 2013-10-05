package p_031_to_040;

public class P040 {

	/*
	 * 1: 1-9		(9)
	 * 2: 10-189 	(90*2 = 180)
	 * 3: 190-2889	(900*3 = 2700)
	 * 4: 2890-38889(9000*4 = 36,000)
	 */
	
	public static int digitSection(int location) { //returns the number of digits this section of the constant has
		int firstguess = (int) (Math.log10(location));
		if (location <= endOfSection(firstguess)) return firstguess; else return firstguess + 1;
		
	}
	
	public static int endOfSection(int digits) {
		int ans = 0;
		for (int i = 0; i < digits; i++) {
			ans += 9 * Math.pow(10, i) * (i + 1);
		}
		return ans;
	}
	
	public static int giveDigit(int location) {
		
		int section = digitSection(location);		
		int adjustedLocation = location - endOfSection(section - 1);		
		int numberInQuestion = (int) Math.pow(10, section - 1) + (adjustedLocation / section);		
		int digitLocation = (adjustedLocation - 1) % section;
		int digit = Integer.parseInt(Integer.toString(numberInQuestion).substring(digitLocation, digitLocation + 1));
		
		return digit;
	}
	
	public static void main(String[] args) {
		int loc = 10;
		int ans = 1;
		for (int i = 1; i < 7; i++) {
			ans *= giveDigit(loc);
			loc *= 10;
		}
		
		System.out.println(ans);
	}

}

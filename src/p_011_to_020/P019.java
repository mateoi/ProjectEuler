package p_011_to_020;

public class P019 {

	public static int calcSundays() {
		int ans = 0;
		int currentDay = 2;
		for (int year = 1901; year <= 2000; year++) {
			boolean leap = year % 4 == 0;
			for (int month = 1; month <= 12; month++) {
				
				if (currentDay % 7 == 0) {
					ans++;
				}
				
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					currentDay += 31;
				} else if (month == 2) {
					currentDay += (28 + (leap ? 1 : 0));
				} else {
					currentDay += 30;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(calcSundays());
	}

}

import java.util.Calendar;

public class day7 {
	static String get_days() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int days[][] = {{31,28,31,30,31,30,31,31,30,31,30,31},
						{31,29,31,30,31,30,31,31,30,31,30,31}};
		int yoon = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 1 : 0;
		return days[yoon][month] + " days for " + year + "-" + (month+1);
	}
	public static void main(String[] args) {
		System.out.println(get_days());
	}
}

package day200912;

import java.util.StringTokenizer;

public class Solution5 {
	static String solution(String play_time, String adv_time, String logs[]) {
		int last = get_starttime(play_time);
		System.out.println(play_time);
		System.out.println(last);
		int timeline[] = new int[last+1];
		
		for(int i=0;i<logs.length;i++) {
//			StringTokenizer st = new StringTokenizer(logs[i]);
			int startime = get_starttime(logs[i]);
			int endtime = get_endtime(logs[i]);
			
			for(int j=startime;j<=endtime&&j<=last;j++) {
				
				timeline[j]++;
			}
		}
		int max = 0;
		int now = 0;
		int ans = 0;
		
		int sumtime = get_starttime(adv_time);
		
		for(int i=0;i<=sumtime&&i<=last;i++) {
			now += timeline[i];
			max += timeline[i];
		}
		
		for(int i=1;i+sumtime<=last;i++) {
			now = now + timeline[i+sumtime] -timeline[i-1];
//			System.out.println(i+" "+now);
			if(now > max) {
				ans = i;
				max = now;
//				System.out.println(i+" "+max);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int hour = ans / 3600;
		ans = ans % 3600;
		if(hour == 100) {
			hour = 99;
			ans += 3600;
			
		}
		int minute = (ans ) / 60 ;
		ans = ans % 60;
		if(minute == 100) {
			minute = 99;
			ans += 60;
		}
		
		int sec = ans;
		
		
		if(hour < 10) sb.append('0').append(hour);
		else sb.append(hour);
		
		sb.append(":");
		if(minute < 10) sb.append('0').append(minute);
		else sb.append(minute);
		sb.append(":");
		if(sec < 10) sb.append('0').append(sec);
		else sb.append(sec);
		
		
		return sb.toString();
	}
	
	// 00 : 20 : 15 - 0 1  :  4  5   :  1   4
	// 01 2 34 5 67 8 9 10 11 12 13 14  15  16
	static int get_starttime(String time) {
		int returntime = 0;
//		System.out.println(time.charAt(0)+" "+time.charAt(1));
		returntime += ((( (time.charAt(0) - '0') * 10 ) + time.charAt(1) - '0') * 3600);
//		System.out.println(returntime);
		returntime += ((( (time.charAt(3) - '0') * 10 ) + time.charAt(4) - '0') * 60);
//		System.out.println(returntime);
		returntime += ((( (time.charAt(6) - '0') * 10 ) + time.charAt(7) - '0') * 1);
//		System.out.println(returntime);
		
		
		
		return returntime;
	}
	static int get_endtime(String time) {
		int returntime = 0;
		returntime += ((( (time.charAt(9) - '0') * 10 ) + time.charAt(10) - '0') * 3600);
		returntime += ((( (time.charAt(12) - '0') * 10 ) + time.charAt(13) - '0') * 60);
		returntime += ((( (time.charAt(15) - '0') * 10 ) + time.charAt(16) - '0') * 1);
		
		
		
		return returntime;
	}
	

	
	public static void main(String[] args) {
//		String play_time = "02:03:55";
//		String adv_time = "00:14:15";
//		String logs[] = {
//				"01:20:15-01:45:14", 
//				"00:40:31-01:00:00", 
//				"00:25:50-00:48:29", 
//				"01:30:59-01:53:29", 
//				"01:37:44-02:02:30"
//		};
//		
		
//		String play_time = "99:59:59";
//		String adv_time = "25:00:00";
//		String logs[] = {
//				"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
//		};
		
//		String play_time = "51:00:00";
//		String adv_time = "50:00:00";
//		String logs[] = {
//				"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-50:51:45"
//		};
		
		String play_time = "99:99:99";
		String adv_time = "00:00:03";
		String logs[] = {
				"00:00:00-00:00:03", "00:00:02-00:00:03","99:99:99-99:99:99","99:99:99-99:99:99","99:99:99-99:99:99","99:99:99-99:99:99","99:99:99-99:99:99"
		};
		
		
		System.out.println(solution(play_time, adv_time, logs));
	}
}

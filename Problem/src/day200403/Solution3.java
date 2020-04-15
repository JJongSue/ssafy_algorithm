package day200403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	static public String solution(String p, int n) {
		StringTokenizer st = new StringTokenizer(p);
		int sec = 0;
		String tmp = st.nextToken();
		// 60*60*12
		if(tmp.charAt(0) == 'P') sec = 60*60*12;
		//System.out.println(sec);
		StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
		int tmpi = Integer.parseInt(st2.nextToken());
		sec += ( (tmpi%12) * 60 * 60);
		tmpi = Integer.parseInt(st2.nextToken());
		sec += (tmpi*60);
		tmpi = Integer.parseInt(st2.nextToken());
		sec += tmpi;
		
		sec += n;
		
		int hour = sec/(60*60);
		hour = hour%24;
		sec = sec%(60*60);
		int min = sec/(60);
		sec = sec%60;
		
		
		
		String answer = "";
		if(hour >= 0 && hour <= 9) 
			answer += ('0'+Integer.toString(hour)+":");
		else
			answer += (Integer.toString(hour)+":");
		
		if(min >= 0 && min <= 9) 
			answer += ('0'+Integer.toString(min)+":");
		else
			answer += (Integer.toString(min)+":");
		
		if(sec >= 0 && sec <= 9) 
			answer += ('0'+Integer.toString(sec));
		else
			answer += (Integer.toString(sec));
		
		//		+Integer.toString(min)+":"+Integer.toString(sec);

		return answer;
	}

	public static void main(String[] args) throws IOException {
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			System.out.println(solution(p, n));
		}
	}
}

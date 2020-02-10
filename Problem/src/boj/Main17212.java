package boj;

import java.util.Scanner;

public class Main17212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 100_000;
		int N = sc.nextInt();
		for(int seven=N/7;seven>=0;seven--) {
			int tmpN = N - (seven*7);
			int tmpcnt = seven;
			for(int five=tmpN/5;five>=0;five--) {
				if(five+tmpcnt >= cnt) break;
				tmpN = tmpN - (five*5);
				tmpcnt += five;
				cnt = Math.min(cnt, tmpcnt+(tmpN/2)+(tmpN%2));
				tmpN = tmpN + (five*5);
				tmpcnt -= five;
			}
			
		}
		System.out.println(cnt);
		
	}
}

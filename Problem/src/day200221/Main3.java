package day200221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken())*100;
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken())*100;
		int F = Integer.parseInt(st.nextToken());
		
		F = U * F;
		U = U*100;
		if(H <= U) {
			System.out.println("Success 1");
		}else {
			//System.out.println(H+" "+U+" "+D+" "+F);
			int day = 1;
			int now = U-D;
			while(now > 0 && now <= H) {
				day++;
				U = U-F;
				if(U <= 0) {
					U = 0;
					F = 0;
				}
				now = now + U;
				if(now >= H) break;
				now -= D;
			}
			if(now <= 0) {
				System.out.println("Failure " + day);
			}else {
				System.out.println("Success " + day);
			}
			
			
		}
		
		
	}
}

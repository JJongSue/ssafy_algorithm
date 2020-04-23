package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main18406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0;i<tmp.length()/2;i++) {
			sum1 += (tmp.charAt(i) - '0');
		}
		for(int i=tmp.length()/2;i<tmp.length();i++) {
			sum2 += (tmp.charAt(i) - '0');
		}
		if(sum1 == sum2) System.out.println("LUCKY");
		else System.out.println("READY");
		
	}
}

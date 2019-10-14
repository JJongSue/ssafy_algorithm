package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st2.nextToken());
		int C = Integer.parseInt(st2.nextToken());
		long ans = 0;
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken())-B;
			ans++;
			if(tmp < 0) continue;
			ans+= tmp/C;
			if(tmp%C != 0) ans++;
		}
		System.out.println(ans);
	}
}

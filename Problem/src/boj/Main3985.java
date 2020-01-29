package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3985 {
	static int N, M;
	static int map[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int ans = 0, max = 0;
		int max1=0, ans1 = 0;
		map = new int[N+1];
		for(int i=1;i<=M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(e-s+1 > max1) {
				max1 = e-s+1;
				ans1 = i;
			}
			int cnt=0;
			for(int j=s;j<=e;j++) {
				if(map[j] == 0) {
					map[j] = i;
					cnt++;
				}
			}
			if(max < cnt) {
				max = cnt;
				ans = i;
			}
		}
		System.out.println(ans1);
		System.out.println(ans);
		
	}
}

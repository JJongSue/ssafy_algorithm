package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = N+1;
		int now = 0;
		int sum = 0;
		int s = 0;
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			now++;
			if(sum >= M) {
				if(ans == N+1) ans = now;
				else ans = Math.min(ans, now);
				while(s <= i && sum >= M) {
					ans = Math.min(ans, now);
					sum -= arr[s];
					now--;
					s++;
				}
			}
		}
		if(ans == N+1) ans = 0;
		System.out.println(ans);
	}
}

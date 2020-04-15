package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18513 {
	static int arr[];
	static int dis[];
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		arr = new int[N];
		dis = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<N-1;i++) {
			dis[i] = arr[i+1] - arr[i] - 1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(dis));
		int now = 1;
		while(K != 0) {
			if(arr[0] - now >= -100_000_000) {
				K--;
				ans += now;				
			}
			if(K == 0) break;
			if(arr[N-1] + now <= 100_000_000) {
				K--;
				ans += now;				
			}
			if(K == 0 ) break;
			
			for(int i=0;i<N-1;i++) {
				for(int j=0;j<2;j++) {
					if(dis[i] == 0 || K == 0) break;
					K--;
					ans += now;
					dis[i]--;
				}
				if(K == 0) break;
			}
			now++;
			
		}
		System.out.println(ans);
		
	}
}

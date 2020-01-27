package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9466 {
	static int N, arr[], we[];
	static boolean is_visit[];
	static boolean is_team[], is_notT[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			we = new int[N+1];
			is_team = new boolean[N+1];
			is_notT = new boolean[N+1];
			is_visit = new boolean[N+1];
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				we[arr[i]]++;
				if(arr[i] == i) is_team[i] = true;
			}
			
			for(int i=1;i<=N;i++) {
				if(we[i] == 0) {
					ans++;
					is_visit[i] = true;
					continue;
				}
				if(is_visit[i]) continue;
				int tmp = arr[i];
				int cnt = 1;
				is_visit[i] = true;
				while(tmp != i) {
					if(is_visit[tmp]) {
						break;
					}
					cnt++;
					is_visit[tmp] = true;
					tmp = arr[tmp];
				}
				if(i == tmp) {
					//System.out.println(i);
					continue;
				}else {
					int cnt2 = 0;
					int tmp2 = i;
					while(tmp2 != tmp) {
						cnt2++;
						tmp2 = arr[tmp2];
					}
					cnt = cnt-cnt2;
					ans += cnt2;
					//System.out.println(i+" "+ cnt2);
					
				}
			}
			
			
			System.out.println(ans);
			
		}
	}
}

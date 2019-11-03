package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dis[] = new int[N+2];
		for(int i=1;i<N+2;i++) dis[i] = Integer.parseInt(st.nextToken());
		//int last = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int time[] = new int[N+2];		
		for(int i=1;i<N+1;i++) time[i] = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N+2][3];
		for(int i=1;i<N+2;i++) {
			dp[i][0] = 987654321;
			dp[i][1] = 987654321;
		}
		for(int i=1;i<N+2;i++) {
			int sum = dis[i];
			for(int j=i-1;j>=0;j--) {
				//sum += dis[j];
				if(sum > T) break;
				if(dp[j][0] < dp[i][0] ) {
					dp[i][0] = dp[j][0];
					dp[i][1] = dp[j][1];
					dp[i][2] = j;
				}else if(dp[i][0] == dp[j][0]) {
					if(dp[i][1] > dp[j][1]) {
						dp[i][0] = dp[j][0];
						dp[i][1] = dp[j][1];
						dp[i][2] = j;
					}
				}
				sum += dis[j];
			}
			dp[i][0] += time[i];
			dp[i][1]++;
		}
		Stack<Integer> sta = new Stack<Integer>();
		sta.add(N+1);
		int tmp = N+1;
		while(tmp != 0) {
			tmp = dp[tmp][2];
			sta.add(tmp);
		}
		System.out.println(dp[N+1][0]);
		System.out.println(dp[N+1][1]-1);
		while(!sta.isEmpty()) {
			tmp = sta.pop();
			if(tmp == N+1 || tmp == 0) continue;
			System.out.print(tmp+" ");
		}
	}
}

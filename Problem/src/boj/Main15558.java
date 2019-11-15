package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15558 {
	static int road[][];
	static int timemap[][];
	static boolean is_visit[][];
	static int N, k;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		road = new int[N][2];
		is_visit = new boolean[N][2];
		timemap = new int[N][2];
		String tmp = br.readLine();
		for(int i=0;i<N;i++) {
			road[i][0] = tmp.charAt(i)-'0';
			
		}
		tmp = br.readLine();
		for(int i=0;i<N;i++) {
			road[i][1] = tmp.charAt(i)-'0';
			timemap[i][0] = 987654321;
			timemap[i][1] = 987654321;
		}
		game(0, 0, 0);
		System.out.println(ans);
	}
	
	static void game(int now, int where, int time) {
		if(now == N-1) {
			ans = 1;
			return;
		}
		if(ans == 1) return;
		
		if(where == 0) {
			if(now+k>= N) {
				ans = 1;
				return;
			}
			if(road[now+1][0] == 1 && !is_visit[now+1][0] && now+1>=time+1 && timemap[now+1][0] > time+1) {
				timemap[now+1][0] = time+1;
				//is_visit[now+1][0]=true;
				game(now+1, 0, time+1);
			}
			if(now+k < N && road[now+k][1] == 1 && !is_visit[now+k][1] && now+k>=time+1 && timemap[now+k][1] > time+1) {
				timemap[now+k][1] = time+1;
				//is_visit[now+k][1] = true;
				game(now+k, 1, time+1);
			}
			if(now-1 >= 0 && road[now-1][0] == 1 && !is_visit[now-1][0] && now-1>=time+1) {
				timemap[now-1][0] = time+1;
				//is_visit[now+k][0] = true;
				game(now-1, 0, time+1);
			}
			
		}else {
			if(now+k>= N) {
				ans = 1;
				return;
			}
			if(road[now+1][1] == 1 && !is_visit[now+1][0] && now+1>=time+1 && timemap[now+1][1] > time+1) {
				timemap[now+1][1] = time+1;
				//is_visit[now+1][0]=true;
				game(now+1, 1, time+1);
			}
			if(now+k < N && road[now+k][0] == 1 && !is_visit[now+k][1] && now+k>=time+1 && timemap[now+k][0] > time+1) {
				timemap[now+k][0] = time+1;
				//is_visit[now+k][1] = true;
				game(now+k, 0, time+1);
			}
			if(now-1 >= 0 && road[now-1][1] == 1 && !is_visit[now-1][1] && now-1>=time+1 && timemap[now-1][1] > time+1) {
				timemap[now-1][1] = time+1;
				//is_visit[now+k][1] = true;
				game(now-1, 1, time+1);
			}
		}
		
	}
	
}

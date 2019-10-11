package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main17129 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	
	static int N, M;
	static int map[][];
	static boolean is_visit[][];
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		is_visit = new boolean[N][M];
		
		pair start = new pair(-1, -1);
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] =  tmp.charAt(j)-'0';
				if(map[i][j] == 2) {
					start = new pair(j,i);
				}
			}
		}
		Queue<pair> q = new LinkedList<>();
		q.add(start);
		is_visit[start.y][start.x] = true;
		int ans = -1;
		int cnt = 1;
		
		
		asd:while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				for(int i=0;i<4;i++) {
					int xx = tmp.x+dx[i];
					int yy = tmp.y+dy[i];
					if(is_map(xx, yy) && !is_visit[yy][xx] && map[yy][xx] > 2) {
						ans = cnt;
						break asd;
					}
					if(is_map(xx, yy) && !is_visit[yy][xx] && map[yy][xx] != 1) {
						is_visit[yy][xx] = true;
						q.add(new pair(xx, yy));
					}
				}
			}
			
			cnt++;
		}
		if(ans == -1) System.out.println("NIE");
		else {
			System.out.println("TAK");
			System.out.println(ans);
			
		}
		
		
		//0빈복도 1장애물 2식구 3청국장 4스시 5맥앤치즈
		
		//1 <= n,m <=3000 4<= n*m <= 9*10^6
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x >= M || y >= N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

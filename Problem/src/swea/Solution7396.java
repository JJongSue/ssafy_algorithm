package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution7396 {
	static int N, M;
	static char[][] map;
	static boolean[][] is_visit;
	
	static class name implements Comparable<name>{
		int x;
		int y;
		char n;
		@Override
		public int compareTo(name o) {
			// TODO Auto-generated method stub
			return this.n-o.n;
		}
		public name(int x, int y, char n) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			is_visit = new boolean[N][M];
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			PriorityQueue<name> pq = new PriorityQueue<>();
			pq.add(new name(0,0, map[0][0]));
			while(!pq.isEmpty()) {
				name tmp = pq.poll();
				PriorityQueue<name> tmppq = new PriorityQueue<>();
				if(is_map(tmp.x+1, tmp.y) && !is_visit[tmp.y][tmp.x+1]) {
					tmppq.add(new name(tmp.x+1, tmp.y, map[tmp.y][tmp.x+1]));
					is_visit[tmp.y][tmp.x+1] = true;
				}
					
				if(is_map(tmp.x, tmp.y+1) && !is_visit[tmp.y+1][tmp.x]) {
					tmppq.add(new name(tmp.x, tmp.y+1, map[tmp.y+1][tmp.x]));
					is_visit[tmp.y+1][tmp.x] = true;
				}
					
				while(!pq.isEmpty()) {
					if(tmp.n == pq.peek().n) {
						tmp = pq.poll();
						if(is_map(tmp.x+1, tmp.y) && !is_visit[tmp.y][tmp.x+1]) {
							tmppq.add(new name(tmp.x+1, tmp.y, map[tmp.y][tmp.x+1]));
							is_visit[tmp.y][tmp.x+1] = true;
						}
							
						if(is_map(tmp.x, tmp.y+1) && !is_visit[tmp.y+1][tmp.x]) {
							tmppq.add(new name(tmp.x, tmp.y+1, map[tmp.y+1][tmp.x]));
							is_visit[tmp.y+1][tmp.x] = true;
						}
					}else break;
				}
				pq.clear();
				pq.addAll(tmppq);
				sb.append(tmp.n);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
	}
	static boolean is_map(int x, int y) {
		if(x <0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

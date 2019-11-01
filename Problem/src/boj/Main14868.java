package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14868 {
	static final int dx[] = {0,-1,1,0};	
	static final int dy[] = {-1,0,0,1};
	static int parents[];
	
	static int find_set(int x) {
		if( x== parents[x]) return x;
		return parents[x] = find_set(parents[x]);
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		parents[py] = px;
	}
	
	static int N, K;
	static int map[][];
	static boolean is_visit[][];
	static class pair{
		int x;
		int y;
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static ArrayList<pair> al;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		is_visit = new boolean[N][N];
		Queue<pair> q = new LinkedList<>();
		al = new ArrayList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int tmpx = Integer.parseInt(st.nextToken())-1;
			int tmpy = Integer.parseInt(st.nextToken())-1;
			al.add(new pair(tmpx, tmpy));
			q.add(new pair(tmpx, tmpy));
			is_visit[tmpy][tmpx] = true;
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				pair tmp = q.poll();
				
			}
			
		}
		
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y <0 || x>= N || y>=N) return false;
		return true;
	}
}

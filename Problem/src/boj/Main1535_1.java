package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main1535_1 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static char map[][] = new char[5][5];
	//static HashSet<Integer> hs = new HashSet<>();
	static int[] hs = new int[1<<26];
	static int ans = 987654321;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static ArrayList<pair> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<5;j++) {
				if(map[i][j] == '*') {
					al.add(new pair(j,i));
		
				}
			}
		}
		go(0,0, new pair[al.size()]);
		System.out.println(ans);
		
		
		
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=5 || y>=5) return false;
		return true;
	}
	static void go(int now, int cnt, pair[] parr) {		
		if(cnt == al.size()) {
			cnt(parr);
			return;
		}
		if(now >= 25) return;
		for(int i=now;i<25;i++) {
			parr[cnt] = new pair(i%5, i/5);
			go(i+1, cnt+1, parr);
		}
		
		
	}
	static void cnt(pair[] parr) {
		boolean is_visit[] = new boolean[al.size()];
		int dis = 0;
		Queue<pair> q = new LinkedList<>();
		q.add(parr[0]);
		is_visit[0]=true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for(int i=0;i<4;i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				for(int j=0;j<parr.length;j++) {
					if(!is_visit[j]) {
						if(xx == parr[j].x && yy == parr[j].y) {
							is_visit[j]=true;
							cnt++;
							q.add(parr[j]);
						}
					}
				}
			}
		}
		is_visit = new boolean[al.size()];
		if(cnt == parr.length) {
			countnum(0, 0, parr, new boolean[al.size()]);
			
		}
		
	}
	static void countnum(int i, int dis,pair[] parr, boolean is_visit[]) {
		if(i == al.size()) {
			ans = Math.min(ans, dis);
			return;
		}
		for(int j=0;j<al.size();j++) {
			if(is_visit[j]) continue;
			int x = al.get(j).x;
			int y = al.get(j).y;
			int tmp = Math.abs(parr[i].x-x)+Math.abs(parr[i].y-y);
			is_visit[j] = true;
			countnum(i+1, dis+tmp, parr, is_visit);
			is_visit[j] = false;
		}
		
		/*
		int iter = 0;
		int tmpdis = 987654321;
		ArrayList<Integer> tmpal = new ArrayList<>();
		for(int j=0;j<al.size();j++) {
			if(is_visit[j]) continue;
			int x = al.get(j).x;
			int y = al.get(j).y;
			int tmp = Math.abs(parr[i].x-x)+Math.abs(parr[i].y-y);
			if(tmp < tmpdis) {
				tmpal = new ArrayList<>();
				tmpal.add(j);
				//iter = j;
				tmpdis = tmp;
			}else if(tmp == tmpdis) {
				tmpal.add(j);
			}
		}
		for(int it=0;it<tmpal.size();it++) {
			is_visit[tmpal.get(it)] = true;
			countnum(i+1, dis+tmpdis, parr, is_visit);
			is_visit[tmpal.get(it)] = false;
		}*/
		
		
		/*ans = Math.min(ans, dis);
		for(int i=0;i<parr.length;i++) {
			//System.out.print(parr[i].x+" "+parr[i].y+" ");
			System.out.print((parr[i].x+parr[i].y*5)+" ");
		}System.out.println();*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 
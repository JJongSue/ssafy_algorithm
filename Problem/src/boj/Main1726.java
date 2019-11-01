package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1726 {
	//북 동 남 서 0 1 2 3
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
		
	static Queue<robot> q;
	static int rmap[][][];
	static int map[][];
	static int N, M;
	static class robot{
		int x;
		int y;
		int r;
		public robot(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		public robot() {
			super();
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rmap = new int[N][M][4];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		if(sr == 1) sr = 1;
		else if(sr == 2) sr = 3;
		else if(sr == 3) sr = 2;
		else if(sr == 4) sr = 0;
		
		
		st = new StringTokenizer(br.readLine());
		int dey = Integer.parseInt(st.nextToken())-1;
		int dex = Integer.parseInt(st.nextToken())-1;
		int der = Integer.parseInt(st.nextToken());
		if(der == 1) der = 1;
		else if(der == 2) der = 3;
		else if(der == 3) der = 2;
		else if(der == 4) der = 0;
		q = new LinkedList<robot>();
		q.add(new robot(sx-1, sy-1, sr));
		rmap[sy-1][sx-1][sr] = 1;
		int time = 2;
		
		while(!q.isEmpty()) {
			if(rmap[dey][dex][der] != 0) break;
			int size = q.size();
			for(int i=0;i<size;i++) {
				if(rmap[dey][dex][der] != 0) break;
				robot tmp = q.poll();
				int ll = lrotate(tmp.r);
				int rr = rrotate(tmp.r);
				if(rmap[tmp.y][tmp.x][ll] == 0) {
					rmap[tmp.y][tmp.x][ll] = time;
					q.add(new robot(tmp.x, tmp.y, ll));
				}
				if(rmap[tmp.y][tmp.x][rr] == 0) {
					rmap[tmp.y][tmp.x][rr] = time;
					q.add(new robot(tmp.x, tmp.y, rr));
				}
				for(int ii=1;ii<=3;ii++) {
					if(is_map(tmp.x+dx[tmp.r]*ii, tmp.y+dy[tmp.r]*ii) && map[tmp.y+dy[tmp.r]*ii][tmp.x+dx[tmp.r]*ii] == 1) break;
					if(is_map(tmp.x+dx[tmp.r]*ii, tmp.y+dy[tmp.r]*ii) && map[tmp.y+dy[tmp.r]*ii][tmp.x+dx[tmp.r]*ii] == 0 && rmap[tmp.y+dy[tmp.r]*ii][tmp.x+dx[tmp.r]*ii][tmp.r] == 0)
					{
						
						rmap[tmp.y+dy[tmp.r]*ii][tmp.x+dx[tmp.r]*ii][tmp.r] = time;
						q.add(new robot(tmp.x+dx[tmp.r]*ii, tmp.y+dy[tmp.r]*ii, tmp.r));
					}
				}
				
			}
			/*if(rmap[dey][dex][der] != 0) break;
			for(int s=0;s<4;s++) {
				System.out.println(s);
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						System.out.print(rmap[i][j][s]);
					}
					System.out.println();
				}
			}*/
			
			time++;
			
		}
		
		System.out.println(rmap[dey][dex][der]-1);
		
		
	}
	
	static int lrotate(int x) {
		int tx = x-1;
		if(tx<0) tx = 3;
		return tx;
	}
	static int rrotate(int x) {
		int tx = x+1;
		if(tx>=4) tx = 0;
		return tx;
	}
	static boolean is_map(int x, int y) {
		if(x>=M || y>=N || x<0 || y<0) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

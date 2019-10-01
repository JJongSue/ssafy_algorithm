package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main1082_fireFirst {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	
	static char[][] map;
	static int N, M;
	static boolean [][]is_visit;
	static class pair
	{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static Queue<pair> fire = new LinkedList<pair>();
	static Queue<pair> man = new LinkedList<pair>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		is_visit = new boolean[N][M];
		map = new char[N][M];
		int[][] fire_map = new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			String tmp = br.readLine(); 
			for(int j=0;j<M;j++)
			{
				map[i][j] =tmp.charAt(j);				
				if(map[i][j] == 'S') {
					man.add(new pair(j,i));
					map[i][j] = '.';
					is_visit[i][j] = true;
				}
				if(map[i][j] == '*') {
					fire.add(new pair(j,i));
					fire_map[i][j] = 1;
				}
				if(map[i][j] == 'X')
				{
					fire_map[i][j] = -1;
				}
				if(map[i][j] == 'D')
				{
					fire_map[i][j] = -9;
				}
			}
		}
		
		boolean is_end = false;
		int ans = 1;
		int ft = 1;
		while(!fire.isEmpty()) {
			int size = fire.size();
			for(int s=0;s<size;s++) {
				int x = fire.peek().x;
				int y = fire.peek().y;
				fire.poll();
				for(int i=0;i<4;i++)
				{
					int xx= x+dx[i];
					int yy = y+dy[i];
					if(xx == M || xx==-1 || yy==N || yy==-1) {
						continue;
					}
					if(fire_map[yy][xx] == 0)
					{
						fire.add(new pair(xx, yy));
						fire_map[yy][xx] = ft;
					}
				}
			}
			ft++;
		}
		
		ft = 1;
		go : while(!man.isEmpty())
		{
			int size = man.size();
			for(int s=0;s<size;s++) {
				int x = man.peek().x;
				int y = man.peek().y;
				man.poll();
				for(int i=0;i<4;i++)
				{
					int xx= x+dx[i];
					int yy = y+dy[i];
					if(xx == M || xx==-1 || yy==N || yy==-1) {
						continue;
					}
					if(fire_map[yy][xx] == -9) {
						ans = ft;
						is_end = true;
						break go;
					}
					if((fire_map[yy][xx] > 0 && fire_map[yy][xx] > ft && !is_visit[yy][xx]) || (fire_map[yy][xx]==0 && !is_visit[yy][xx])) {
						is_visit[yy][xx]= true;
						man.add(new pair(xx,yy));
					}				
				}
			}	
			//ans++;
			ft++;
		}
		if(is_end) System.out.println(ans);
		else System.out.println("impossible");
		
		
		
	}
}

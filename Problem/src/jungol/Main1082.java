package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1082 {
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
				if(map[i][j] == '*') fire.add(new pair(j,i));
			}
		}
		
		boolean is_end = false;
		int ans = 1;
		while(!man.isEmpty())
		{
			Queue<pair> tmpmq = new LinkedList<pair>();
			Queue<pair> tmpfq = new LinkedList<pair>();
			
			while(!fire.isEmpty())
			{
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
					if(map[yy][xx] == '.')
					{
						tmpfq.add(new pair(xx, yy));
						map[yy][xx] = '*';
					}
				}
			}
			
			while(!man.isEmpty())
			{
				int x = man.peek().x;
				int y = man.peek().y;
				man.poll();
				//System.out.println(y+" "+x);
				for(int i=0;i<4;i++)
				{
					int xx= x+dx[i];
					int yy = y+dy[i];
					if(xx == M || xx==-1 || yy==N || yy==-1) {
						continue;
					}
					if(map[yy][xx] == '.' && !is_visit[yy][xx])
					{
						tmpmq.add(new pair(xx, yy));
						is_visit[yy][xx] = true;
					}
					if(map[yy][xx] == 'D') {
						is_end=true;
						break;
					}
				}
			}
			if(is_end) break;
			
			
			ans++;
			fire.addAll(tmpfq);
			man.addAll(tmpmq);
		}
		if(is_end) System.out.println(ans);
		else System.out.println("impossible");
		
		
		
	}
	
}

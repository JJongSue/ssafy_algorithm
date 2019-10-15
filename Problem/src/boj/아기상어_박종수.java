package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16236 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	static int N;
	static int[][] map;
	static boolean [][]is_visit; 
	static int shark_size = 2;
	static int size_up = 2;
	static int shark_x, shark_y;
	static Queue<pair> q;
	static int ans = 0;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		is_visit = new boolean[N][N];
		q = new LinkedList<pair>();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9)
				{
					shark_x=j;
					shark_y=i;
					q.add(new pair(j,i));
					map[i][j]=0;
				}
			}
		}
		if(!is_eat()) {
			System.out.println(0);
		}
		else {
			int time = 1;
			while(!q.isEmpty())
			{
				if(time > N*N) break;
				if(!is_eat()) break;
				shark_y=-1;
				shark_x=-1;
				Queue<pair> tmpq = new LinkedList<pair>();
				is_visit = new boolean[N][N];
				while(!q.isEmpty())
				{
					
					int x = q.peek().x;
					int y = q.peek().y;
					is_visit[y][x] = true;
					//System.out.println(x + " "+ y);
					q.poll();
					
					for(int i=0;i<4;i++)
					{
						
						if(is_map(x+dx[i], y+dy[i]))
						{
							if(is_visit[y+dy[i]][x+dx[i]]) continue;
							//System.out.println((x+dx[i])+" "+(y+dy[i]));
							if(map[y+dy[i]][x+dx[i]]!=0 && 
									map[y+dy[i]][x+dx[i]] < shark_size)
							{
								is_visit[y+dy[i]][x+dx[i]]=true;
								if(shark_y == -1 && shark_x ==-1)
								{
									shark_y=y+dy[i];
									shark_x=x+dx[i];
								}
								else {
									if(shark_y > y+dy[i])
									{
										shark_y=y+dy[i];
										shark_x=x+dx[i];
									}
									else if(shark_y == y+dy[i])
									{
										if(shark_x > x+dx[i])
										{
											shark_y=y+dy[i];
											shark_x=x+dx[i];
										}
									}
								}

							}
							else if(map[y+dy[i]][x+dx[i]]==0 ||
									map[y+dy[i]][x+dx[i]] == shark_size)
							{
								is_visit[y+dy[i]][x+dx[i]]=true;
								tmpq.add(new pair(x+dx[i], y+dy[i]));
							}
						}
					}
				}
				if(shark_y != -1 && shark_x !=-1)
				{
					map[shark_y][shark_x]=0;
					if(--size_up == 0) {
						size_up = ++shark_size;
						//System.out.println(size_up);
						
					}
					ans += time;
					time=0;
					q = new LinkedList<pair>();
					tmpq = new LinkedList<pair>();
					tmpq.add(new pair(shark_x,shark_y));
				}
				
				
				
				time++;
				q.addAll(tmpq);
				
			}
			System.out.println(ans);
		}
		
		
		
		
		
		
	}
	static boolean is_map(int x, int y)
	{
		if(x < 0 || y < 0 || x>=N || y>= N) return false;
		return true;
	}
	static boolean is_eat()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				//if(map[i][j] != 0 && map[i][j] < shark_size ) return true;
				if(map[i][j] > 0 && map[i][j] < shark_size) return true;
			}
		}
		return false;
	}

	
	
}


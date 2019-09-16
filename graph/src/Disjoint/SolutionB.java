package Disjoint;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionB {
	static int [][]map;
	static int [][]dis_map;
	static boolean [][]is_visit;
	static int island_cnt;
	static ArrayList<island> arr;
	static class island
	{
		int s_x;
		int s_y;
		int e_x;
		int e_y;
		public island(int s_x, int s_y, int e_x, int e_y) {
			super();
			this.s_x = s_x;
			this.s_y = s_y;
			this.e_x = e_x;
			this.e_y = e_y;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			map = new int[N][N];
			is_visit = new boolean[N][N];
			arr = new ArrayList<>();
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					map[i][j] = sc.nextInt();
				}
			}
			dis_map = new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(map[i][j] == 1 && !is_visit[i][j])
					{
						int sum_x=-1, sum_y = -1;
						for(int k=i;k<N;k++)
						{
							if( map[k][j] == 0 ) {
								sum_y=k;
								break;
							}							
						}
						for(int k=j;k<N;k++)
						{
							if( map[i][k] == 0 ) {
								sum_x=k;
								break;
							}							
						}
						if(sum_x == -1) sum_x = N-1;
						if(sum_y == -1) sum_y = N-1;			
						for(int k=i;k<sum_x;k++)
						{
							for(int l=j;l<sum_y;l++)
							{
								is_visit[k][l] = true;
							}
						}
						island_cnt++;
						arr.add(new island(i, j, sum_x, sum_y));
					}
				}
			}
			
			
		}
	}
}

package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	static int [][]A;
	//static int []D;
	static ArrayList<Integer> U;
	static class dot implements Comparable<dot>{
		int x;
		int dis;
		public dot(int x, int dis) {
			super();
			this.x = x;
			this.dis = dis;
		}
		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}		
	}
	static PriorityQueue<dot> D;
	static int []dmap;
	
	static void dijk(int s, int distance) {
		U.add(s);
		boolean is_visit[] = new boolean[6];
		is_visit[0]=true;
		D = new PriorityQueue<>();
		for(int i=1;i<6;i++)
		{
			if(A[0][i] != Integer.MAX_VALUE)
			{
				D.add(new dot(i, A[0][i]));
				dmap[i]=A[0][i];
			}
			else dmap[i]=Integer.MAX_VALUE;
		}
		while(U.size() < 6)
		{
			dot tmp = D.poll();
			if(!is_visit[tmp.x])
			{
				dmap[tmp.x]=Math.min(tmp.dis, dmap[tmp.x] );
				is_visit[tmp.x]=true;
				U.add(tmp.x);
				for(int i=0;i<6;i++)
				{
					if(!is_visit[i] && A[tmp.x][i] != Integer.MAX_VALUE)
					{
						D.add(new dot(i,dmap[tmp.x]+A[tmp.x][i]));
					}
				}
				System.out.println(Arrays.toString(dmap));
			}
		}
	}
	public static void main(String[] args) {
		A = new int[6][6];
		U = new ArrayList<>();
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6;j++)
				A[i][j]=Integer.MAX_VALUE;
		}
		dmap = new int[6];
		A[0][1]=3;
		A[0][2]=5;
		A[1][2]=2;
		A[1][3]=6;
		A[2][1]=1;
		A[2][3]=4;
		A[2][4]=6;
		A[3][4]=2;
		A[3][5]=6;
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6;j++)
			{
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
		dijk(0, 0);
		System.out.println(Arrays.toString(dmap));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

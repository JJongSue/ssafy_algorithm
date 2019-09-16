package MST;

import java.util.ArrayList;
import java.util.Scanner;

//프림 알고리즘
//정점 중심의 접근으로 최소신장트리를 구하는 알고리즘
//0. 아무 정점이나 하나 확보
//1. 현재 확보된 정점에서 이동 가능한 정점중 가장 가까운 정점을찾아서 확보
//확보된 정점을 모두 순회하며, 아직 확보되지 않은 정점으로 거리가 가장 짧은 간선을 찾아 그 간선에 연결된 정점을 확보
//2. 모두 확보되면 끝...
public class Prim {
	static class line{
		int x;
		int y;
		int level;
		public line(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\n" +
                "0 1 31\r\n" + 
                "0 2 31\r\n" + 
                "0 6 31\r\n" + 
                "0 5 60\r\n" +
                "1 2 21\r\n" + 
                "2 4 46\r\n" + 
                "2 6 25\r\n" + 
                "3 4 34\r\n" + 
                "4 6 51\r\n" + 
                "5 3 18\r\n" + 
                "5 4 40\r\n" );
	 int cnt =0;
	 int N = sc.nextInt();
	 int M = sc.nextInt();
	 ArrayList<Integer> al = new ArrayList<>();
	 int [][] map = new int[N][N];
	 boolean []is_visit = new boolean[N];
	 for(int i=0;i<M;i++)
	 {
		 int x=sc.nextInt();
		 int y=sc.nextInt();
		 int l=sc.nextInt();
		 map[x][y]=l;
		 map[y][x]=l;
		 /*if(x>y) al.add(new line(y,x,sc.nextInt()));
		 else al.add(new line(x,y,sc.nextInt()));*/		 
	 }
	 for(int i=0;i<N;i++)
	 {
		 for(int j=0;j<N;j++)
		 {
			 System.out.print(map[i][j]+" ");
		 }System.out.println();
	 }
	 //arr = new int[N];
	 al.add(0);
	 is_visit[0]=true;
	 while(al.size()<7)
	 {
		 int dis = Integer.MAX_VALUE;
		 int x=0, y=0;
		 for(int i=0;i<al.size();i++)
		 {
			 for(int j=0;j<N;j++)
			 {
				 if(!is_visit[j] && map[al.get(i)][j] != 0 && dis > map[al.get(i)][j])
				 {
					 dis = map[al.get(i)][j];
					 x = al.get(i);
					 y = j;
				 }
			 }
		 }
		 cnt+=dis;
		 is_visit[y]=true;
		 al.add(y);
		 System.out.println(dis+" "+y);
	 }
	 System.out.println(cnt);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

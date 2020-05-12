package day200510;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {0,1,0,-1};
	static int dy[] = {-1,0,1,0};
	
	static public int[][] solution(int N, int[][] bus_stop) {
		boolean is_stop[][] = new boolean[N][N];
		int[][] answer = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) answer[i][j] = N*N; 
		}
		Queue<dot> q = new LinkedList<dot>();
		
		
		for(int i=0;i<bus_stop.length;i++) {
			q.add(new dot(bus_stop[i][1]-1, bus_stop[i][0]-1));
			answer[bus_stop[i][0]-1][bus_stop[i][1]-1] = 0;
		}
		
		while(!q.isEmpty()) {
			Queue<dot> tmpq = new LinkedList<dot>();
			tmpq.add(q.poll());
			int now = 1;
			while(!tmpq.isEmpty()) {
				System.out.println(now);
				int size = tmpq.size();
				for(int s=0;s<size;s++) {
					int x = tmpq.peek().x;
					int y = tmpq.poll().y;
					for(int i=0;i<4;i++) {
						int xx = x+dx[i];
						int yy = y+dy[i];
						if(xx >= 0 && yy >= 0 && xx < N && yy < N) {
							if( now < answer[yy][xx] ) {
								answer[yy][xx] = now;
								tmpq.add(new dot(xx,yy));
							}
						}
					}
				}
				
				now++;
				
			}
			
		}
		
		
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 3;
		int bus_stop[][] = {{1,2},{3,3}};
		int answer[][] = solution(N, bus_stop);
		for(int i=0;i<N;i++) System.out.println(Arrays.toString(answer[i]));
	}
}

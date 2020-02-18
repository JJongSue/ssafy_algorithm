package day200213;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {
	static boolean is_visit[][][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int dp[][][];
	static int N;
	static int ans = 0;
	static int max_time = 0;
	static int map[][], timem[][];
	static public int solution(int r, int[][] delivery) {
        int answer = delivery[0][0];
        is_visit = new boolean[17][r][r];
        dp =  new int[17][r][r];
        is_visit[0][0][0] = true;
        N =r;
        map = new int[r][r];
        timem = new int[r][r];
        for(int i=0;i<r;i++) {
        	for(int j=0;j<r;j++) {
        		map[i][j] = delivery[r*i+j][1];
        		timem[i][j] = delivery[r*i+j][0];
        		max_time = Math.max(max_time, timem[i][j]);
        	}
        }
        int input = map[0][0];
        map[0][0] = 0;
        
        //for(int i=0;i<r;i++) System.out.println(Arrays.toString(timem[i]));
        go(0,0,input, 1);
        
        
        return ans;
    }
	
	
	static void go(int x, int y, int sum, int time) {
		//System.out.println(x+" "+y+" "+sum+" "+time);
		ans = Math.max(sum, ans);
		if(time == max_time+1) return;
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<N && yy<N && 0<=xx && 0<=yy && !is_visit[time][yy][xx] ) {
				is_visit[time][yy][xx] = true;
				if(time<=timem[yy][xx]) {
					dp[time][yy][xx] = sum+map[yy][xx];
					int postsum = map[yy][xx];
					map[yy][xx] = 0;
					//System.out.println(xx+" "+yy+" "+(postsum+sum)+" "+(time+1));
					go(xx,yy,sum+postsum, time+1);
					map[yy][xx] = postsum;
				}
				else {
					dp[time][yy][xx] = sum;
					//int postsum = map[yy][xx];
					//map[yy][xx] = 0;
					//System.out.println(xx+" "+yy+" "+(sum)+" "+(time+1));
					go(xx,yy,sum, time+1);
					//map[yy][xx] = postsum;
				}
				
				
				
				is_visit[time][yy][xx] = false;
				
			}
		}
	}
	public static void main(String[] args) {
		int r = 4;
		long start = System.currentTimeMillis();
		//int delivery[][] = { {1,5},{8,3},{4,2},{2,3},{3,1},{3,2},{4,2},{5,2},{4,1}};
		int delivery[][] = { {16,1},{16,1},{16,1},{16,1},
				{16,1},{16,1},{16,1},{16,1},
				{16,1},{16,1},{16,1},{16,1},
				{16,1},{16,1},{16,1},{16,1}};
		int res = solution(r, delivery);
		System.out.println(res);
		System.out.println((System.currentTimeMillis()-start)/1000.0);
	}
}

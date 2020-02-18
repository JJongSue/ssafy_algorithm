package day200213;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3_1 {
	static boolean is_visit[][][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int dp[][];
	static int N;
	static int ans = 0;
	static int map[][], timem[][];
	static public int solution(int r, int[][] delivery) {
        int answer = delivery[0][0];
        is_visit = new boolean[r*r+1][r][r];
        is_visit[1][0][0] = true;
        dp = new int[r*r+1][(1<<(r*r+1))];
        map = new int[r][r];
        timem = new int[r][r];
        for(int i=0;i<r;i++) {
        	for(int j=0;j<r;j++) {
        		map[i][j] = delivery[r*i+j][1];
        		timem[i][j] = delivery[r*i+j][0];
        	}
        }
        dp[0][1] = map[0][0];
        int input = map[0][0];
        map[0][0] = 0;
        go(0,0,input, 1);
        
        
        return ans;
    }
	
	
	static void go(int x, int y, int sum, int time) {
		sum = Math.max(ans, sum);
		if(time == 17) return;
		for(int i=0;i<4;i++) {
			int xx = dx[i]+x;
			int yy = dy[i]+y;
			if(xx>=0 && yy>=0 && xx<N && yy<N ) {
				if(time <= timem[yy][xx] && dp[time][])
			}
		}
	}
	public static void main(String[] args) {
		int r = 3;
		int delivery[][] = { {1,5},{8,3},{4,2},{2,3},{3,1},{3,2},{4,2},{5,2},{4,1}};
		int res = solution(r, delivery);
		System.out.println(res);
	}
}

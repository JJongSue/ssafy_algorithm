package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main14499 {
	static final int dx[] = {0,1,-1,0,0};
	static final int dy[] = {0,0,0,-1,1};
	static int N, M, y, x, K;
	static int dice[] = new int[6];
	static int map[][];
	static int commands[];
	static boolean is_end = true;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		commands = new int[K];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			if(!is_map()) break;
			int tmp = Integer.parseInt(st.nextToken());
			setDice(tmp);
			//commands[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
		
		
		
		
	}
	static boolean is_map() {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
	
	static void setDice(int K) {
		x = x+dx[K];
		y = y+dy[K];
		if(!is_map()) {
			x = x-dx[K];
			y = y-dy[K];
			return;
		}
		
		if(K == 1) {
			//동
			int tmp = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = tmp;			
			
		}else if(K==2) {
			int tmp = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = tmp;	
			
		}else if(K==3) {
			int tmp = dice[5];
			dice[5]=dice[1];
			dice[1]=dice[0];
			dice[0]=dice[4];
			dice[4]=tmp;
			
		}else {
			int tmp = dice[5];
			dice[5]=dice[4];
			dice[4]=dice[0];
			dice[0]=dice[1];
			dice[1]=tmp;
		}		
		game();
	}
	static void game() {
		if(map[y][x] == 0) {
			map[y][x] = dice[5];
		}else {
			dice[5]=map[y][x];
			map[y][x]=0;
		}
		sb.append(dice[0]).append("\n");
	}
}

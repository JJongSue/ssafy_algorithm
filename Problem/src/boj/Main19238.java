package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19238 {
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	
	static ArrayList<pair> al1 = new ArrayList<pair>();
	static ArrayList<pair> al2 = new ArrayList<pair>();
	static boolean is_visit[][];
	static boolean map[][];
	static int N, M, gas;
	static pair taxi;
	static Queue<pair> q = new LinkedList<pair>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gas = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					map[i][j] = true;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		taxi = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			al1.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			al2.add(new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(M == 0) {
			int tx = taxi.x;
			int ty = taxi.y;
			int dis = 0;
			q.add(new pair(tx, ty));
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int s=0;s<size;s++) {
					int nowx = q.peek().x;
					int nowy = q.poll().y;
					for(int i=0;i<M;i++) {
						if(al1.get(i).x == nowx && al1.get(i).y == nowy) {
							gas = gas - s;
						}
					}
					
				}
			}
			
		}
		
	}
	
	static boolean is_ok(int x, int y) {
		return true;
	}
}

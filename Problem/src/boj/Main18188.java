package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18188 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static char map[][];
	static int N;
	static int M;
	static int time;
	//static int sx=0, sy=0;
	static Queue<pair> q = new LinkedList<pair>();
	static class pair{
		int x;
		int y;
		String str;
		public pair(int x, int y, String str) {
			super();
			this.x = x;
			this.y = y;
			this.str = str;
		}		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'D') {
					q.add(new pair(j, i, ""));
				}
			}
		}
		boolean is_end = false;
		String ans = "";
		time = Integer.parseInt(br.readLine());
		end: while(time!=0 && !q.isEmpty()) {
			st = new StringTokenizer(br.readLine());
			String firsttmp = st.nextToken();
			int first=-1, second=-1;
			if(firsttmp.equals("W")) {
				first = 0;
			}else if(firsttmp.equals("D")) {
				first = 1;
			}else if(firsttmp.equals("S")) {
				first = 2;
			}else {
				first = 3;
			}
			String secondtmp = st.nextToken();
			if(secondtmp.equals("W")) {
				second = 0;
			}else if(secondtmp.equals("D")) {
				second = 1;
			}else if(secondtmp.equals("S")) {
				second = 2;
			}else {
				second = 3;
			}
			int size = q.size();
			for(int s=0;s<size;s++) {
				int x = q.peek().x;
				int y = q.peek().y;
				String tmp = q.poll().str;
				
				int xx = x+dx[first];
				int yy = y+dy[first];
				if(is_map(xx, yy) && map[yy][xx]=='Z') {
					ans = (tmp+firsttmp);
					is_end = true;
					break end;
				}
				if(is_map(xx, yy) && map[yy][xx] == '.' || map[yy][xx] == 'D') {
					q.add(new pair(xx, yy, tmp+first));
				}
				
				xx = x+dx[second];
				yy = y+dy[second];
				if(is_map(xx, yy) && map[yy][xx]=='Z') {
					ans = (tmp+secondtmp);
					is_end = true;
					break end;
				}
				if(is_map(xx, yy) && map[yy][xx] == '.' || map[yy][xx] == 'D') {
					q.add(new pair(xx, yy, tmp+second));
				}
				
			}
			time--;
			
		}
		if(is_end) {
			System.out.println("YES");
			System.out.println(ans);
			
		}else System.out.println("NO");
		
		
		
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y<0 || x>=M || y>=N) return false;
		return true;
	}
}

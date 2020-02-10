package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main18428 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	
	static boolean is_yes = false;
	static int N;
	static char map[][];
	static ArrayList<teacher> al = new ArrayList<teacher>();
	static class teacher{
		int x;
		int y;
		public teacher(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					al.add(new teacher(j, i));
				}
			}
		}
		
		install(0, 0);
		if(is_yes) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	static void install(int now, int cnt) {
		if(is_yes) return;
		if(cnt == 3) {
			for(int i=0;i<al.size();i++) {
				int x = al.get(i).x;
				int y = al.get(i).y;
				for(int j=0;j<4;j++) {
					int xx = x+dx[j];
					int yy = y+dy[j];
					while(xx >= 0 && yy>= 0 && xx < N && yy < N) {
						if(map[yy][xx] == 'S') return;
						else if(map[yy][xx] != 'X') break;
						xx += dx[j];
						yy += dy[j];
					}
				}
			}
			is_yes = true;
			return;
		}
		if(now == N*N) return;
		int x = now % N;
		int y = now / N;
		if(map[y][x] == 'X') {
			map[y][x] = 'W';
			install(now+1, cnt+1);
			map[y][x] = 'X';
		}
		install(now+1, cnt);
	}
	
	
	
}

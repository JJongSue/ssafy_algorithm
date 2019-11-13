package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main1941 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static char [][] map = new char[5][5];
	static HashSet<Integer> hs = new HashSet<>();
	static boolean[][] is_visit = new boolean[5][5];
	static int ans = 0;
	//static pair[] parr = new pair[7];
	static int[] arr = new int[7];
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();			
		}
		
		for(int i=0;i<25;i++) {
			arr[0] = i;
			int tmpbit = (1<<i);
			hs.add(tmpbit);
			is_visit[i/5][i%5]= true;
			if(map[i/5][i%5] == 'S') select_num(1, 1, 0, i, tmpbit);
			else select_num(1, 0, 1, i, tmpbit);
			is_visit[i/5][i%5]= false;
		}
		System.out.println(ans);
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=5 || y>=5) return false;
		return true;
	}
	
	static void select_num(int now, int scnt, int ycnt, int where, int bit) {
		//System.out.println(now);
		if(ycnt >= 4) return;
		if(now == 7) {
			ans++;
			return;
		}
		for(int i=0;i<now;i++) {
			int x = arr[i]%5;
			int y = arr[i]/5;
			for(int j=0;j<4;j++) {
				int xx = x+dx[j];
				int yy = y+dy[j];		
				if(is_map(xx, yy) && !is_visit[yy][xx] ) {
					int tmpbit = bit | (1 << (xx+yy*5) );
					if(!hs.contains(tmpbit)) {
						arr[now] = xx+yy*5;
						hs.add(tmpbit);
						is_visit[yy][xx] = true;
						if(map[yy][xx] == 'S') select_num(now+1, scnt+1, ycnt, yy*5+xx, tmpbit);
						else select_num(now+1, scnt, ycnt+1, yy*5+xx, tmpbit);
						is_visit[yy][xx] = false;
					}					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

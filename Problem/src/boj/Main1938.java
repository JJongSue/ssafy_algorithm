package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1938 {
	static int N;
	static char map[][];
	static int timemap[][][];
	static tree b, e;
	static class tree{
		int x;
		int y;
		int r;
		public tree(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		timemap = new int[N][N][2];
		
		boolean tchk = true, echk=true;
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				timemap[i][j][0]=987654321;
				timemap[i][j][1]=987654321;
				if(map[i][j] == 'B' && tchk) {
					tchk = false;
					if(j+1<N && map[i][j+1] == 'B') {
						b = new tree(j+1, i, 0);
						timemap[i][j+1][0]=0;
					}else if(i+1<N && map[i+1][j] == 'B') {
						b = new tree(j, i+1, 1);
						timemap[i+1][j][1]=0;
					}
				}else if(map[i][j] == 'E' && echk) {
					echk = false;
					if(j+1<N && map[i][j+1] == 'E') {
						e = new tree(j+1, i, 0);
					}else if(i+1<N && map[i+1][j] == 'E') {
						e = new tree(j, i+1, 1);
					}
				}
				
				
			}
		}
		
		
		if(b.r == 0) {
			//System.out.println("ot");
			ot(b.x,b.y,0);
		}else {
			//System.out.println("tt");
			tt(b.x,b.y,0);
		}
		if(timemap[e.y][e.x][e.r] == 987654321) System.out.println(0);
		else System.out.println(timemap[e.y][e.x][e.r]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	static void ot(int x, int y, int time) {
		//System.out.println("ot : x"+x+" y"+y+" time:"+time);
		if(timemap[e.y][e.x][e.r] < time) {
			return;
		}
		//오른쪽이동
		if(x+2<N && timemap[y][x+1][0] > time+1 && map[y][x+2] != '1') {
			timemap[y][x+1][0]=time+1;
			ot(x+1,y,time+1);
		}
		//왼쪽이동
		if(x-2>=0 && timemap[y][x-1][0] > time+1 && map[y][x-2] != '1') {
			//System.out.println("뭐여 왜안돼");
			timemap[y][x-1][0]=time+1;
			ot(x-1,y,time+1);
		}
		//위로이동
		if(y-1>=0 && timemap[y-1][x][0] > time+1 && map[y-1][x] != '1' && map[y-1][x-1] != '1' && map[y-1][x+1] != '1') {
			timemap[y-1][x][0]=time+1;
			ot(x,y-1,time+1);
		}
		//아래이동
		if(y+1<N && timemap[y+1][x][0] > time+1 && map[y+1][x] != '1' && map[y+1][x-1] != '1' && map[y+1][x+1] != '1') {
			timemap[y+1][x][0]=time+1;
			ot(x,y+1,time+1);
		}
		
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				if(x+j<0 || x+j>=N || y+i<0 || y+i>=N) {
					return;
				}else {
					if(map[y+i][x+j] == '1') return;
				}
			}
		}
		if(timemap[y][x][1] > time+1) {
			timemap[y][x][1]=time+1;
			tt(x,y,time+1);
		}
		
		
		
		
		
		
		
	}
	static void tt(int x, int y, int time) {
		if(timemap[e.y][e.x][e.r] < time) {
			return;
		}
		//오른쪽이동
		if(x+1<N && timemap[y][x+1][1] > time+1 && map[y][x+1] != '1' && map[y-1][x+1] != '1' && map[y+1][x+1] != '1') {
			timemap[y][x+1][1]=time+1;
			tt(x+1,y,time+1);
		}
		//왼쪽이동
		if(x-1>=0 && timemap[y][x-1][1] > time+1 && map[y][x-1] != '1' && map[y-1][x-1] != '1' && map[y+1][x-1] != '1') {
			timemap[y][x-1][1]=time+1;
			tt(x-1,y,time+1);
		}
		//위로이동
		if(y-2>=0 && timemap[y-1][x][1] > time+1 && map[y-2][x] != '1') {
			timemap[y-1][x][1]=time+1;
			tt(x,y-1,time+1);
		}
		//아래이동
		if(y+2<N && timemap[y+1][x][1] > time+1 && map[y+2][x] != '1') {
			timemap[y+1][x][1]=time+1;
			tt(x,y+1,time+1);
		}
		
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				if(x+j<0 || x+j>=N || y+i<0 || y+i>=N) {
					return;
				}else {
					if(map[y+i][x+j] == '1') return;
				}
			}
		}
		if(timemap[y][x][0] > time+1) {
			timemap[y][x][0]=time+1;
			ot(x,y,time+1);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

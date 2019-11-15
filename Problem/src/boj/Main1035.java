package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main1035 {
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static char map[][] = new char[5][5];
	//static HashSet<Integer> hs = new HashSet<>();
	static int[] hs = new int[1<<26];
	static int ans = 987654321;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static ArrayList<pair> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bit = 0;
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<5;j++) {
				if(map[i][j] == '*') {
					al.add(new pair(j,i));
					bit = bit | (1<<(i*5+j));
				}
			}
		}
		//System.out.println(al.size());
		hs[bit] = 1;
		go(1, bit);
		System.out.println(ans-1);
		
		
		
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x<0 || y<0 || x>=5 || y>=5) return false;
		return true;
	}
	
	static void go(int now, int bit) {
		if(now > ans) return;
		if(hs[bit]!=0 && now > hs[bit]) return;
		//System.out.println(now);
		
		Queue<pair> q = new LinkedList<pair>();
		int cnt = 1;
		q.add(new pair(al.get(0).x, al.get(0).y));
		boolean is_visit[] = new boolean[al.size()];
		is_visit[0] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for(int i=0;i<4;i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				for(int j=0;j<al.size();j++) {
					if(is_visit[j]) continue;
					if(al.get(j).x == xx && al.get(j).y == yy) {
						is_visit[j]=true;
						cnt++;
						q.add(al.get(j));
						break;
					}
				}
			}
		}
		/*for(int i=0;i<al.size();i++) {
			System.out.print(al.get(i).x+" "+al.get(i).y+" ");
		}System.out.println();*/
		if(cnt == al.size()) {
			//System.out.println("된다");
			ans = Math.min(now, ans);
			return;
		}
		
		for(int i=0;i<al.size();i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			int tmpbit = 0;
			//야야야야야ㅑ야야야야 이거 bit미리 설정해놓은거
			for(int j=0;j<al.size();j++) {
				if(i==j) continue;
				int tmp = al.get(j).y*5+al.get(j).x;
				tmpbit = tmpbit | (1<<tmp);				
			}
			for(int j=0;j<4;j++) {
				int xx = x + dx[j];
				int yy = y + dy[j];
				boolean is_go = true;
				//여기는 visit로 있는지 확인하는 것
				if(is_map(xx, yy)) {
					for(int k=0;k<4;k++) {
						if(i==k) continue;
						if(xx == al.get(k).x && yy == al.get(k).y) {
							is_go =false;
							break;
						}
					}
					
					if(is_go) {
						int tmpbit1 = tmpbit | (1<<(yy*5+xx));
						if(hs[tmpbit1] == 0 || hs[tmpbit1]>now) {
							hs[tmpbit1] = now;
							al.get(i).x = xx;
							al.get(i).y = yy;
							go(now+1, tmpbit1);
							al.get(i).x = x;
							al.get(i).y = y;
							
							
						}
					}
				}
				
				
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 
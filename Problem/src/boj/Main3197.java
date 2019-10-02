package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3197 {
	static final int dx[] = {0,-1,1,0};
	static final int dy[] = {-1,0,0,1};
	static char map[][];
	static boolean is_visit[][];
	static int N, M;
	//얼음과 녹는 얼음, 퍼지는 L을 저장
	static Queue<pair> ice, melt, LQ, saveLQ;
	static pair searchL;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		is_visit = new boolean[N][M];
		ice = new LinkedList<pair>();
		melt = new LinkedList<pair>();
		LQ = new LinkedList<pair>();
		saveLQ = new LinkedList<pair>();
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				if(i>1 && map[i-2][j] == 'X') {
					for(int k=0;k<4;k++) {
						if(is_map(j+dx[k], i-2+dy[k]) && (map[i-2+dy[k]][j+dx[k]] =='.' || map[i-2+dy[k]][j+dx[k]] =='L'))
						{
							ice.add(new pair(j, i-2));
							break;
						}
					}
				}
				if(i >= N-2 && map[i][j] == 'X') {
					for(int k=0;k<4;k++) {
						if(is_map(j+dx[k], i+dy[k]) && (map[i+dy[k]][j+dx[k]] =='.' || map[i+dy[k]][j+dx[k]] =='L'))
						{
							ice.add(new pair(j, i));
							break;
						}
					}
				}
				//if(map[i][j]=='X') ice.add(new pair(j, i));
				if(map[i][j]=='L') LQ.add(new pair(j,i));
			}
		}
		searchL = LQ.poll();
		while(!LQ.isEmpty()) {
			int x = LQ.peek().x;
			int y = LQ.peek().y;
			LQ.poll();
			boolean is_add = false;
			for(int i=0;i<4;i++) {
				if(is_map(x+dx[i], y+dy[i]) ) {
					if(map[y+dy[i]][x+dx[i]] == '.') {
						map[y+dy[i]][x+dx[i]]='L';
						LQ.add(new pair(x+dx[i],y+dy[i]));
					}else if(map[y+dy[i]][x+dx[i]] == 'X' && !is_add) {
						is_add=true;
						saveLQ.add(new pair(x,y));
					}
				}
			}
		}
		LQ.addAll(saveLQ);
		saveLQ.clear();
		if(is_end(searchL)) {
			System.out.println(0);
		}else {
			long time = 1;
			while(!ice.isEmpty()) {
				int ice_size = ice.size();
				for(int i=0;i<ice_size;i++) {				
					int x = ice.peek().x;
					int y = ice.peek().y;
					map[y][x] = '.';
					ice.poll();
					for(int j=0;j<4;j++) {
						if(is_map(x+dx[j], y+dy[j]) && !is_visit[y+dy[j]][x+dx[j]] && map[y+dy[j]][x+dx[j]] == 'X') {
							ice.add(new pair(x+dx[j], y+dy[j]));
							//melt.add(new pair(x, y));
							//is_melt=true;
							//break;
						}
							
					}
					//if(!is_melt) ice.add(new pair(x,y));
				}
				/*while(!melt.isEmpty()) {
					int x = melt.peek().x;
					int y = melt.peek().y;
					melt.poll();
					map[y][x] = '.';
				}*/
				while(!LQ.isEmpty()) {
					int x = LQ.peek().x;
					int y = LQ.peek().y;
					LQ.poll();
					boolean is_add = false;
					for(int i=0;i<4;i++) {
						if(is_map(x+dx[i], y+dy[i]) ) {
							if(map[y+dy[i]][x+dx[i]] == '.') {
								map[y+dy[i]][x+dx[i]]='L';
								LQ.add(new pair(x+dx[i],y+dy[i]));
							}else if(map[y+dy[i]][x+dx[i]] == 'X' && !is_add) {
								is_add=true;
								saveLQ.add(new pair(x,y));
							}
						}
					}
				}
				LQ.addAll(saveLQ);
				saveLQ.clear();
				if(is_end(searchL)) {
					System.out.println(time);
					break;
				}
				time++;
			}
		}
		
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x >= M || y >= N) return false;
		return true;
	}
	static boolean is_end(pair L) {
		for(int i=0;i<4;i++) {
			if(is_map(L.x+dx[i], L.y+dy[i]) && map[L.y+dy[i]][L.x+dx[i]] == 'L') return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

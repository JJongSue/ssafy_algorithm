package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main3197_2 {
	static final int dx[] = { 0, -1, 1, 0 };
	static final int dy[] = { -1, 0, 0, 1 };
	static char map[][];
	static int Lmap[][];
	static boolean is_num[];
	static boolean is_visit[][],is_visit2[][];
	static int N, M;
	// 얼음과 녹는 얼음, 퍼지는 L을 저장
	static Queue<pair> ice, melt, LQ, saveLQ;
	static pair searchL;

	static class pair {
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
		Lmap = new int[N][M];
		pair first = new pair(0, 0), second = new pair(0, 0);
		boolean is_first = false;
		is_visit = new boolean[N][M];
		is_visit2= new boolean[N][M];
		is_num = new boolean[1501];
		ice = new LinkedList<pair>();
		LQ = new LinkedList<pair>();
		saveLQ = new LinkedList<pair>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(i>1 && map[i-2][j] == 'X') {
					for(int k=0;k<4;k++) {
						if(is_map(j+dx[k], i-2+dy[k]) && (map[i-2+dy[k]][j+dx[k]] =='.' || map[i-2+dy[k]][j+dx[k]] =='L'))
						{
							ice.add(new pair(j, i-2));
							break;
						}
					}
				}

				
				if (map[i][j] == 'L') {
					if (!is_first) {
						LQ.add(new pair(j, i));
						is_first = true;
						first = new pair(j, i);
					} else {
						LQ.add(new pair(j, i));
						second = new pair(j, i);
					}
				}
			}
		}
		for(int i=N-2;i<=N-1;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 'X') {
					for(int k=0;k<4;k++) {
						if(is_map(j+dx[k], i+dy[k]) && (map[i+dy[k]][j+dx[k]] =='.' || map[i+dy[k]][j+dx[k]] =='L'))
						{
							ice.add(new pair(j, i));
							break;
						}
					}
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) Lmap[i][j] = Integer.MAX_VALUE;
		}
		// searchL = LQ.poll();
		
		int time = 1;
		while (!LQ.isEmpty()) {
			if(time != 0) {
				int ice_size = ice.size();
				for(int i=0;i<ice_size;i++) {				
					int x = ice.peek().x;
					int y = ice.peek().y;
					map[y][x] = '.';
					ice.poll();
					boolean is_L = false;
					for(int j=0;j<4;j++) {
						if(is_map(x+dx[j], y+dy[j]) && !is_visit2[y+dy[j]][x+dx[j]] && !is_visit[y+dy[j]][x+dx[j]] && map[y+dy[j]][x+dx[j]] == 'X') {
							ice.add(new pair(x+dx[j], y+dy[j]));
							is_visit2[y+dy[j]][x+dx[j]] = true;
							//melt.add(new pair(x, y));
							//is_melt=true;
							//break;
						}else if(is_map(x+dx[j], y+dy[j]) && !is_visit[y+dy[j]][x+dx[j]] && map[y+dy[j]][x+dx[j]] == 'L' && !is_L) {
							LQ.add(new pair(x, y));
							is_L = true;
						}
							
					}
					//if(!is_melt) ice.add(new pair(x,y));
				}
			}
			
			
			
			int size = LQ.size();
			for (int s = 0; s < size; s++) {
				int x = LQ.peek().x;
				int y = LQ.peek().y;
				LQ.poll();
				//if(is_visit[y][x]) continue;
				Lmap[y][x] = time;
				for (int i = 0; i < 4; i++) {
					if (is_map(x + dx[i], y + dy[i])) {						
						if (map[y + dy[i]][x + dx[i]] == '.' && !is_visit[y + dy[i]][x + dx[i]]) {
							saveLQ.add(new pair(x + dx[i], y + dy[i]));
							Lmap[y+dy[i]][x+dx[i]] = time;
							is_visit[y + dy[i]][x + dx[i]] = true;
							//is_visit[y + dy[i]][x + dx[i]] = true;
						}
						if (map[y + dy[i]][x + dx[i]] == 'X' && !is_visit[y + dy[i]][x + dx[i]]) {
							LQ.add(new pair(x + dx[i], y + dy[i]));
							is_visit[y + dy[i]][x + dx[i]] = true;
							//is_visit[y + dy[i]][x + dx[i]] = true;
						}
					}
				}
			}
			while (!saveLQ.isEmpty()) {
				int x = saveLQ.peek().x;
				int y = saveLQ.peek().y;				
				saveLQ.poll();
				//if(is_visit[y][x]) continue;
				Lmap[y][x] = time;
				for (int i = 0; i < 4; i++) {
					if (is_map(x + dx[i], y + dy[i])) {
						if (map[y + dy[i]][x + dx[i]] == '.' && !is_visit[y + dy[i]][x + dx[i]]) {
							saveLQ.add(new pair(x + dx[i], y + dy[i]));
							is_visit[y + dy[i]][x + dx[i]] = true;
							Lmap[y+dy[i]][x+dx[i]] = time;
						} else if (map[y + dy[i]][x + dx[i]] == 'X' && !is_visit[y + dy[i]][x + dx[i]]) {
							LQ.add(new pair(x + dx[i], y + dy[i]));
							is_visit[y + dy[i]][x + dx[i]] = true;
						}
					}
				}
			}

			time++;
			//System.out.println(time+"야야야");
		}
		/*for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(Lmap[i][j]);
			}System.out.println();
		}*/
		
		Lmap[second.y][second.x]=0;
		int L = 1, R = time, ans = Integer.MAX_VALUE;
		ice.clear();
		while (L <= R) {
			int mid = (L + R) / 2;
			boolean is_ok = false;
			is_visit = new boolean[N][M];
			ice.add(first);
			// ice.add(first);
			is_visit[first.y][first.x] = true;
				loop:
				while (!ice.isEmpty()) {
				int x = ice.peek().x;
				int y = ice.peek().y;
				ice.poll();
				for (int i = 0; i < 4; i++) {
					if (is_map(x + dx[i], y + dy[i]) && !is_visit[y + dy[i]][x + dx[i]]) {
						is_visit[y + dy[i]][x + dx[i]] = true;
						// 접근 불가인 경우
						if (Lmap[y + dy[i]][x + dx[i]] > mid && map[y + dy[i]][x + dx[i]] == 'L') {
							break loop;
						}
						// 접근 가능일 경우
						if (Lmap[y + dy[i]][x + dx[i]] <= mid && map[y + dy[i]][x + dx[i]] == 'L') {
							is_ok = true;
							break loop;
						}
						if (Lmap[y + dy[i]][x + dx[i]] > mid)
							continue;
						
						ice.add(new pair(x + dx[i], y + dy[i]));
					}
				}
			}
			ice.clear();
			if (is_ok) {
				ans = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		System.out.println(ans);

	}

	static boolean is_map(int x, int y) {
		if (x < 0 || y < 0 || x >= M || y >= N)
			return false;
		return true;
	}

	static boolean is_end(pair L) {
		for (int i = 0; i < 4; i++) {
			if (is_map(L.x + dx[i], L.y + dy[i]) && map[L.y + dy[i]][L.x + dx[i]] == 'L')
				return true;
		}
		return false;
	}
	/*
	 * static int binarySearch(int L, int R, int num) { if(L>R) return L; int mid =
	 * (L+R)/2; if(L) }
	 */

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {
	static final int[] dx = { 0, -1, 1, 0 };
	static final int[] dy = { -1, 0, 0, 1 };
	static int N, L, R;
	static int map[][], num[][];
	static boolean is_visit[][];
	static int set[][];

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
		//System.out.println((int)142/7);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		num = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<pair> q = new LinkedList<pair>();
		int ans = 0;
		while (true) {
			q = new LinkedList<pair>();
			set = new int[2001][2];
			int cnt = 1;
			num = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (num[i][j] == 0) {
						end: for (int k = 0; k < 4; k++) {
							if (is_map(j + dx[k], i + dy[k])) {
								int min = Math.abs(map[i][j] - map[i + dy[k]][j + dx[k]]);
								if (min >= L && min <= R) {
									bfs(j, i, cnt);
									cnt++;
									break end;
								}
							}
						}
					}

				}

			}
			if(cnt == 1) break;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(num[i][j] != 0) {
						map[i][j] = (int)(set[num[i][j]][0]/set[num[i][j]][1]);
					}
				}
			}
			ans++;
			//System.out.println(set[1][0] + " " + set[1][1]);
			//for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(ans);

	}

	static void bfs(int x, int y, int cnt) {
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(x, y));
		num[y][x] = cnt;
		set[cnt][0] += map[y][x];
		set[cnt][1]++;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				pair tmp = q.poll();
				for (int k = 0; k < 4; k++) {
					int xx = dx[k] + tmp.x;
					int yy = dy[k] + tmp.y;
					if (is_map(xx, yy) && num[yy][xx] == 0) {
						int min = Math.abs(map[tmp.y][tmp.x] - map[yy][xx]);
						if (min >= L && min <= R) {
							num[yy][xx] = cnt;
							set[cnt][0] += map[yy][xx];
							set[cnt][1]++;
							q.add(new pair(xx,yy));							
						}
					}
				}
			}
		}

	}

	static boolean is_map(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;
		return true;
	}

}

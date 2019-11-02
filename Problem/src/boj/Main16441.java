package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;

import java.util.Queue;

import java.util.StringTokenizer;

public class Main16441 {

	static final int dx[] = { 0, -1, 1, 0 };

	static final int dy[] = { -1, 0, 0, 1 };

	static class pair {

		int x;

		int y;

		public pair(int x, int y) {

			super();

			this.x = x;

			this.y = y;

		}

		public pair() {

			super();

			// TODO Auto-generated constructor stub

		}

	}

	static int N, M;

	static boolean is_visit[][][];

	static char map[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		Queue<pair> wolf = new LinkedList<pair>();

		is_visit = new boolean[N][M][5];

		map = new char[N][M];

		for (int i = 0; i < N; i++) {

			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {

				if (map[i][j] == 'W') {

					wolf.add(new pair(j, i));

					is_visit[i][j][0] = true;

				}

			}

		}

		while (!wolf.isEmpty()) {

			pair tmp = wolf.poll();

			for (int s = 0; s < 4; s++) {

				int xx = tmp.x + dx[s];

				int yy = tmp.y + dy[s];

				if (is_map(xx, yy) && !is_visit[yy][xx][0]) {

					// is_visit[yy][xx] = true;

					if (map[yy][xx] == '+' && !is_visit[yy][xx][s + 1]) {

						is_visit[yy][xx][s + 1] = true;

						int xxx = xx;

						int yyy = yy;

						while (map[yyy][xxx] != '+') {

							is_visit[yyy][xxx][s + 1] = true;

							xxx += dx[s];

							yyy += dy[s];

						}

						if (map[yyy][xxx] == '#') {

							xxx -= dx[s];

							yyy -= dy[s];

							wolf.add(new pair(xxx, yyy));

							// is_visit[yyy][xxx][0] = true;

						} else {

							if (is_visit[yyy][xxx][0])
								continue;

							wolf.add(new pair(xxx, yyy));

							is_visit[yyy][xxx][0] = true;

						}

					} else if (map[yy][xx] == '.' && !is_visit[yy][xx][0]) {

						is_visit[yy][xx][0] = true;

						map[yy][xx] = 'W';

						wolf.add(new pair(xx, yy));

					}

				}

			}

		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++)

				if (map[i][j] == '.' && !is_visit[i][j][0])
					map[i][j] = 'P';

			for (int j = 0; j < M; j++)

				System.out.print(map[i][j]);

			System.out.println();

		}

	}

	static boolean is_map(int x, int y) {

		if (x < 0 || y < 0 || x >= M || y >= N)
			return false;

		return true;

	}

}
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main17396 {
	static class dot implements Comparable<dot> {
		int x;
		long distance;

		public dot(int x, long distance) {
			super();
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(dot o) {
			// TODO Auto-generated method stub
			return Long.compare(this.distance, o.distance);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] go = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) == 1)
				go[i] = true;
		}
		go[N - 1] = false;
		ArrayList<dot>[] al = new ArrayList[N];
		for (int i = 0; i < N; i++)
			al[i] = new ArrayList<>();
		boolean is_minus = true;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			if(go[s] || go[e]) continue;
			al[s].add(new dot(e, d));
			al[e].add(new dot(s, d));
			if (e == N - 1 || s==N-1)
				is_minus = false;
		}
		if (N == 1)
			System.out.println(1);
		else {
			if (is_minus)
				System.out.println(-1);
			else {

				long[] dis_map = new long[N];
				for (int i = 0; i < N; i++) {
					dis_map[i] = Long.MAX_VALUE;
				}
				dis_map[0] = 0;
				PriorityQueue<dot> pq = new PriorityQueue<>();
				for (int i = 0; i < al[0].size(); i++) {
					if (go[al[0].get(i).x])
						continue;
					pq.add(al[0].get(i));
					dis_map[al[0].get(i).x] = al[0].get(i).distance;
				}
				boolean[] is_visit = new boolean[N];
				is_visit[0] = true;
				if (dis_map[N - 1] == Long.MAX_VALUE) {
					while (!pq.isEmpty()) {
						dot tmp = pq.poll();
						if (!is_visit[tmp.x] && !go[tmp.x]) {
							is_visit[tmp.x] = true;
							for (int i = 0; i < al[tmp.x].size(); i++) {
								if (!go[al[tmp.x].get(i).x]
										&& dis_map[al[tmp.x].get(i).x] > dis_map[tmp.x] + al[tmp.x].get(i).distance) {
									dis_map[al[tmp.x].get(i).x] = dis_map[tmp.x] + al[tmp.x].get(i).distance;
									pq.add(new dot(al[tmp.x].get(i).x, dis_map[al[tmp.x].get(i).x]));
								}
							}

						}
						if (is_visit[N - 1])
							break;
						/*
						 * if (dis_map[N - 1] != Integer.MAX_VALUE) break;
						 */
					}

				}
				if (dis_map[N - 1] == Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(dis_map[N - 1]);

			}
		}
	}

}

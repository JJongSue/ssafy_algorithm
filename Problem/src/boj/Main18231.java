package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18231 {
	static ArrayList<Integer> fire, dis_map[];
	static PriorityQueue<pair> pq = new PriorityQueue<>();
	static boolean is_visit[], is_fire[];
	static int N, M;

	static class pair implements Comparable<pair> {
		int x;
		int cnt;

		public pair(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return o.cnt - this.cnt;
		}

	}

	static PriorityQueue<Integer> ans = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fire = new ArrayList<>();
		dis_map = new ArrayList[N + 1];
		is_visit = new boolean[N + 1];
		is_fire = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			dis_map[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dis_map[x].add(y);
			dis_map[y].add(x);
		}
		int fcnt = Integer.parseInt(br.readLine());
		if(fcnt != 0) st = new StringTokenizer(br.readLine());
		for (int i = 0; i < fcnt; i++) {
			int x = Integer.parseInt(st.nextToken());
			is_fire[x] = true;
			fire.add(x);
		}
		int tmpcnt = 0;

		for (int i = 1; i <= N; i++) {
			if (!is_fire[i])
				continue;
			// if(tmpcnt == fcnt) break;
			boolean is_ok = true;
			int firecnt = 0;
			for (int j = 0; j < dis_map[i].size(); j++) {
				if (!is_fire[dis_map[i].get(j)]) {
					is_ok = false;
					break;
				}
				firecnt++;
			}
			if (!is_ok)
				continue;
			pq.add(new pair(i, firecnt));
			// ans.add(i);
			/*
			 * if(!is_visit[i]) { is_visit[i] = true; tmpcnt++; } for(int
			 * j=0;j<dis_map[i].size();j++) { if(!is_visit[dis_map[i].get(j)]) {
			 * is_visit[dis_map[i].get(j)] = true; tmpcnt++; } }
			 */

		}
		while (!pq.isEmpty()) {
			if (tmpcnt == fcnt)
				break;
			int i = pq.poll().x;
			ans.add(i);
			if (!is_visit[i]) {
				is_visit[i] = true;
				tmpcnt++;
			}
			for (int j = 0; j < dis_map[i].size(); j++) {
				if (!is_visit[dis_map[i].get(j)]) {
					is_visit[dis_map[i].get(j)] = true;
					tmpcnt++;
				}
			}

		}
		if (fcnt == tmpcnt) {
			System.out.println(ans.size());
			while (!ans.isEmpty()) {
				System.out.print(ans.poll() + " ");
			}
		} else {
			System.out.println(-1);
		}
	}
}

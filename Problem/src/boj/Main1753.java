package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main1753 {
	static final int inf = Integer.MAX_VALUE;
	static class pair implements Comparable<pair> {
		int x;
		int price;

		public pair(int x, int price) {
			super();
			this.x = x;
			this.price = price;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.price - o.price;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		ArrayList<pair>[] dislist = new ArrayList[V+1];
		//LinkedList<pair>[] dislist = new LinkedList[V + 1];
		int cnt = 0;
		for (int i = 1; i < V + 1; i++) {
			dislist[i] = new ArrayList<>();//new LinkedList<pair>();
		}
		// int dismap[][] = new int[V+1][V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			dislist[s].add(new pair(e, p));			//boolean is_add = true;

			/*
			 * for(int j=0;j<dislist[s].size();j++) { if(dislist[s].get(j).x == e) { is_add
			 * = false; if(dislist[s].get(j).price > p) dislist[s].get(j).price=p; break; }
			 * }
			 */
			/*if (is_add) {
				dislist[s].add(new pair(e, p));
				// cnt++;
			}*/
			// dismap[s][e]=p;
		}

		int dis[] = new int[V + 1];

		boolean is_visit[] = new boolean[V + 1];
		is_visit[S] = true;
		for (int i = 1; i < V + 1; i++)
			dis[i] = inf;
		PriorityQueue<pair> pq = new PriorityQueue<>();

		for (int i = 0; i < dislist[S].size(); i++) {
			// System.out.println(dislist[0].get(i).x);
			// if(dis[dislist[S].get(i).x] == Integer.MAX_VALUE) cnt++;
			if (dis[dislist[S].get(i).x] > dislist[S].get(i).price) {
				dis[dislist[S].get(i).x] = dislist[S].get(i).price;
				pq.add(dislist[S].get(i));
				/*
				 * dislist[S].remove(i); i--;
				 */
			}

		}
		/*
		 * for(int i=1;i<V+1;i++) { if(dis[i] == Integer.MAX_VALUE)
		 * System.out.println("INF"); else System.out.println(dis[i]); }
		 */

		dis[S] = 0;
		while (!pq.isEmpty()) {
			pair pqtmp = pq.poll();
			if (!is_visit[pqtmp.x]) {
				int index = pqtmp.x;
				is_visit[pqtmp.x] = true;
				for (int j = 0; j < dislist[index].size(); j++) {
					int price = dislist[index].get(j).price;
					int x = dislist[index].get(j).x;
					if (price + dis[index] < dis[x]) {
						dis[x] = price + dis[index];
						pq.add(new pair(x, dis[x]));
					}
				}
			}
			// if(cnt > V) break;
		}
		/*
		 * for(int i=0;i<V;i++) { int max = Integer.MAX_VALUE, index=0;
		 * 
		 * for(int j=1;j<V+1;j++) { if(!is_visit[j] && dis[j]<max) { max = dis[j];
		 * index=j; } } is_visit[index]=true; for(int j=0;j<dislist[index].size();j++) {
		 * if( dislist[index].get(j).price+dis[index] < dis[dislist[index].get(j).x]) {
		 * dis[dislist[index].get(j).x] = dislist[index].get(j).price+dis[index]; } }
		 */
		/*
		 * for(int j=1;j<V+1;j++) { if(dismap[index][j] != 0 && dis[j] >
		 * dis[index]+dismap[index][j]) { dis[j] = dis[index]+dismap[index][j]; } }
		 */

		// }
		for (int i = 1; i < V + 1; i++) {
			if (dis[i] == inf)
				System.out.println("INF");
			else
				System.out.println(dis[i]);
		}
	}

}

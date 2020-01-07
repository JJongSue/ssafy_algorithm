package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18232 {
	static ArrayList<Integer> tel[];
	static boolean is_visit[];
	static int N, S, E;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tel = new ArrayList[N+1];
		for(int i=1;i<=N;i++) tel[i] = new ArrayList<Integer>();
		is_visit = new boolean[N+1];
		is_visit[S] = true;
		int ans = 0;
		int time = 1;
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		q.add(S);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			tel[tmp1].add(tmp2);
			tel[tmp2].add(tmp1);
		}
		end:while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int now = q.poll();
				//System.out.println(now);
				if(now+1 <= N && !is_visit[now+1]) {
					is_visit[now+1] = true;
					if(now+1 == E) {
						ans = time;
						break end;
					}
					q.add(now+1);
				}
				if(now-1 >= 1 && !is_visit[now-1]) {
					is_visit[now-1] = true;
					if(now-1 == E) {
						ans = time;
						break end;
					}
					q.add(now-1);
				}
				for(int i=0;i<tel[now].size();i++) {
					if(!is_visit[tel[now].get(i)]) {
						is_visit[tel[now].get(i)] = true;
						if(tel[now].get(i) == E) {
							ans = time;
							break end;
						}
						q.add(tel[now].get(i));
					}
				}
				/*if(tel[now] != 0 && !is_visit[tel[now]]) {
					is_visit[tel[now]] = true;
					if(tel[now] == E) {
						ans = time;
						break end;
					}
					q.add(tel[now]);
				}*/
			}
			time++;
		}
		System.out.println(ans);
	}
}

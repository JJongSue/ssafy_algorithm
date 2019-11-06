package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2383 {
	static int N;
	static int stair[][];
	static int map[][];
	static ArrayList<pair> al;
	static PriorityQueue<Integer> pq1,pq2;
	static int select[];
	static int ans;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			stair = new int[2][3];
			map = new int[N][N];
			al = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			int si=0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) al.add(new pair(j, i));
					else if(map[i][j] > 1) {
						stair[si][0] = j;
						stair[si][1] = i;
						stair[si][2] = map[i][j];
						si++;
					}
				}
			}
			select = new int[al.size()];
			combi(0);
			System.out.println("#"+tc+" "+(ans+1));
			
			
			
		}
		
		
	}
	static void combi(int now) {
		if(now == al.size()) {
			look();
			return;
		}
		select[now] = 1;
		combi(now+1);
		select[now] = 0;
		combi(now+1);
	}
	static void look() {
		pq1 = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		pq2 = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		for(int i=0;i<al.size();i++) {
			int s = select[i];
			int dis = Math.abs(stair[s][0]-al.get(i).x)+Math.abs(stair[s][1]-al.get(i).y);
			if(select[i] == 0) pq1.add(dis);
			else pq2.add(dis);
		}
		Queue<Integer> tmpq = new LinkedList<Integer>();
		int time = 0;
		while(!pq1.isEmpty()) {
			if(tmpq.size() == 3) {
				time = tmpq.poll();
			}			
			tmpq.add(Math.max(pq1.poll(),time)+stair[0][2]);
		}
		while(!tmpq.isEmpty()) {
			time = tmpq.poll();
		}
		
		tmpq = new LinkedList<Integer>();
		int time1 = 0;
		while(!pq2.isEmpty()) {
			if(tmpq.size() == 3) {
				time1 = tmpq.poll();
			}			
			tmpq.add(Math.max(pq2.poll(),time1)+stair[1][2]);
		}
		while(!tmpq.isEmpty()) {
			time1 = tmpq.poll();
		}
		ans = Math.min(ans, Math.max(time1, time));
		
		
		
	}

	
}

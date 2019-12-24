package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main9202 {
	static final int dx[] = {-1,0,1,-1,0,1,-1,0,1};
	static final int dy[] = {-1,-1,-1,0,0,0,1,1,1};
	static int count = 0;
	static int score = 0;
	static String ans ="";
	static char map[][] = new char[4][4];
	static boolean is_visit[][];
	static class pair{
		int x;
		int y;
		int now;
		public pair(int x, int y, int now) {
			super();
			this.x = x;
			this.y = y;
			this.now = now;
		}
	}
	static class Node{
		int next[] = new int[27];
		int cnt;
		public Node() {
			for(int i=0;i<27;i++) next[i] = -1;
			cnt = 0;
		}
	}
	static class trie{
		Node node[] = new Node[1000000];
		int now;
		int root;
		public trie() {
			root = 0;
			now = 1;
			node[root] = new Node();
		}
		void add(int go, int sgo, String s) {
			node[go].cnt++;
			if(sgo == s.length()) {
				node[go].next[26] = 0;
				return;
			}
			int ch = s.charAt(sgo) -'A';
			if(node[go].next[ch] == -1) {
				node[go].next[ch] = now;
				node[now] = new Node();
				now++;
			}
			add(node[go].next[ch], sgo+1, s);
		}
		void get(int go ,String s) {
			int cnttmp = 0;
			if(node[go].next[26] == 0) {
				find_map(s);
				cnttmp++;
			}
			for(int i=0;i<26;i++) {
				if(cnttmp == node[go].cnt) return;
				if(node[go].next[i] != -1) {
					char c = (char) (i+'A');
					get(node[go].next[i], s+c);
					cnttmp++;
					
				}
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		trie t = new trie();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			t.add(0, 0, tmp);
		}
		br.readLine();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			for(int i=0;i<4;i++) {
				map[i] = br.readLine().toCharArray();
			}
			count = 0;
			score = 0;
			ans = "";
			t.get(0, "");
			System.out.println(score+" "+ans+" "+count);
			br.readLine();
			
		}
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y<0 || x>=4 || y>=4) return false;
		return true;
	}
	static void find_map(String s) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(map[i][j] == s.charAt(0)) {
					is_visit = new boolean[4][4];
					is_visit[i][j] = true;
					boolean tmp = dfs(j,i,s,1);
					if(tmp) {
						count++;
						int sl = s.length();
						if(sl==4 || sl == 3) score+=1;
						else if(sl==5 ) score+=2;
						else if(sl==6 ) score+=3;
						else if(sl==7 ) score+=5;
						else if(sl==8 ) score+=11;
						if(ans.length() < sl || ans.equals("")) ans= s;
						return;
					}
				}
			}
		}
	}
	static boolean dfs(int x, int y, String str, int now) {
		if(now == str.length()) return true;
		for(int i=0;i<9;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(is_map(xx, yy) && !is_visit[yy][xx] && map[yy][xx]==str.charAt(now)) {
				is_visit[yy][xx] = true;
				boolean tmp = dfs(xx, yy, str, now+1);
				if(tmp) return true;
				is_visit[yy][xx] = false;
			}
		}
		return false;
	}
	
	static boolean go_map(int x, int y, String str) {
		Stack<pair> q = new Stack<>();
		q.add(new pair(x, y, 1));
		int now = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			int x1 = q.peek().x;
			int now1 = q.peek().now;
			int y1 = q.pop().y;
			for(int i=0;i<9;i++) {
				int xx = x1+dx[i];
				int yy = y1+dy[i];
				if(!is_visit[yy][xx] && str.charAt(now) == map[yy][xx]) {
					//q.add(new )
				}
			}
			
		}
		return false;
	}
}

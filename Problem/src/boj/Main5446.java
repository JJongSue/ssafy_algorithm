package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main5446 {
	static int ans;
	static class Node{
		int dcnt;
		int ddcnt;
		int next[];
		public Node() {
			next = new int[129];
			dcnt = 0;
			ddcnt = 0;
			for(int i=0;i<129;i++) next[i] = -1;
		}
		
		
		
	}
	static class trie{
		Node node[] = new Node[100000];
		int now;
		int root;
		public trie() {
			root = 0;
			now = 1;
			node[root] = new Node();
		}
		void add(int go, int sgo, int sum, int dsum, String s) {
			node[go].dcnt += sum;
			node[go].ddcnt += dsum;
			if(sgo == s.length()) {
				if(sum == 1)
				node[go].next[128] = 0;
				return;
			}
			int ch = s.charAt(sgo);
			if(node[go].next[ch] == -1) {
				node[go].next[ch] = now;
				node[now] = new Node();
				now++;
			}
			add(node[go].next[ch], sgo+1, sum, dsum, s);
		}
		void get_ans(int go, String s) {
			if(node[go].ddcnt == 0) {
				//System.out.println(s);
				ans++;
				return;
			}
			for(int i=0;i<128;i++) {
				if(node[go].next[i] != -1) {
					char tmp = (char) i;
					get_ans(node[go].next[i], s+tmp);
				}
			}
			if(node[go].next[128] == 0) {
				//System.out.println(s);
				ans++;
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			trie t = new trie();
			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				t.add(0, 0, 1, 0, tmp);
			}
			int M = Integer.parseInt(br.readLine());
			for(int i=0;i<M;i++) {
				String tmp = br.readLine();
				t.add(0, 0, 0, 1, tmp);
			}
			ans = 0;
			t.get_ans(0 , "");
			System.out.println(ans);
		}
	}
}

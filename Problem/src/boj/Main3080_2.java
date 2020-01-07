package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main3080_2 {
	//static long nums[] = new long[28];
	static long ans = 1;
	/*static void set_num() {
		nums[1] = 1;
		nums[0] = 1;
		for(int i=2;i<28;i++) {
			nums[i] = (nums[i-1] * i) % 1_000_000_007;
		}
	}*/
	static class pair{
		int go;
		int now;
		public pair(int go, int now) {
			super();
			this.go = go;
			this.now = now;
		}
		
	}
	static class Node{
		ArrayList<pair> next;
		int count;
		public Node() {
			next = new ArrayList<>();
			//for(int i=0;i<27;i++) next[i] = -1;
			count = 0;
		}
		
	}
	static class trie{
		Node nodes[] = new Node[5000000];
		int now;
		int root;
		public trie() {
			now = 1;
			root = 0;
			nodes[root] = new Node();
		}
		void add(int go, int sgo, String str) {
			
			if(str.length() == sgo) {
				nodes[go].count++; 
				ans = (ans*nodes[go].count) % 1_000_000_007;
				//nodes[go].next[26] = 0;
				return;
			}
			int ch = str.charAt(sgo) - 'A';
			for(int i=0;i<nodes[go].next.size();i++) {
				if(nodes[go].next.get(i).go == ch) {
					add(nodes[go].next.get(i).now, sgo+1, str);
					return;
				}
			}
			nodes[go].count++; 
			ans = (ans*nodes[go].count) % 1_000_000_007;
			nodes[go].next.add(new pair(ch, now));
			nodes[now] = new Node();
			now++;
			add(now-1, sgo+1, str);
			/*if(nodes[go].next[ch] == -1) {
				nodes[go].count++; 
				nodes[go].next[ch] = now;
				nodes[now] = new Node();
				now++;
			}
			add(nodes[go].next[ch], sgo+1, str);*/
		}
//		void get_ans(int go) {
//			int tmpcnt = 0;
//			ans = (ans*nums[nodes[go].count]) % 1_000_000_007;
//			//if(nodes[go].next[26] == 0) tmpcnt++;
//			/*for(int i=0;i<26;i++) {
//				//if(tmpcnt == nodes[go].count) return;
//				if(nodes[go].next[i] != -1) {
//					get_ans(nodes[go].next[i]);
//					tmpcnt++;
//				}
//			}*/
//			for(int i=0;i<nodes[go].next.size();i++) {
//				get_ans(nodes[go].next.get(i).now);
//			}
//		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		trie t = new trie();
		//set_num();
		for(int i=0;i<N;i++) {
			t.add(0, 0, br.readLine());
		}
		//t.get_ans(0);
		System.out.println(ans);
	}
	
}

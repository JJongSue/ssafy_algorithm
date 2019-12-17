package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4358 {
	static double sum = 0;
	static class Node{
		int next[] = new int[128];
		int cnt;
		public Node() {
			for(int i=0;i<128;i++) {
				next[i] = -1;
			}
			cnt = 0;
		}		
	}
	static class trie{
		int root;
		int now;
		Node node[];
		public trie() {
			root = 0;
			now = 1;
			node = new Node[500001];
			node[root] = new Node();
		}
		void insert(int where, int strwhere, String str) {
			if(str.length() == strwhere) {
				node[where].cnt++;
				return;
			}
			int ch = str.charAt(strwhere);
			if(node[where].next[ch] == -1) {
				node[now] = new Node();
				node[where].next[ch] = now++;				
			}
			insert(node[where].next[ch], strwhere+1, str);
			
		}
		void out(int x, String tmp) {
			if(node[x].cnt != 0) System.out.println(tmp+" "+String.format("%.4f", node[x].cnt/sum*100));
			for(int i=0;i<128;i++) {
				if(node[x].next[i] != -1) {
					char ch = (char) i;
					out(node[x].next[i], (tmp+ch));
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		trie  t = new trie();
		while((input = br.readLine()) != null) {			
			t.insert(0, 0, input);
			sum++;
		}
		t.out(0, "");
		
	}
}

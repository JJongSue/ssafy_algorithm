package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5052 {
	static boolean ans = false;;
	static class Node{
		boolean end;		
		int next[] = new int[11];
		public Node() {
			for(int i=0;i<11;i++) next[i] = -1;
			end = false;			
		}	
	}
	static class trie{
		Node node[];
		int root;
		int now;
		public trie() {
			root = 0;
			now = 1;
			node = new Node[100001];
			node[0] = new Node();
		}
		public void insert(int where, int strw, String str, boolean is_new) {
			if(strw == str.length()) {
				if(is_new) {
					ans = true;
				}
				node[where].end = true;				
				return;
			}
			if(node[where].end) {
				ans = true;
				return;
			}
			int go = str.charAt(strw)-'0';
			boolean tmp = is_new;
			if(node[where].next[go] == -1) {
				node[now] = new Node();
				node[where].next[go] = now++;
				tmp = false;
				
			}else tmp = true;
			insert(node[where].next[go], strw+1, str, tmp);
			
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			trie t = new trie();
			int N = Integer.parseInt(br.readLine());
			ans = false;
			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				t.insert(0, 0, tmp, false);
			}
			if(ans) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}

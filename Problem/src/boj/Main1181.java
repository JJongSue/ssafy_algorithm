package boj;

public class Main1181 {
	static class node{
		int next[] = new int[26];
		boolean print;
		public node() {
			for(int i=0;i<26;i++) next[i] = -1;
			print = false;
		}
		
	}
	static class trie{
		node node[] = new node[100000];
		int root;
		int now;
		public trie() {
			root = 0;
			now = 1;
			node[0] = new node();
		}
		void add(int next, int snext, String str) {
			if(snext == str.length()) {
				node[next].print = true;
				return;
			}
			int 
		}
		
		
	}
	
	public static void main(String[] args) {
		
	}
}

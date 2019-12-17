package algo;

public class Practice {
	static class Node{
		int next[] = new int[26];
		int cnt;
		public Node() {
			for(int i=0;i<26;i++) next[i] = -1;
			cnt = 0;
		}
		
	}
	static class trie{
		Node trie[] = new Node[200];
		int trieN;
		int root;
		public trie() {
			trie[0] = new Node();
			trieN = 1;
			root = 0;
		}
		void Insert(int go, int charat, String str) {
			trie[go].cnt++;
			if(charat == str.length()) return;
			int ch = str.charAt(charat)-'a';
			if(trie[go].next[ch] == -1) {
				trie[trieN] = new Node();
				trie[go].next[ch] = trieN++;				
			}
			Insert(trie[go].next[ch], charat+1, str);
		}
		int query(String str) {
			int trieIdx = root;
			for(int i=0;i<str.length();i++) {
				int ch = str.charAt(i)-'a';
				trieIdx = trie[trieIdx].next[ch];
				if(trieIdx == -1) return 0;
			}
			return trie[trieIdx].cnt;
		}
		
		
	}
}

package algo;

public class MyTrie {
	static class trie{
		Node trie[] = new Node[200];
		int root = 0;
		int trieN;
		public trie() {
			root = 0;
			trieN = 0;
			trie[0] = new Node();
		}

		static class Node{
			int next[] = new int[26];
			int cnt;
			public Node() {
				cnt = 0;
				for(int i=0;i<26;i++) next[i] = -1;			
			}
			
		}
		void myInsert(int trieIdx, int strIdx, String str) {
			trie[trieIdx].cnt++;
			if(strIdx == str.length()) return;
			int ch = str.charAt(strIdx) - 'a';
			
			if(trie[trieIdx].next[ch] == -1) {
				trie[trieIdx].next[ch] = ++trieN;
				trie[trieN] = new Node();
			}
			myInsert(trie[trieIdx].next[ch], strIdx+1, str);
			
		}
		void insert(String str) {
			myInsert(root, 0, str);
		}
		
		
		
		
	}
}

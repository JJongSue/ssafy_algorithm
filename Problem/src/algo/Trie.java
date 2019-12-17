package algo;

public class Trie {
	static Node trie[] = new Node[200];
	
	static class Node{
		int next[] = new int[26];
		int cnt;

		public Node() {
			for(int i=0;i<26;i++) next[i] = -1;
			cnt=0;
		}
		
	}
	static int root;
	static int trieN;
	
	void init() {
		root = 0;
		trieN = 0;
		trie[0] = new Node();
	}
	
	void Insert(int trieIdx, int bufIdx, int buffer_size, String buf) {
		trie[trieIdx].cnt++;
		if(bufIdx == buffer_size) return;
		int ch = buf.charAt(bufIdx) - 'a';
		
		if(trie[trieIdx].next[ch] == -1) {
			trie[trieIdx].next[ch] = ++trieN;
			trie[trieN] = new Node();
		}
		
		Insert(trie[trieIdx].next[ch], bufIdx+1, buffer_size, buf);
	}
}

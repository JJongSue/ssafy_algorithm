package B형;

public class Solution3135 {
	static class Node{
		int next[] = new int[26];
		int cnt;
		public Node() {
			for(int i=0;i<26;i++) next[i] = -1;
			cnt=0;
		}
	}
	static Node trie[] = new Node[100001];
	static int trieN;
	static int root = 0;
	
	public void myInsert(int go, int char_now, int buffer_size, String buf) {
		trie[go].cnt++;
		if(char_now == buffer_size) return;
		int ch = buf.charAt(char_now) - 'a';
		if(trie[go].next[ch] == -1) {
			trie[trieN] = new Node();
			trie[go].next[ch] = trieN++;
		}
		myInsert(trie[go].next[ch], char_now+1, buffer_size, buf);
	}
	
	public void init() {
		trieN = 1;
		root = 0;
		trie[root] = new Node();
	}
	
	public void insert(int buffer_size, String buf) {
		myInsert(root, 0, buffer_size, buf);
	}
	
	public int query(int buffer_size, String buf) {
		int go = root;
		for(int i=0;i<buffer_size;i++) {
			int ch = buf.charAt(i) - 'a';
			go = trie[go].next[ch];
			if(go == -1) return 0;
		}
		return trie[go].cnt;
	}
}

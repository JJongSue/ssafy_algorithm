package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 트라이 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String str;
	private static int i;
	private static int res;
	
	static int nextInt() {
		try {
			i=Integer.parseInt(br.readLine().trim());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	static String nextLine() {
		try {
			str=br.readLine().trim();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return str;
	}
	class Node{
		char data;
		int cnt;
		Node[] nxt = new Node[26];
		
		public Node(char data, int cnt) {
			this.data = data;
			this.cnt = cnt;
		}
	}
	
	private static void searchLeaf(Node node) {
		if(node.cnt == 0) {
			res++;
			return;
		}
		for(int i=0;i<26;i++) {
			if(node.nxt[i] != null) {
				searchLeaf(node.nxt[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int N = nextInt();

		Node root = new Node('r', 0);
		for (int n = 1; n <= N; n++) {
			Node node = root;
			String str = nextLine();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (node.nxt[c - 'a'] == null) {
					node.cnt++;
					node.nxt[c - 'a'] = new Node(c, 0);
				}
				node = node.nxt[c - 'a'];
			}

		}
		res = 0;
		searchLeaf(root);
		
		if (res != N) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
	
}

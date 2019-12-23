package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5670 {
	static double sum;
	static int N;
	static class Node{
		int Next[] = new int[27];
		int cnt;
		public Node() {
			for(int i=0;i<27;i++) Next[i] = -1;
			cnt = 0;
		}
		
	}
	
	static class trie{
		Node node[] = new Node[500000];
		int root;
		int now;
		public trie() {
			root = 0;
			now = 1;
			node[root] = new Node();
		}
		void add(int go, int sgo, String s) {
			if(sgo == s.length()) {
				node[go].Next[26] = 0;
				node[go].cnt++;
				return;
			}
			int ch = s.charAt(sgo) - 'a';
			if(node[go].Next[ch] == -1) {
				node[go].cnt++;
				node[go].Next[ch] = now;
				node[now] = new Node();
				now++;
			}
			add(node[go].Next[ch], sgo+1, s);
		}
		void get_ans(int go, int sumgo) {
			if(node[go].cnt == 1) {
				if(node[go].Next[26] == 0) {
					sum += sumgo;
					//System.out.println(sumgo);
					return;
				}else {
					for(int i=0;i<26;i++) {
						if(node[go].Next[i] != -1) {
							get_ans(node[go].Next[i], sumgo);
							return;
						}
					}
				}
			}else {
				if(node[go].Next[26] == 0) {
					sum += sumgo;
					//System.out.println(sumgo);
				}
				for(int i=0;i<26;i++) {
					if(node[go].Next[i] != -1) {
						get_ans(node[go].Next[i], sumgo+1);
					}
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while((input = br.readLine()) != null) {
			//System.out.println("1");
			N = Integer.parseInt(input);
			sum = 0;
			trie t = new trie();
			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				//System.out.println(tmp);
				t.add(0, 0, tmp);
			}
			t.get_ans(0, 0);
			if(t.node[0].cnt == 1) {
				System.out.println(String.format("%.2f", sum/N+1));
				
			}
			else {
				System.out.println(String.format("%.2f", sum/N));
			}
		}
	}
}

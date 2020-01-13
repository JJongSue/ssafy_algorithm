package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main18119 {
	static int Scnt[];
	static boolean is_have[][], is_delete[][];
	static ArrayList<Integer> al[] = new ArrayList[26];
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Scnt = new int[N];
		is_have = new boolean[N][26];
		is_delete = new boolean[N][26];
		for(int i=0;i<26;i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				int ch = tmp.charAt(j) - 'a';
				if(!is_have[i][ch]) {
					//is_delete[i][ch] = true;
					is_have[i][ch] = true;
					al[ch].add(i);
					//Scnt[i]++;
				}
			}
		}
		int ans = N;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int ch = c -'a';
			if(cmd == 1) {
				for(int s=0;s<al[ch].size();s++) {
					int go = al[ch].get(s);
					if(is_have[go][ch] && !is_delete[go][ch]) {
						is_delete[go][ch] = true;
						if(Scnt[go] == 0) ans--;
						Scnt[go]++;
					}
				}
			}else {
				for(int s=0;s<al[ch].size();s++) {
					int go = al[ch].get(s);
					if(is_have[go][ch] && is_delete[go][ch]) {
						is_delete[go][ch] = false;
						Scnt[go]--;
						if(Scnt[go] == 0) ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1062 {
	static int N, K;
	static ArrayList<Character> al[];
	static char[] teach;
	static int cnt[];
	static boolean is_alpa[][];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N];
		teach = new char[K-5];
		cnt = new int[N];
		is_alpa = new boolean[N][26];
		
		for(int i=0;i<N;i++) {
			
			al[i] = new ArrayList<>();
			String tmp = br.readLine();
			for(int j=4;j<tmp.length()-4;j++) {
				char ch = tmp.charAt(j);
				if(ch != 'a' && ch != 'n' && ch != 't' && ch != 'i' && !is_alpa[i][ch-'a']) {
					is_alpa[i][ch-'a'] = true;
					cnt[i]++;
				}
			}
			
		}
		if(K<4) {
			System.out.println(0);
		}else {
			/*teach[0] = 'a';
			teach[1] = 'n';
			teach[2] = 't';
			teach[3] = 'i';
			teach[4] = 'c';*/
			//find_char(0, 0);
			System.out.println(ans);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

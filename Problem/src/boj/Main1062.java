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
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		al = new ArrayList[N];
		teach = new char[K-5];
		for(int i=0;i<N;i++) {
			//System.out.println(i);
			al[i] = new ArrayList<>();
			String tmp = br.readLine();
			//for(int j=4;j<tmp.length()-4;j++) {
			for(int j=0;j<tmp.length();j++) {
				char tmpc = tmp.charAt(j);
				boolean is_ok = true;
				if(tmpc != 'a' && tmpc != 'n' && tmpc != 't' && tmpc != 'i' && tmpc != 'c') {
					for(int k=0;k<al[i].size();k++) {
						if(al[i].get(k) == tmpc) {
							is_ok=false;
							break;							
						}
					}
					if(is_ok) al[i].add(tmpc);
				}
			}
			//System.out.println(al[i].size());
		}
		if(K<4) {
			System.out.println(0);
		}else {
			/*teach[0] = 'a';
			teach[1] = 'n';
			teach[2] = 't';
			teach[3] = 'i';
			teach[4] = 'c';*/
			find_char(0, 0);
			System.out.println(ans);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	static void find_char(int now, int cnt) {
		//System.out.println(now + " " + cnt);
		if(cnt == K-5) {
			count();
			return;
		}
		if(now > 26) return;
		if(now == 'a'-'a' || now == 'n'-'a' || now == 't'-'a' || now == 'i'-'a' || now == 'c'-'a') {
			find_char(now+1, cnt);
			return;
		}
		teach[cnt] = (char) ('a'+now);
		//System.out.println(teach[cnt]);
		find_char(now+1, cnt+1);
		find_char(now+1, cnt);
		
		
		
	}
	static void count() {
		int cnt = 0;
		for(int i=0;i<al.length;i++) {
			boolean is_ok = true;
			
			for(int j=0;j<al[i].size();j++) {
				//System.out.println("이거되냐");
				is_ok = false;
				for(int k=0;k<K-5;k++) {
					if(teach[k] == al[i].get(j)) {
						is_ok=true;
						break;
					}
				}
				if(!is_ok) break;				
				
			}
			if(is_ok) {
				cnt++;
			}
			
		}
		
		ans = Math.max(cnt, ans);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

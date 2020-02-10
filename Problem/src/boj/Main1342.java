package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main1342 {
	//static boolean is_visit[] = new boolean[4_000_000];
	static HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	static int cntA[] = new int[10];
	static int N = 0;
	static String str;
	static HashSet<String> hs = new HashSet<String>();
	static int ansmap[];
	static int anscnt = 0;
	//static int[]
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		ansmap = new int[str.length()];
		for(int i=0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if(!hm.containsKey(ch)) {
				hm.put(ch, N++);
			}
			int now = hm.get(ch);
			cntA[now]++;
		}
		//System.out.println(N);
		if(N == str.length()) {
			int ans = 1;
			for(int i=0;i<N;i++) ans *= (i+1);
			System.out.println(ans);
		}else {
			comb(0, 0);
			System.out.println(anscnt);
			//System.out.println(hs.size());
		}
	}
	
	static void comb(int now, int cnt) {
		if(now == N) return;
		if(cnt == str.length()) {
			/*String tmp = "";
			for(int i=0;i<str.length()-1;i++) {
				if(ansmap[i] == ansmap[i+1]) return;
				tmp += ansmap[i];
			}
			tmp+= ansmap[str.length()-1];
			if(!hs.contains(tmp)) hs.add(tmp);*/
			anscnt++;
			return;
		}
		comb(now+1, cnt);
		if(cntA[now] != 0) {
			if(cnt > 0) {
				if(ansmap[cnt-1] == now) return;
			}
			ansmap[cnt] = now;
			cntA[now]--;
			comb(0, cnt+1);
			cntA[now]++;	
		}
		
		
		
		
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1062 {
	static int N, K;
	static int cnt = 0, ans = 0;
	static boolean is_visit[] = new boolean[26];
	static ArrayList<String> al = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(K<5) {
			System.out.println(0);
		}else {
			K = K - 5;
			is_visit['a'-'a'] = true;
			is_visit['n'-'a'] = true;
			is_visit['t'-'a'] = true;
			is_visit['i'-'a'] = true;
			is_visit['c'-'a'] = true;
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				boolean is_add = true;
				for(int j=4;j<str.length()-4;j++) {
					if(!is_visit[str.charAt(j)-'a']) {
						is_add = false;
						break;
					}
				}
				if(is_add) {
					cnt++;
				}else {
					al.add(str);
				}
			}
			ans = cnt;
			select_alpha(0, 0);
			System.out.println(ans);
			
		}
	}
	static void select_alpha(int now, int count) {
		if(count == K) {
			// 여기에 개수 세는거
			cnt_str();
			return;
		}
		if(now == 26) {
			return;
		}
		if(is_visit[now]) {
			select_alpha(now+1, count);
		}else {
			is_visit[now] = true;
			select_alpha(now+1, count+1);
			is_visit[now] = false;
			select_alpha(now+1, count);
		}
	}
	static void cnt_str() {
		int tmp = cnt;
//		System.out.println(al.size());
		for(int i=0;i<al.size();i++) {
			String str = al.get(i);
			boolean is_add = true;
			for(int j=4;j<str.length()-4;j++) {
				if(!is_visit[str.charAt(j)-'a']) {
					is_add = false;
					break;
				}
			}
			if(is_add) tmp++;
		}
		ans = Math.max(ans, tmp);
	}
	
	
	
	
	
}

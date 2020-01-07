package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2866 {
	static final int max_v = 1_000_003;
	static char map[][];
	static hash_map is_visit[] = new hash_map[max_v];
	static int get_hash(char a, char b) {
		int hash = (a-'a')*5 + (b-'a');
		return hash;
	}
	static int hash_now = 1;
	static hash_map ht[] = new hash_map[max_v];
	
	static class hash_map{
		String value;
		int next;
		public hash_map(String value, int next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	static boolean set_hash(String key, int h) {
		if(is_visit[h].value.equals("")) {
			is_visit[h] = new hash_map(key, -1);
			return true;
		}
		if(is_visit[h].value.equals(key)) {
			return false;
		}
		
		int go = is_visit[h].next;
		if(go == -1) {
			is_visit[h].next = hash_now;
			ht[hash_now++] = new hash_map(key, -1);
			return true;
		}
		if(ht[go].value.equals(key)) {
			return false;
		}
		int tmp = go;
		while(true) {
			tmp = go;
			go = ht[go].next;
			if(go == -1) break;
			if(ht[go].value.equals(key)) {
				return false;
			}
		}
		ht[tmp].next =  hash_now;
		ht[hash_now++] = new hash_map(key, -1);
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			//is_visit = new boolean[200];
			map[i] = br.readLine().toCharArray();
			
		}
		for(int i=0;i<max_v;i++) {
			is_visit[i] = new hash_map("", -1);
		}
		
		int left = 0;
		int right = N;
		int ans = 0;
		while(left <= right) {
			int mid = (left+right) / 2;
			boolean is_end = false;
			//System.out.println(mid);
			boolean is_start = false;
			end:for(int j=0;j<M;j++) {
				long h = 1;
				String tmp = "";
				for(int k=mid+1;k<N;k++) {
					is_start = true;
					tmp += map[k][j];
					int ch = map[k][j]-'a';
					h = (h * 31 + ch) % max_v;
				}
				//System.out.println(h);
				if(!set_hash(tmp, (int)h)) {
					//System.out.println(i+" "+j+" "+map[i-1][j] + " " + map[i][j]);
					is_end = true;
					break end;
				}
				//is_visit[(int) h] = true;
			}
			if(is_end) {
				right = mid-1;
				
			}else {
				if(is_start) ans = mid+1;
				left = mid+1;
			}
		}
		if(ans >= N) System.out.println(N);
		else System.out.println(ans);
		

	}
}

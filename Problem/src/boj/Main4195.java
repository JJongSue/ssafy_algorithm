package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4195 {
	static int parents[] = new int[1000003];
	static hash ht[] = new hash[1000003];
	static int find_set(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find_set(parents[x]);
	}
	static int hash_now = 500_001;
	
	static class hash{
		String key;
		int value;
		public hash(String key, int value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
	static void union(int x, int y) {
		int px = find_set(x);
		int py = find_set(y);
		
		if(px == py) return;
		parents[px] += parents[py];
		parents[py] = px;
	}
	
	static long set_hash(String key, long hash, int now) {
		//hash = hash % 1000003;
		if(ht[(int) hash] == null) {
			ht[(int) hash] = new hash(key, -1);
			return hash;
		}
		if(ht[(int) hash].key.equals(key)) {
			return hash;
		}
		int tmpnow = ht[(int)hash].value;
		int post = (int)hash;
		while(tmpnow != -1) {
			if(ht[post].key.equals(key)) {
				return post;
			}
			post = tmpnow;
			tmpnow = ht[post].value;
		}
		if(ht[post].key.equals(key)) {
			return post;
		}
		ht[post].value = hash_now;
		ht[hash_now] = new hash(key, -1);
		hash_now++;
		return hash_now-1;
		//return hash;
		
		//return hash;
		
		
	}
	
	static long get_hash(String str) {
		int h = 5381;
		long hash = 0;
		for(int i=0;i<str.length();i++) {
			//hash = (hash << 5) + hash + str.charAt(i);
			//hash = (((hash << 5) + hash)+str.charAt(i) ) % 1000003;
			hash = (hash * h + (str.charAt(i)-'A')) % 500_001 ;
		}
		if(hash < 0 ) hash *= -1;
		hash = hash % 500_001;
		return  hash;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<1000003;i++) {
				parents[i] = -1;
			}
			ht = new hash[1000003];
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				int x = (int) get_hash(str1);
				int hx = (int) set_hash(str1, x, 0);
				int y = (int) get_hash(str2);
				int hy = (int) set_hash(str2, y, 0);
				//System.out.println(x + " " + y);
				union(hx, hy);
				//System.out.println(parents[find_set(x)] * (-1));
				sb.append(parents[find_set(hx)]*(-1)).append("\n");
			}
			System.out.print(sb);
		}
		
		
	}
	
}

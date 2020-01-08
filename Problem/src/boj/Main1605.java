package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1605 {
	static final int max_size = 100_003;//1_000_003;
	static boolean is_visit[];
	static hash ht[] = new hash[max_size];
	static hash al[] = new hash[max_size];
	static String str;
	static int alnow = 1;
	static class hash{
		int next;
		String key;
		public hash(int next, String key) {
			super();
			this.next = next;
			this.key = key;
		}
	}
	
	
	static boolean set_hash(String key, int hash) {
		if(ht[hash] == null) {
			ht[hash] = new hash(-1, key);
			return true;
		}
		if(ht[hash].key.equals(key)) {
			return false;
		}
		int next = ht[hash].next;
		int post = hash;
		while(next != -1) {
			if(al[post].key.equals(key)) {
				return false;
			}
			post = next;
			next = al[post].next;
		}
		al[post].next = alnow;
		al[alnow++] = new hash(-1, key);
		return true;
	}
	static int ans = 0, N = 200000;
	static void binary_search() {
		int left = 0;
		int right = N;
		while(left <= right) {
			is_visit = new boolean[max_size];
			int mid = (left + right) / 2;
			//System.out.println(mid);
			for(int i=0;i<max_size;i++) {
				ht[i] = null;
				al[i] = null;
			}
			alnow = 1;
			boolean sh = true;
			for(int i=0;i+mid-1<N;i++) {
				long hash = 0;
				//String key = "";
				for(int j=0;j<mid;j++) {
					int ch = str.charAt(i+j) - 'a';
					//key += str.charAt(i+j);
					hash = (hash * 5381) + ch;
				}
				if(hash < 0) hash = hash * (-1);
				hash = hash % max_size;
				sh = is_visit[(int) hash];
				
				//System.out.println(key + " " + hash);
				//sh = set_hash(key, (int) hash);
				
				if(sh) {
					break;
				}
				is_visit[(int)hash] = true;
			}
			if(!sh) {
				right = mid-1;
			}else {
				ans = mid;
				left = mid+1;
			}
		
		}
	}
	
	
	
	static int get_hash(String str) {
		long hash = 0;
		int h = 5381;
		for(int i=0;i<str.length();i++) {
			int ch = str.charAt(i) - 'a';
			hash = ( (hash * h) + ch );
		}
		if(hash < 0) hash *= (-1);
		hash = (hash) % max_size;
		return (int)hash;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		binary_search();
		System.out.println(ans);
	}
}

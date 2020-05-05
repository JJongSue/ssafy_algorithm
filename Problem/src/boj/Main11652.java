package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11652 {
	static final int size = 1_000_000;
	static class Hash{
		int cnt;
		long num;
		public Hash(int cnt, long num) {
			super();
			this.cnt = cnt;
			this.num = num;
		}
	}
	static Hash table[] = new Hash[size];
	
	static int get_hash(long num) {
		long hash = 5381;
		while(num != 0) {
			int mul =  (int) (num%10);
			num = num/10;
			hash = (hash<<5) + hash + mul;
		}
		if(hash < 0) hash *= (-1);
		
		return (int) (hash % size);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(get_hash(2));
		System.out.println(Long.MIN_VALUE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int anscnt = 0;
		long ans = Long.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			long input = Long.parseLong(br.readLine());
			int hash = get_hash(input);
			System.out.println(hash);
			if(table[hash] == null) {
				table[hash] = new Hash(1, input);
			}else {
				if(table[hash].num == input) {
					table[hash].cnt++;
				}else {
					int j = 1;
					while(table[hash] == null || table[hash].num == input) {
						hash += j;
						j++;
						hash = hash % size;
					}
					if(table[hash] == null) {
						table[hash] = new Hash(1, input);
					}else {
						table[hash].cnt++;
					}
				}
			}
			if(anscnt == table[hash].cnt && input < ans) {
				ans = input;
			}
			if(anscnt < table[hash].cnt) {
				ans = input;
				anscnt = table[hash].cnt;
			} 
			
		}
		System.out.println(ans);
		
		
	}
}

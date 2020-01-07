package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3022 {
	static final int max_num = 1_000_003;
	static int cookie[] = new int[max_num];
	static int get_hash(String str) {
		long hash = 0;
		int h = 5381;
		for(int i=0;i<str.length();i++) {
			hash = (hash * h + str.charAt(i)-'A') % max_num;
		}
		return (int) hash;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int cnt = 0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int h = get_hash(str);
			if(sum-cookie[h] < cookie[h]) cnt++;
			sum++;
			cookie[h]++;
		}
		System.out.println(cnt);
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2751 {
	static final int plus = 1_000_000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean is_in[] = new boolean[2_000_001];
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			is_in[tmp + plus] = true;
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<2_000_001;i++) {
			if(cnt == N) break;
			if(is_in[i]) {
				sb.append((i-plus)).append("\n");
				cnt++;
			}
		}
		System.out.println(sb);
	}
}

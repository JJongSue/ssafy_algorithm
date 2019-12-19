package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14002 {
	static int parents[];
	static Stack<Integer> stack = new Stack<>();
	static int map[], dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[N];
		dp = new int[N];
		parents = new int[N];
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			parents[i] = i;
		}
		int max = -1, max_i=-1;
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(map[i] > map[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					parents[i] = j;
				}
			}
			if(max < dp[i]) {
				max = dp[i];
				max_i = i;
			}
		}
		System.out.println(max);
		while(parents[max_i] != max_i) {
			stack.add(max_i);
			max_i = parents[max_i];
		}
		stack.add(max_i);
		while(!stack.isEmpty()) {
			System.out.print(map[stack.pop()]+" ");
			
		}
		
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String cmd;
		boolean arr[] = new boolean[21];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if(cmd.charAt(0) == 'a') {
				if(cmd.charAt(1) == 'd') {
					int num = Integer.parseInt(st.nextToken());
					arr[num] = true;
				}else {
					for(int j=1;j<=20;j++) {
						arr[j] = true;
					}
				}
			}else if(cmd.charAt(0) == 'r') {
				int num = Integer.parseInt(st.nextToken());
				arr[num] = false;
			}else if(cmd.charAt(0) == 't') {
				int num = Integer.parseInt(st.nextToken());
				arr[num] = !arr[num];
			}else if(cmd.charAt(0) == 'e') {
				arr = new boolean[21];
			}else if(cmd.charAt(0) == 'c') {
				int num = Integer.parseInt(st.nextToken());
				sb.append(arr[num] ? 1 : 0).append("\n");
			}
		}
		System.out.println(sb);
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
	static int L, C;
	static boolean is_visit[] = new boolean[26];
	static char arr[];
	static char ans[];
	static ArrayList<Integer> aeiou = new ArrayList<>();
	static ArrayList<Integer> not = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = new char[L];
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		for(int i=0;i<C;i++) {
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || 
					arr[i] == 'o' || arr[i] == 'u' ) aeiou.add(i);
			else not.add(i);
		}
		select_num(0, 0, 0);
		System.out.println(sb);
		
		
	}
	static void start(int now) {
		
	}
	static void select_num(int now, int ae, int cnt) {
		if(cnt == L ) {
			if( ae >= 1 && cnt-ae >= 2 ) {
				for(int i=0;i<L;i++) {
					sb.append(ans[i]);
				}sb.append("\n");
			}
			return;
		}
		if(now == C) return;
		ans[cnt] = arr[now];
		if(arr[now] == 'a' || arr[now] == 'e' || arr[now] == 'i' || 
				arr[now] == 'o' || arr[now] == 'u' ) select_num(now+1, ae+1, cnt+1);
		else select_num(now+1, ae, cnt+1);
		
		select_num(now+1, ae, cnt);
	}
}

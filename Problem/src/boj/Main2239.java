package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2239 {
	static int s[][] = new int[9][9];
	static int ans[][] = new int[9][9];
	static boolean is_ans = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				s[i][j] = str.charAt(j) - '0';
			}
		}
		find_num(0);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				System.out.print(s[i][j]);
			System.out.println();
		}
		
	}
	
	static void find_num(int now) {
		if(is_ans) return;
		if(now == 81) {
			is_ans = true;
			return;
		}
		if(s[now/9][now%9] != 0) {
			find_num(now+1);
			return;
		}
//		System.out.println("now : "+now);
		boolean is_num[] = new boolean[10];
		for(int i=0;i<9;i++) {
			is_num[s[i][(now%9)]] = true;
			is_num[s[(now/9)][i]] = true;
			
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				is_num[s[(now/27)*3+i][(now%9)/3*3+j]] = true;
			}
		}
		for(int i=1;i<10;i++) {
			if(!is_num[i]) {
//				System.out.println(now + " " + i);
				s[now/9][now%9] = i;
				find_num(now+1);
				if(is_ans) return;
				s[now/9][now%9] = 0;
			}
		}
		
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12174 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++ ) {
			int N = Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			sb.append("Case #").append(tc).append(": ");
			for(int i=0;i<N;i++) {
				int a=0;
				for(int j=0;j<8;j++) {
					a = a<<1;
					if(tmp.charAt(i*8+j) == 'I') a+=1;
				}
				sb.append((char)a);				
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}

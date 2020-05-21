package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9093 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int size = st.countTokens();
			
			for(int j=0;j<size;j++) {
				String str = st.nextToken();
				for(int k=str.length()-1;k>=0;k--) sb.append(str.charAt(k));
				if(j != size-1) sb.append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
}

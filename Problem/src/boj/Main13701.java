package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main13701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();
		int size = st.countTokens();
		for(int i=0;i<size;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(!hs.contains(tmp)) {
				hs.add(tmp);
				//System.out.print(tmp+" ");
				bw.write(tmp+" ");
			}
		}
		bw.flush();
	}
}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8771 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long N = Long.parseLong(st.nextToken());
			Long A = Long.parseLong(st.nextToken());
			Long B = Long.parseLong(st.nextToken());
			if(A.compareTo(B) > 0) sb.append("#").append(tc).append(" ").append(0).append("\n"); 
				//System.out.println("#"+tc+" "+0);
			else if(N==1) {
				if(A.compareTo(B) == 0) sb.append("#").append(tc).append(" ").append("1").append("\n"); 
					//System.out.println("#"+tc+" "+1);
				else sb.append("#").append(tc).append(" ").append("0").append("\n"); 
					//System.out.println("#"+tc+" "+0);
			}else if(N==2) {
				sb.append("#").append(tc).append(" ").append(1).append("\n");
			}else {
				sb.append("#").append(tc).append(" ").append(((B-A)*(N-2)+1)).append("\n");
				//System.out.println("#"+tc+" "+((B-A)*(N-2)+1));
			}
		}
		System.out.println(sb);
		
	}
}

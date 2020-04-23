package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11722_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(N == 1) {
			System.out.println(1);
		}else {			
			ArrayList<Integer> dp = new ArrayList<>();
			dp.add(Integer.parseInt(st.nextToken()));
			for(int i=1;i<N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
//				if(dp.get(0) < tmp) {
//					dp.set(0, tmp);
//					continue;
//				}
				if(dp.get(dp.size()-1) > tmp) {
					dp.add(tmp);
					continue;
				}
				for(int j=0;j<dp.size();j++) {
					if(dp.get(j) <= tmp) {
						dp.set(j, tmp);
						break;
					}
				}
				
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println(dp.size());
		}
		
	}
}

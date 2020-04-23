package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11055 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(N == 1) {
			System.out.println(Integer.parseInt(st.nextToken()));
		}else {			
			ArrayList<Integer> dp = new ArrayList<>();
			int map[] = new int[N];
			dp.add(Integer.parseInt(st.nextToken()));
			int ans = dp.get(0);
			for(int i=1;i<N;i++) {
				int tmp = Integer.parseInt(st.nextToken());
//				if(dp.get(0) < tmp) {
//					dp.set(0, tmp);
//					continue;
//				}
				if(dp.get(dp.size()-1) < tmp) {
					dp.add(tmp);
					continue;
				}
				for(int j=0;j<dp.size();j++) {
					if(dp.get(j) >= tmp) {
						dp.set(j, tmp);
						int sum = 0;
						for(int k=0;k<=j;k++) {
							
						}
						break;
					}
				}
				
			}
			System.out.println(dp.toString());
			System.out.println(dp.size());
		}
		
	}
}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution5658 {
	static HashMap<String, Boolean> hm;
	static ArrayList<String> al;
	static ArrayList<Integer> ansal1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int div = N/4;
			hm = new HashMap<>();
			al = new ArrayList<>();
			char map[] = br.readLine().toCharArray();
			//String map = br.readLine();
			for(int s=0;s<=div;s++) {
				char last = map[N-1];
				for(int i=N-1;i>0;i--) {
					map[i] = map[i-1];
				}
				map[0] = last;
				for(int i=0;i<4;i++) {
					String tmp = "";
					for(int j=0;j<div;j++) {
						tmp += map[div*i+j];
					}
					if(!hm.containsKey(tmp)) {
						hm.put(tmp, true);
						al.add(tmp);
					}
				}
			}
			ArrayList<Long> ansal = new ArrayList<>();
			ansal1 = new ArrayList<>();
			//System.out.println(al);
			for(String tmp : al) {
				long one = 1;
				int input = 0;
				for(int i=div-1;i>=0;i--) {
					if(tmp.charAt(i) >= '0' && tmp.charAt(i) <= '9') {
						input += (one*(tmp.charAt(i)-'0'));
					}else {
						input += (one*(tmp.charAt(i)-'A'+10));
					}
					one*=16;
				}
				ansal1.add(input);
			}
			ansal1.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}

				
			});
//			System.out.println(ansal1);
			System.out.println("#"+tc+" "+ansal1.get(M-1));
			
		}
		
	}
}

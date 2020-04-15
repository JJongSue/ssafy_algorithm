package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2568 {
	static class pair implements Comparable<pair>{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
	}
	static int N;
	static pair arr[];
	static int mem[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new pair[N];
		mem = new int[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new pair(x, y);
		}
		Arrays.sort(arr);
		ArrayList<pair> dp = new ArrayList<pair>();
		dp.add(arr[0]);
		mem[0] = 1;
		
		for(int i=1;i<N;i++) {
			if(arr[i].y > dp.get(dp.size()-1).y) {
				dp.add(arr[i]);
				mem[i] = dp.size();
			}else {
				int l = 0, r = dp.size()-1;
				while(l<=r) {
					int mid = (l+r)/2;
					if(dp.get(mid).y > arr[i].y) {
						r = mid-1;
					}else if(dp.get(mid).y < arr[i].y) {
						l = mid+1;
					}else {
						l = mid;
						break;
					}
				}
				dp.set(l, arr[i]);
				mem[i] = l+1;
			}
		}
		int tmp = dp.size();
		Stack<Integer> ans = new Stack<Integer>();
		//System.out.println(Arrays.toString(mem));
//		for(int i=0;i<N;i++) {
//			System.out.println(arr[i].x+" "+arr[i].y);
//		}
		for(int i=N-1;i>=0;i--) {
			if(mem[i] == tmp) {
				tmp--;
			}else {
				ans.add(arr[i].x);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(N-dp.size()).append("\n");
		while(!ans.isEmpty()) {
			sb.append(ans.pop()).append("\n");
			//System.out.println(ans.pop());
			//sb.append(arr[ans.pop()].x).append("\n");
		}
		System.out.println(sb);
		
		
	}
}

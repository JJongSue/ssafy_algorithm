package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2798 {
	static int N, M, ans=0;
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			al.add(tmp);
		}
		al.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
		find(0, 0, 0);
		System.out.println(ans);
	}
	static void find(int now, int cnt, int sum) {
		if(ans == M) return;
		if(cnt == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		if(now == al.size()) return;
		
		if(al.get(now) + sum > M) return;
		find(now+1, cnt+1, sum+al.get(now));
		find(now+1, cnt, sum);
	}
	
}

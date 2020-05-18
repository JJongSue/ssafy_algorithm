package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2294 {
	static int N, K;
	static ArrayList<Integer> al = new ArrayList<>();
	static boolean is_visit[] = new boolean[100_001];
	static int ans[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = new int[K+1];
		for(int i=1;i<=K;i++) ans[i] = K+1;
		ans[0] = 0;
		
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(!is_visit[tmp] && tmp <= K) {
				al.add(tmp);
				is_visit[tmp] = true;
				ans[tmp] = 1;
			}
		}
		
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		for(int i=0;i<al.size();i++) {
			int tmp = al.get(i);
			for(int j=0;j+tmp<=K;j++) {
				ans[j+tmp] = Math.min(ans[j]+1, ans[j+tmp]);
			}
		}
		
		if(ans[K] == K+1) System.out.println(-1);
		else System.out.println(ans[K]);
	}
}

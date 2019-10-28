package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution4050 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
			});
			long ans = 0;
			if(N % 3 == 0) {				
				for(int i=0;i<N;i++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
				while(!pq.isEmpty())
				{
					ans += pq.poll();
					ans += pq.poll();
					pq.poll();
					//System.out.println(pq.poll());
				}
			}else if(N%3 == 1){
				for(int i=0;i<N;i++) {					
					pq.add(Integer.parseInt(st.nextToken()));
				}
				while(pq.size() != 1)
				{
					ans += pq.poll();
					ans += pq.poll();
					pq.poll();
				}
				ans+=pq.poll();				
			}else {							
				for(int i=0;i<N;i++) {					
					pq.add(Integer.parseInt(st.nextToken()));
				}
				while(pq.size() != 2)
				{
					ans += pq.poll();
					ans += pq.poll();
					pq.poll();
				}
				ans+=pq.poll();
				ans+=pq.poll();
			}
			System.out.println("#"+tc+" "+ans);
			
			
		}
	}
}

package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution1251kru {
	static int[][] xy;
	static class island implements Comparable<island>
	{
		int x;
		int y;
		long level;
		public island(int x, int y, long level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}
		@Override
		public int compareTo(island o) {
			// TODO Auto-generated method stub
			if(this.level > o.level) return 1;
			else if(this.level < o.level) return -1;
			return 0;
		}
		
	}
	static int find_set(int x)
	{
		if(arr[x] == x) return x;
		else {
			return x=find_set(arr[x]);
		}
	}
	static void union(int x, int y)
	{
		int px = find_set(x);
		int py = find_set(y);
		if(px != py)
		{
			arr[py]=px;
		}
		find_set(y);
	}
	static int[] arr;
	static PriorityQueue<island> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			xy = new int[N][2];
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) xy[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				xy[i][1] = Integer.parseInt(st.nextToken());
				arr[i]=i;
			}
			pq = new PriorityQueue<>();
			for(int i=0;i<N;i++)
			{
				for(int j=i+1;j<N;j++)
				{
					long disx = xy[i][0]-xy[j][0];
					long disy = xy[i][1]-xy[j][1];
					pq.add(new island(i, j, disx*disx+disy*disy));
					
				}
			}
			long ans = 0;
			while(!pq.isEmpty())
			{
				island tmp = pq.poll();
				if(find_set(tmp.x) != find_set(tmp.y))
				{
					union(tmp.x, tmp.y);
					ans+=tmp.level;
				}
				int cnt=0;
				for(int i=0;i<N;i++)
				{
					if(arr[i] == i) cnt++;
					if(cnt>1) break;
				}
				if(cnt ==1)	break;
			}
			
			double s = Double.parseDouble(br.readLine());

			System.out.println("#"+tc+" "+(Math.round(ans*s)));
			
		}
	}
}

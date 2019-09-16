package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimPQ {
	static class dis implements Comparable<dis>{
		int dot;
		long level;
		public dis(int dot, long level) {
			super();
			this.dot = dot;
			this.level = level;
		}
		@Override
		public int compareTo(dis o) {
			// TODO Auto-generated method stub
			if(this.level-o.level > 0) return 1;
			else if(this.level-o.level<0) return -1;
			return  0;
		}		
	}
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
	static int [][]xy;
	static PriorityQueue<dis> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc = 1; tc<=T;tc++)
		{
			int N = Integer.parseInt(br.readLine());
			xy = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) xy[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) xy[i][1] = Integer.parseInt(st.nextToken());
			long [][]map = new long[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=i+1;j<N;j++)
				{
					long disx = xy[i][0]-xy[j][0];
					long disy = xy[i][1]-xy[j][1];
					map[i][j]=disx*disx+disy*disy;
					map[j][i]=disx*disx+disy*disy;
					if(map[i][j]<0) {
						map[i][j] = 0;
						map[j][i] = 0;
					}
				}
			}
			pq = new PriorityQueue<>();
			boolean []is_visit = new boolean[N];
			is_visit[0]=true;
			ArrayList<Integer> ans_cnt = new ArrayList<>();
			ans_cnt.add(0);
			for(int i=1;i<N;i++)
			{
				if(map[0][i] != 0) pq.add(new dis(i, map[0][i]));
			}
			long ans = 0;
			while(ans_cnt.size()<N)
			{
				dis tmp = pq.poll();
				if(!is_visit[tmp.dot])
				{
					ans_cnt.add(tmp.dot);
					is_visit[tmp.dot]=true;
					ans+=tmp.level;
					for(int i=0;i<N;i++)
					{
						if(!is_visit[i] && map[tmp.dot][i] != 0)
						pq.add(new dis(i, map[tmp.dot][i]));
					}
				}				
			}
			double s = Double.parseDouble(br.readLine())*10;
			long ss = 0;
			ans*=s;
			if(ans%10>=5) ss=1;
			System.out.println("#"+tc+" "+(long)(ans/10+ss));
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

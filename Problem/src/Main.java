import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] point = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		point[] p = new point[N];
		for(int i=0; i<N; i++) {
			int sight = Integer.parseInt(st.nextToken());
			if(sight==1)
				point[i] = true;
			p[i] = new point(new ArrayList<Integer>(), new HashMap<Integer, Integer>(), 0, i);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if((a!=N-1 && b!=N-1) && (point[a] || point[b]))
				continue;
			p[a].nearlist.add(b);
			p[a].time.put(b, t);
			p[b].nearlist.add(a);
			p[b].time.put(a, t);
		}
		
		int[] time = new int[N];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		Queue<point> queue = new LinkedList<>();
		queue.add(p[N-1]);
		point pp;
		while(!queue.isEmpty()) {
			pp = queue.poll();
			if(pp.curtime >= time[0])
				continue;
			if(pp.curtime > time[pp.idx])
				continue;
			for(int i : pp.nearlist) {
				if(time[i] > pp.time.get(i) + pp.curtime) {
					time[i] = pp.curtime + pp.time.get(i);
					if(i==0)
						continue;
					queue.add(new point(p[i].nearlist, p[i].time, pp.curtime + pp.time.get(i), i));
				}
			}
		}
		if(time[0]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(time[0]);
		
		//System.out.println(Integer.MAX_VALUE);
	}
	static class point{
		ArrayList<Integer> nearlist;
		Map<Integer, Integer> time;
		int curtime;
		int idx;
		public point(ArrayList<Integer> nearlist, Map<Integer, Integer> time, int curtime, int idx) {
			this.nearlist = nearlist;
			this.time = time;
			this.curtime = curtime;
			this.idx = idx;
		}
	}
}
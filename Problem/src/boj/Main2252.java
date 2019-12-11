package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2252 {
	static int linecnt[];
	static boolean is_visit[];
	

	static class ArrayList{
		int list[];
		int now=0;
		int size=2;
		public ArrayList() {
			super();
			list = new int[size];
			// TODO Auto-generated constructor stub
		}

		void add(int num) {
			if(now == size) {
				int tmp[] = new int[size];
				for(int i=0;i<size;i++) {
					tmp[i] = list[i];					
				}			
				int tmpsize = size;
				size = size+(size/2);
				list = new int[size];
				for(int i=0;i<tmpsize;i++) {
					list[i] = tmp[i];					
				}
				
			}			
			list[now++] = num;
		}
		int get(int num) {
			return list[num];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		ArrayList[] al = new ArrayList[N+1];
		linecnt = new int[N+1];
		is_visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++) al[i] = new ArrayList();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int tmps = Integer.parseInt(st.nextToken());
			int tmpe = Integer.parseInt(st.nextToken());
			al[tmps].add(tmpe);
			linecnt[tmpe]++;
		}
		ArrayList mylist = new ArrayList();			
		for(int i=1;i<=N;i++) {
			if(linecnt[i] == 0) {
				mylist.add(i);
				is_visit[i] = true;
				sb.append(i).append(" ");
			}
		}
		
		for(int i=0;i<mylist.now;i++) {
			int now = mylist.get(i);
			for(int j=0;j<al[now].now;j++) {
				int find = al[now].get(j);
				linecnt[find]--;
				if(linecnt[find] == 0 && !is_visit[find] ) {
					mylist.add(find);
					sb.append(find).append(" ");
					is_visit[find] = true;
				}
			}
		}
		sb.append("\n");
		System.out.println(sb);
	
	}

}

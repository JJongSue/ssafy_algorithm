package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main7662 {
	static PriorityQueue<Integer> mpq = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> ppq = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
		
	});	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int size = 0;
			int N = Integer.parseInt(br.readLine());
			for(int c=0;c<N;c++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if(cmd.charAt(0) == 'I') {
					int tmp = Integer.parseInt(st.nextToken());
					ppq.add(tmp);
					mpq.add(tmp);
					size++;
				}else{
					if(size == 0) continue;
					if(Integer.parseInt(st.nextToken()) == 1) {
						int tmp = mpq.peek();
						while(tmp )
						ppq.poll();
					}else {
						mpq.poll();
					}
					size--;
					if(size == 0) {
						ppq.clear();
						mpq.clear();
					}
				}
			}
			if(size == 0) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(ppq.peek()).append(" ").append(mpq.peek()).append("\n");
			}
			ppq.clear();
			mpq.clear();
		}
		System.out.println(sb);
	}

}

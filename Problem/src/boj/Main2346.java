package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2346 {
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public pair() {
			super();
			// TODO Auto-generated constructor stub
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<pair> al = new ArrayList<>();
		LinkedList<pair> ll = new LinkedList<>();		
		for(int i=0;i<N;i++) al.add(new pair(i+1,Integer.parseInt(st.nextToken())));
		StringBuilder sb = new StringBuilder();
		int now = 0;
		while(!al.isEmpty()) {
			pair tmp = al.get(now);
			al.remove(now);
			if(tmp.y > 0) now--;
			//if(tmp.y < 0) now--;
			//else if(tmp.y > 0) now--;
			
			sb.append(tmp.x).append(" ");
			//System.out.println(tmp.x);
			now += tmp.y;
			
			while(now >= al.size()) {
				now -= al.size();
				if(al.isEmpty()) break;
			}
			while(0 > now) {
				now += al.size();
				if(al.isEmpty()) break;
			}
			
		}
		System.out.println(sb);
		
	}
}

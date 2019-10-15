package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3190 {
	static final int dx[] = {1,0,-1,0};
	static final int dy[] = {0,1,0,-1};
	static int N;
	static class pair{
		int x;
		int y;
		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		ArrayList<pair> apple = new ArrayList<>();
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			apple.add(new pair(x,y));			
		}
		int L = Integer.parseInt(br.readLine());
		int mt[] = new int[L];
		char mr[] = new char[L];
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			mt[i] = Integer.parseInt(st.nextToken());
			mr[i] = st.nextToken().charAt(0);
			//System.out.println(mr[i]);
		}
		boolean is_end = false;
		ArrayList<pair> snack = new ArrayList<>();
		snack.add(new pair(1, 1));
		int rotate = 0;
		//rotate가 R이면 +1 l이면 -1 그크기가 ==4이면 0 -1=> 3
		int time=0;
		int Liter = 0;
		end: while(true) {
			int x = snack.get(0).x;
			int y = snack.get(0).y;
			int xx = x+dx[rotate];
			int yy = y+dy[rotate];
			//System.out.println(xx+" "+yy+" "+time);
			if(xx == 0 || yy == 0 || xx == N+1 || yy == N+1) {
				//System.out.println(xx+" "+yy);
				break;
			}
			for(int i=0;i<snack.size();i++) {
				if(xx == snack.get(i).x && yy == snack.get(i).y ) {
					//System.out.println("end2");
					break end;
				}
			}
			time++;
			boolean is_eat = false;
			for(int i=0;i<apple.size();i++) {
				if(apple.get(i).x == xx && apple.get(i).y == yy) {
					//System.out.println(snack.size());
					is_eat = true;
					Queue<pair> q = new LinkedList<pair>();
					q.add(new pair(xx, yy));
					q.addAll(snack);
					snack.clear();
					snack.addAll(q);
					apple.remove(i);
					break;
				}
			}
			if(!is_eat) {
				Queue<pair> q = new LinkedList<pair>();
				q.add(new pair(xx, yy));
				for(int i=0;i<snack.size()-1;i++) {
					q.add(snack.get(i));
				}
				snack.clear();
				snack.addAll(q);
			}
			if(Liter < L ) {
				if(mt[Liter] != time) continue;
				//System.out.println(time);
				if(mr[Liter] == 'D') {
					//System.out.println("rotateD");
					rotate++;
					if(rotate==4) rotate=0;
				}
				else if(mr[Liter] == 'L') {
					rotate--;
					if(rotate==-1) rotate=3;
				}
				Liter++;				
			}
			
			
			
			
		}
		System.out.println(time+1);
	}
	
	static boolean is_over(int x, int y) {
		if(x < 0 || y < 0 || x>=N || y>=N) return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

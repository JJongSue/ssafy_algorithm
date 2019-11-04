package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2174 {
	//동 서 남 북
	static final int dx[] = {0,1,0,-1};
	static final int dy[] = {-1,0,1,0};
	static int N, M, Rcnt, Ccnt;
	static ArrayList<robot> r2b2;
	static class robot{
		int x;
		int y;
		int r;
		public robot(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		public robot() {
			super();
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Rcnt = Integer.parseInt(st.nextToken());
		Ccnt = Integer.parseInt(st.nextToken());
		r2b2 = new ArrayList<>();
		r2b2.add(new robot(0, 0, 0));
		for(int i=0;i<Rcnt;i++) {
			st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = N-1-(Integer.parseInt(st.nextToken())-1);
			String s = st.nextToken();
			if(s.equals("N")) r2b2.add(new robot(a, b, 0));
			else if(s.equals("E")) r2b2.add(new robot(a, b, 1));
			else if(s.equals("S")) r2b2.add(new robot(a, b, 2));
			else if(s.equals("W")) r2b2.add(new robot(a, b, 3));			
		}
		boolean is_end = false;
		end:for(int i=0;i<Ccnt;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String cmd = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			if(cmd.equals("F")) {
				for(int s=0;s<b;s++) {					
					if(is_map(r2b2.get(a).x+dx[r2b2.get(a).r], r2b2.get(a).y+dy[r2b2.get(a).r])) {
						for(int find=1;find<=Rcnt;find++) {
							if(find == a) continue;
							if(r2b2.get(a).x+dx[r2b2.get(a).r] == r2b2.get(find).x && r2b2.get(a).y+dy[r2b2.get(a).r] == r2b2.get(find).y) {
								System.out.println("Robot "+a+" crashes into robot "+find);
								//System.out.println((r2b2.get(a).x+dx[r2b2.get(a).r])+ " " +(r2b2.get(a).y+dy[r2b2.get(a).r]));
								is_end = true;
								break end;
							}
						}
						r2b2.get(a).x += dx[r2b2.get(a).r];
						r2b2.get(a).y += dy[r2b2.get(a).r];
					}else {
						System.out.println("Robot "+a+" crashes into the wall");
						is_end = true;
						break end;
					}
				}
			}else if(cmd.equals("R")) {
				for(int s=0;s<b;s++) {
					r2b2.get(a).r = rr(r2b2.get(a).r);					
				}
			}else if(cmd.equals("L")) {
				for(int s=0;s<b;s++) {					
					r2b2.get(a).r = ll(r2b2.get(a).r);
				}
			}			
		}
		if(!is_end) System.out.println("OK");
		
		
		
	}
	static boolean is_map(int x, int y) {
		if(x < 0 || y < 0 || x >= M || y>=N) return false;
		return  true;
	}
	static int rr(int x) {
		int dx = x+1;
		if(dx == 4) dx = 0;
		return dx;
	}
	static int ll(int x) {
		int dx = x-1;
		if(dx == -1) dx = 3;
		return dx;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

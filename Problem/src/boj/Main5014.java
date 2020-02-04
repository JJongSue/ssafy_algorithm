package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5014 {
	static int F,S,G,U,D;
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean is_visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		
		if(S == G) {
			System.out.println(0);
		}else {
			int cnt = 1;
			boolean is_ok = false;
			q.add(S);
			is_visit = new boolean[F+1];
			is_visit[S] = true;
			
			end:while(!q.isEmpty()) {
				int size = q.size();
				for(int s=0;s<size;s++) {
					int tmp = q.poll();
					if(tmp+U == G || tmp-D == G) {
						is_ok = true;
						break end;
					}
					if(tmp+U <= F && !is_visit[tmp+U]) {
						is_visit[tmp+U] = true;
						q.add(tmp+U);
					}
					
					if(tmp-D > 0 && !is_visit[tmp-D]) {
						is_visit[tmp-D] = true;
						q.add(tmp-D);
					}
				}
				cnt++;
			}
			
			
			if(is_ok) System.out.println(cnt);
			else System.out.println("use the stairs");
		}
	}
}

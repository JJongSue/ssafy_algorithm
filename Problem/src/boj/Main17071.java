package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17071 {
	static boolean is_visit[];
	static Queue<Integer> su = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su1 = sc.nextInt();
		int b = sc.nextInt();
		if(su1 == b) System.out.println(0);
		else {
			int K = 1;
			int ans = -1;
			su.add(su1);
			end: while(b <= 500000 && ans == -1) {
				b += K;
				is_visit = new boolean[500001];
				int size = su.size();
				for(int s=0;s<size;s++) {
					int tmp = su.poll();
					if(tmp+1 <=500000 && !is_visit[tmp+1]) {
						if(b == tmp+1) {
							ans = K;
							break end;
						}
						is_visit[tmp+1] = true;
						su.add(tmp+1);
					}
					if(tmp-1 >= 0 && !is_visit[tmp-1]) {
						if(b == tmp-1) {
							ans = K;
							break end;
						}
						is_visit[tmp-1] = true;
						su.add(tmp-1);
					}
					
					if(tmp*2 <=500000 && !is_visit[tmp*2]) {
						if(b == tmp*2) {
							ans = K;
							break end;
						}
						is_visit[tmp*2] = true;
						su.add(tmp*2);
					}
					
				}	
				
				K++;
			}
			
			System.out.println(ans);
		}
	}
}

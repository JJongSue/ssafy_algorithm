package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main18235 {
	static boolean is_visit[];
	static Queue<Integer> aq, bq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		aq = new LinkedList<Integer>();
		bq = new LinkedList<Integer>();
		aq.add(A);
		bq.add(B);
		if(A == B) {
			System.out.println(0);
		}else {
			int day = 1;
			int ansday = 1;
			int ans = -1;
			end:while(!aq.isEmpty() && !bq.isEmpty()) {
				int size = aq.size();
				is_visit = new boolean[N+1];
				for(int s=0;s<size;s++) {
					int tmp = aq.poll();
					if(tmp+day <= N && tmp+day > 0) {
						aq.add(tmp+day);
						is_visit[tmp+day] = true;
					}
					if(tmp-day <= N && tmp-day > 0) {
						aq.add(tmp-day);
						is_visit[tmp-day] = true;
					}
				}
				size = bq.size();
				for(int s=0;s<size;s++) {
					int tmp = bq.poll();
					if(tmp+day <= N && tmp+day > 0) {
						bq.add(tmp+day);
						if(is_visit[tmp+day])
						{
							ans = ansday;
							break end;
						}
					}
					if(tmp-day <= N && tmp-day > 0) {
						bq.add(tmp-day);
						if(is_visit[tmp-day])
						{
							ans = ansday;
							break end;
						}
					}
				}
				day *= 2;
				ansday++;
			}
			System.out.println(ans);
			
		}
	}
}

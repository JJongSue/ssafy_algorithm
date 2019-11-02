package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1038 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<ArrayList<Long>> al = new ArrayList<ArrayList<Long>>();
		al.add(new ArrayList<Long>());
		//ArrayList<Long> al = new ArrayList<Long>();
		for(Long i=(long) 0;i<10;i++) {
			al.get(0).add(i);
		}
		int ten = 10;
		int cnt = 10;
		int iter = 1;
		long ans = -1;
		if(N<10) {
			System.out.println(al.get(0).get(N));
		}else {
			end:while(cnt <= N) {
				al.add(new ArrayList<Long>());
				int size= al.get(iter-1).size();
				for(int i=1;i<=9;i++) {
					for(int j=0;j<size;j++) {
						if(i > al.get(iter-1).get(j)/(ten/10)) {
							al.get(iter).add((i*ten)+al.get(iter-1).get(j) );
							
							if(cnt == N) {
								ans = (i*ten)+al.get(iter-1).get(j);
								break end;
							}
							cnt++;
						}else break;
					}
				}
				ten *=10;
				//cnt++;
				iter++;
			}
			System.out.println(ans);
		}
		
		
		
		
		
	}
}

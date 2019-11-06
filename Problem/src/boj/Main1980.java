package boj;

import java.util.Scanner;

public class Main1980 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		int c = Integer.MAX_VALUE;
		
		int anssum=0;
		if(N > M) {
			int tmp = T/M;
			
			int ansn,ansm, ansc=Integer.MAX_VALUE;
			int tmpn,tmpm,tmpc;
			
			for(int i=tmp;i>=0;i--) {
				tmpm=i;
				tmpn=(T-(tmpm*M))/N;
				tmpc = (T-(tmpm*M))%N;
				if(tmpc >= 0 && ansc>tmpc) {
					anssum = tmpn+tmpm;
					ansc=tmpc;
				}else if(ansc==tmpc) {
					if(anssum < tmpn+tmpm) anssum=tmpn+tmpm;
				}
			}
			System.out.println(anssum+" "+ansc);
		}else {
			int tmp = T/N;
			
			int ansn,ansm, ansc=Integer.MAX_VALUE;
			int tmpn,tmpm,tmpc;
			
			for(int i=tmp;i>=0;i--) {
				tmpn=i;
				tmpm=(T-(tmpn*N))/M;
				tmpc = (T-(tmpn*N))%M;
				if(tmpc>=0&&ansc>tmpc) {
					anssum = tmpn+tmpm;
					ansc=tmpc;
				}else if(ansc==tmpc) {
					if(anssum < tmpn+tmpm) anssum=tmpn+tmpm;
				}
			}
			System.out.println(anssum+" "+ansc);
		}
	}
}

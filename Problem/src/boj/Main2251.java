package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2251 {
	static int A, B, C;
	static boolean map[][][];
	static boolean ans[];
	static class dot{
		int a;
		int b;
		int c;
		public dot(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	static Queue<dot> q = new LinkedList<dot>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		map = new boolean[A+1][B+1][C+1];
		ans = new boolean[C+1];
//		ans[A] = true;
//		ans[B] = true;
		ans[C] = true;
		q.add(new dot(0, 0, C));
		map[0][0][C] = true;
		while(!q.isEmpty()) {
			int a = q.peek().a;
			int b = q.peek().b;
			int c = q.poll().c;
			
			//A => b, A=>c
			if(B >= a+b) {
				if(!map[0][a+b][c]) {
					q.add(new dot(0,a+b,c));
					map[0][a+b][c] = true;
					ans[c] = true;
				}
			}else {
				if(!map[(a+b)-B][B][c]) {
					q.add(new dot((a+b)-B, B, c));
					map[(a+b)-B][B][c] = true;
					if(a+b-B == 0) ans[c] = true;
//					ans[(a+b)-B] = true;
				}
			}
			
			if(C >= a+c) {
				if(!map[0][b][a+c]) {
					q.add(new dot(0,b,a+c));
					map[0][b][a+c] = true;
					ans[a+c] = true;
				}
			}else {
				if(!map[(a+c)-C][b][C]) {
					q.add(new dot((a+c)-C, b, C));
					map[(a+c)-C][b][C] = true;
//					ans[(a+c)-C] = true;
				}
			}
			
			//B=>a, B=>c
			if(A >= a+b) {
				if(!map[a+b][0][c]) {
					q.add(new dot(a+b,0,c));
					map[a+b][0][c] = true;
					if(a+b == 0) ans[c] = true;
//					ans[a+b] = true;
				}
			}else {
				if(!map[A][(a+b)-A][c]) {
					q.add(new dot(A, (a+b)-A, c));
					map[A][(a+b)-A][c] = true;
//					ans[(a+b)-A] = true;
				}
			}
			
			if(C >= b+c) {
				if(!map[a][0][b+c]) {
					q.add(new dot(a,0,b+c));
					map[a][0][b+c] = true;
//					ans[b+c] = true;
					if(a==0) ans[b+c] = true;
				}
			}else {
				if(!map[a][(b+c)-C][C]) {
					q.add(new dot(a, (b+c)-C, C));
					map[a][(b+c)-C][C] = true;
//					ans[(b+c)-C] = true;
				}
			}
			
			//C => a, C=>b
			if(A >= a+c) {
				if(!map[a+c][b][0]) {
					q.add(new dot(a+c,b,0));
					map[a+c][b][0] = true;
					if(a+c == 0) ans[0] = true;
//					ans[a+c] = true;
				}
			}else {
				if(!map[A][b][(a+c)-A]) {
					q.add(new dot(A, b ,(a+c)-A));
					map[A][b][(a+c)-A] = true;
//					ans[(a+c)-A] = true;
				}
			}
			
			if(B >= b+c) {
				if(!map[a][b+c][0]) {
					q.add(new dot(a,b+c,0));
					map[a][b+c][0] = true;
//					ans[b+c] = true;
					if(a==0) ans[0] = true;
				}
			}else {
				if(!map[a][B][(b+c)-B]) {
					q.add(new dot(a,B,(b+c)-B));
					map[a][B][(b+c)-B] = true;
					if(a==0) ans[(b+c)-B] = true;
				}
			}
			
			
			
			
			
		}
		for(int i=0;i<=C;i++) if(ans[i]) System.out.print(i+" ");
		
	}
}

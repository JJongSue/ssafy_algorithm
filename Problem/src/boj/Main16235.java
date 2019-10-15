package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main16235 {
	static final int dx[] = {-1,0,1,-1,1,-1,0,1};
	static final int dy[] = {-1,-1,-1,0,0,1,1,1};
	static int N, M, K;
	static int A[][];
	static int nut[][];
	static PriorityQueue<tree> pq;	
	static Queue<tree> deadQ, make;
	static class tree implements Comparable<tree>{
		int x;
		int y;
		int age;
		public tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(tree o) {
			// TODO Auto-generated method stub
			return this.age-o.age;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N][N];
		nut = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(nut[i], 5);
			for(int j=0;j<N;j++) {
				A[i][j] = sc.nextInt();
			}
		}
		pq = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			int a = sc.nextInt();
			pq.add(new tree(x, y, a));
			//if(a <= 5) {
				
			//}
		}
		for(int i=0;i<K;i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(pq.size());
		
		
	}
	
	static void spring() {
		PriorityQueue<tree> q = new PriorityQueue<>();
		
		deadQ = new LinkedList<tree>();
		make = new LinkedList<tree>();
		while(!pq.isEmpty()) {
			tree tmp = pq.poll();
			if(nut[tmp.y][tmp.x]-tmp.age < 0) {
				deadQ.add(tmp);
				continue;
			}
			nut[tmp.y][tmp.x] -= tmp.age;
			tmp.age++;
			if(tmp.age%5 == 0) make.add(tmp);
			q.add(tmp);
		}
		pq = q;
		//pq.addAll(q);
		//q.clear();
	}
	static void summer() {
		while(!deadQ.isEmpty()) {
			tree tmp = deadQ.poll();
			nut[tmp.y][tmp.x] += (tmp.age/2); 
		}
	}
	static void fall() {
		while(!make.isEmpty()) {
			tree tmp = make.poll();
			for(int i=0;i<8;i++) {
				int xx = tmp.x+dx[i];
				int yy = tmp.y+dy[i];
				if(is_map(xx, yy)) {
					pq.add(new tree(xx, yy, 1));
				}
			}
		}
	}
	static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				nut[i][j] += A[i][j];
			}
		}
	}
	
	static boolean is_map(int x, int y) {
		if(x < 0 || y<0 || x>=N || y>=N) return false;
		return true;
	}

}

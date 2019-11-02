package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main14718 {
	static class tri{
		int x;
		int y;
		int z;
		public tri(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<tri> pqx = new PriorityQueue<tri>(new Comparator<tri>() {

			@Override
			public int compare(tri o1, tri o2) {
				int sum1 = o1.x+o1.y+o1.z;
				int sum2 = o2.x+o2.y+o2.z;
				if(o1.x == o2.x) {
					return sum1-sum2;
				}
				return o1.x-o2.x;
				/*if(sum1 == sum2) {
					return o1.x - o2.x;
				}
				return sum1-sum2;*/
			}
		});
		PriorityQueue<tri> pqy = new PriorityQueue<tri>(new Comparator<tri>() {

			@Override
			public int compare(tri o1, tri o2) {
				int sum1 = o1.x+o1.y+o1.z;
				int sum2 = o2.x+o2.y+o2.z;
				if(o1.y == o2.y) {
					return sum1-sum2;
				}
				return o1.y-o2.y;
				/*if(sum1 == sum2) {
					return o1.y - o2.y;
				}
				return sum1-sum2;*/
			}
		});
		PriorityQueue<tri> pqz = new PriorityQueue<tri>(new Comparator<tri>() {

			@Override
			public int compare(tri o1, tri o2) {
				int sum1 = o1.x+o1.y+o1.z;
				int sum2 = o2.x+o2.y+o2.z;
				if(o1.z == o2.z) {
					return sum1-sum2;
				}
				return o1.z-o2.z;
				/*if(sum1 == sum2) {
					return o1.z - o2.z;
				}
				return sum1-sum2;*/
			}
		});
		PriorityQueue<tri> pqs = new PriorityQueue<tri>(new Comparator<tri>() {

			@Override
			public int compare(tri o1, tri o2) {
				int sum1 = o1.x+o1.y+o1.z;
				int sum2 = o2.x+o2.y+o2.z;
				
				/*f(sum1 == sum2) {
					return o1.z - o2.z;
				}*/
				return sum1-sum2;
			}
		});
		for(int i=0;i<N;i++) {
			tri tmp = new tri(sc.nextInt(), sc.nextInt(), sc.nextInt());
			pqx.add(tmp);
			pqy.add(tmp);
			pqz.add(tmp);
			pqs.add(tmp);
		}
		tri px = new tri(0, 0, 0);
		tri py = new tri(0, 0, 0);
		tri pz = new tri(0, 0, 0);
		tri ps = new tri(0, 0, 0);
		int xx = 0;
		int xy = 0;
		int xz = 0;
		int yx = 0;
		int yy = 0;
		int yz = 0;
		int zx = 0;
		int zy = 0;
		int zz = 0;
		for(int i=0;i<M;i++) {
			px.x = Math.max(px.x, pqx.peek().x);
			px.y = Math.max(px.y, pqx.peek().y);
			px.z = Math.max(px.z, pqx.peek().z);
			py.x = Math.max(py.x, pqy.peek().x);
			py.y = Math.max(py.y, pqy.peek().y);
			py.z = Math.max(py.z, pqy.peek().z);
			pz.x = Math.max(pz.x, pqz.peek().x);
			pz.y = Math.max(pz.y, pqz.peek().y);
			pz.z = Math.max(pz.z, pqz.peek().z);
			ps.x = Math.max(ps.x, pqs.peek().x);
			ps.y = Math.max(ps.y, pqs.peek().y);
			ps.z = Math.max(ps.z, pqs.peek().z);
			pqx.poll();
			pqy.poll();
			pqz.poll();
			pqs.poll();
		}
		//px = pqx.poll();
		//py = pqy.poll();
		//pz = pqz.poll();
		
		int sum = px.x+px.y+px.z;
		int tmp = py.x+py.y+py.z;
		sum = Math.min(sum, tmp);
		tmp = pz.x+pz.y+pz.z;
		sum = Math.min(sum, tmp);
		tmp = ps.x+ps.y+ps.z;
		sum = Math.min(sum, tmp);
		System.out.println(sum);
		
	}
}

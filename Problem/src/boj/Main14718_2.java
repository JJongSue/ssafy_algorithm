package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main14718_2 {
	static class tri implements Comparable<tri>{
		int x;
		int y;
		int z;
		public tri(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(tri o) {
			// TODO Auto-generated method stub
			return this.z -o.z;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		tri [] arr = new tri[N];

		for(int i=0;i<N;i++) {
			arr[i] = new tri(sc.nextInt(), sc.nextInt(), sc.nextInt());

		}
		Arrays.sort(arr);
		int sum = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt = 0;
				for(int k=0;k<N;k++) {
					if(arr[i].x >= arr[k].x && arr[j].y >= arr[k].y) cnt++;
					if(cnt == M) {
						sum = Math.min(sum, arr[i].x+arr[j].y+arr[k].z);
						break;
					}
				}
			}
		}

		System.out.println(sum);

		
		
	}
}

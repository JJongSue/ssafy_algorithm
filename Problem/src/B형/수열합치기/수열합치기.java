package B형.수열합치기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수열합치기 {
	static int map[][];
	static int first, last;
	static int arrnums;
	static void init() {
		map = new int[1_000_001][3];
		first = -1;
		last = -1;
		arrnums = 0;
	}
	static void mergenums(int n, int []arr) {
		int arr0 = arr[0];
		int size = arrnums;
		for(int i=0;i<n;i++) {
			map[arrnums][0] = arr[i];
			map[arrnums][1] = arrnums+1;
			map[arrnums][2] = arrnums-1;
			arrnums++;
		}
		if(first == -1 && last == -1) {
			first = 0;
			last = n-1;
			return;
		}
		if(arr0 == 1) {
			map[first][2] = size;
			map[arrnums-1][1] = first;
			first = size;
			return;
		}
		for(int i=0;i<size;i++) {
			if(map[i][0] > arr[0]) {
				if(i == 0) {
					first = size;
					map[arrnums-1][1] = 0;
					map[0][2] = size;
					return;
				}
				map[size][2] = i-1;
				map[arrnums-1][1] = i;
				map[i][2] = arrnums-1;
				map[i-1][1] = size;
				
				return;
			}
		}
		map[size][2] = last;
		map[last][1] = size;
		last = arrnums-1;

		
	}
	static int findkth(int kth) {
		if(kth < 0) {
			kth++;
			kth = kth * (-1);
			kth = kth % arrnums;
			int now = last;
			for(int i=0;i<kth;i++) {
				if(now == -1) now = last;
				now = map[now][2];
			}
			if(now == -1) {
				return map[last][0];
			}
			return map[now][0];
		}
		kth--;
		kth = kth % arrnums;
		int now = first;
		for(int i=0;i<kth;i++) {
			now = map[now][1];
		}
		
		return map[now][0];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		int ars[] = {2,3,4,5};
		mergenums(4, ars);
		ars = new int[4];
		int ars1[] = {4,8,7,6};
		mergenums(4, ars1);
		int ars2[] = {9,10,15,16};
		mergenums(4, ars1);
		
		int ars3[] = {1,2,6,5};
		mergenums(4, ars3);
		System.out.println(arrnums);
		for(int i=1;i<=arrnums;i++) {
			System.out.println(findkth(i));
		}
		
//		System.setIn(new FileInputStream("src/B형/수열합치기/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		boolean fail = false;
//		int totalscore = 0;
//		int score = 100;
//		for(int tc=1;tc<=T;tc++) {
//			//System.out.println(tc);
//			int cmd = Integer.parseInt(br.readLine());
//			//System.out.println(cmd);
//			init();
//			for(int c=0;c<cmd;c++) {
//				
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				char ch = st.nextToken().charAt(0);
//				if(ch == 'M') {
//					int size = Integer.parseInt(st.nextToken());
//					int tmpar[] = new int[size];
//					for(int al=0;al<size;al++) {
//						tmpar[al] = Integer.parseInt(st.nextToken());
//					}
//					mergenums(size, tmpar);
//				}else {
//					int kth = Integer.parseInt(st.nextToken());
//					int tans = Integer.parseInt(st.nextToken());
//					if(findkth(kth) != tans) fail = true;
//					System.out.println(findkth(kth)+" "+tans);
//					//System.out.println(arrnums);
////					int cnt = st.countTokens();
////					for(int cc=0;cc<cnt;cc++) {
////						int kth = Integer.parseInt(st.nextToken());
////						//System.out.println(findkth(kth));						
////					}
////					System.out.println();
//				}
//			}
//			if(fail) System.out.println("#"+tc+" 0");
//			else {
//				System.out.println("#"+tc+" 100");
//				totalscore += score;
//			}
////			for(int i=0;i<arrnums;i++) {
////				System.out.print(map[i][0] + " ");
////			}System.out.println();
//		}
//		System.out.println("Total score = "+totalscore / T);
////		init();
////		int tmp[] = {1, 2, 3, 4, 5};
////		mergenums(5, tmp);
////		int[] tmp2 =  {3, 4, 5};
////		mergenums(3, tmp2);
////		//for(int i=0;i<8;i++) System.out.println(map[i][0]);
////		Scanner sc = new Scanner(System.in);
////		while(true) {
////			System.out.println(findkth(sc.nextInt()));
////			
////		}
//		
//		/*for(int i=0;i<10;i++) {
//			
//			System.out.println(map[last][0]);
//			last = map[last][2];
//		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

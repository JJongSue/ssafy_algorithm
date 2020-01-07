package B형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				now = map[now][2];
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int cmd = Integer.parseInt(br.readLine());
			for(int c=0;c<cmd;c++) {
				init();
				StringTokenizer st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				if(ch == 'M') {
					int size = Integer.parseInt(st.nextToken());
					int tmpar[] = new int[size];
					for(int al=0;al<size;al++) {
						tmpar[al] = Integer.parseInt(st.nextToken());
					}
				}else {
					int cnt = st.countTokens();
					for(int cc=0;cc<cnt;cc++) {
						int kth = Integer.parseInt(st.nextToken());
						System.out.println(findkth(kth));						
					}
				}
			}
		}
//		init();
//		int tmp[] = {1, 2, 3, 4, 5};
//		mergenums(5, tmp);
//		int[] tmp2 =  {3, 4, 5};
//		mergenums(3, tmp2);
//		//for(int i=0;i<8;i++) System.out.println(map[i][0]);
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			System.out.println(findkth(sc.nextInt()));
//			
//		}
		
		/*for(int i=0;i<10;i++) {
			
			System.out.println(map[last][0]);
			last = map[last][2];
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

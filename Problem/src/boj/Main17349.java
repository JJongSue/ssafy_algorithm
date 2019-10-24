package boj;

import java.util.Scanner;

public class Main17349 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[10][2];
		for(int i=0;i<9;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int map[] = new int[9];
		boolean is_true =true;
		boolean is_one = true;
		int ans = -1;
		for(int i=0;i<9;i++) {
			
			map = new int[9];
			is_true =true;
			if(arr[i][0] == 0) arr[i][0] =1;
			else arr[i][0] =0;
			for(int j=0;j<9;j++) {				
				if(arr[j][0] == 0) { 
					if(map[arr[j][1]-1] != 1) {
						map[arr[j][1]-1] = -1;
					}else {
						is_true = false;
						break;
					}					
				}else {
					if(map[arr[j][1]-1] != -1) {
						map[arr[j][1]-1] = 1;
					}else {
						is_true = false;
						break;
					}
				}
			}
			if(arr[i][0] == 0) arr[i][0] =1;
			else arr[i][0] =0;			
			if(is_true) {
				int zero = -1;
				int one = -1;
				int minus_cnt = 0;
				int one_cnt = 0;
				int zero_cnt = 0;
				for(int j=0;j<9;j++) {
					if(map[j] == 0) {
						zero_cnt++;
						zero = j;
					}else if(map[j] == 1) {
						one=j;
						one_cnt++;
					}else {
						minus_cnt++;
					}					
				}
				if(one_cnt == 0 && minus_cnt < 8) {
					ans = -1;
					break;
				}
				else if(zero_cnt == 1 && minus_cnt == 8 ) {
					if(!is_one && ans != zero+1) {
						ans = -1;
						break;												
					}
					ans = zero+1; 
					is_one = false;
				}else if(one_cnt == 1) {
					if(!is_one && ans != one+1) {
						ans = -1;
						break;
					}
					ans = one+1;
					is_one = false;
				}
				
			}
		}
		System.out.println(ans);
	}
}

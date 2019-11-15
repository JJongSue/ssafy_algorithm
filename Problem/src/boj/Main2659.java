package boj;

import java.util.Scanner;

public class Main2659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[4];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		int min = 10000;
		for(int i=0;i<4;i++) {
			int tmp = 1000*arr[0]+100*arr[1]+10*arr[2]+arr[3];
			min = Math.min(tmp, min);
			tmp = arr[0];
			for(int s=0;s<3;s++) {
				arr[s]=arr[s+1];
			}
			arr[3]=tmp;
		}
		//System.out.println(min);
		int ans=0;
		end:for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				for(int k=1;k<=9;k++) {
					for(int l=1;l<=9;l++) {
						arr[0] = i;
						arr[1] = j;
						arr[2] = k;
						arr[3] = l;
						int min1 = 10000;
						int firstnum = 1000*arr[0]+100*arr[1]+10*arr[2]+arr[3];
						for(int it=0;it<4;it++) {
							int tmp = 1000*arr[0]+100*arr[1]+10*arr[2]+arr[3];
							min1 = Math.min(tmp, min1);
							tmp = arr[0];
							for(int s=0;s<3;s++) {
								arr[s]=arr[s+1];
							}
							arr[3]=tmp;
						}
						if(firstnum == min1) {
							ans++;
						}
						if(min1 == min) {
							break end;
						}
					}
				}
			}
		}
		
		
		
		 /*for(int i=1000;i<10000;i++) {	
			int j = 1000;
			int tmp = i;
			boolean is_go = true;			
			while(j>1) {
				if(tmp/j == 0) {
					is_go = false;
					break;
				}
				else {
					tmp%=j;
					j/=10;
				}
				
			}
			if(min<=i) break;
			if(tmp == 0) continue;
			if(!is_go) continue;
			System.out.println(i);
			ans++;			
		}*/
		System.out.println(ans);
	}
}

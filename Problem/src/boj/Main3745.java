package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main3745 {
	//static ArrayList<Integer> lis;
	static int arr[] = new int[100_001];
	static int lis[] = new int[100_001];
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int N = sc.nextInt();//Integer.parseInt(br.readLine());
			//StringTokenizer st = new StringTokenizer(br.readLine());
			int lnow = 0;
			arr[0] = sc.nextInt();//Integer.parseInt(st.nextToken());
			lis[0] = arr[0];
			for(int i=1;i<N;i++) {
				arr[i] = sc.nextInt();//Integer.parseInt(st.nextToken());
				if(arr[i] > lis[lnow]) {
					lis[++lnow] = arr[i];
					continue;
				}
				int l = 0, r=lnow;
				while(l<=r) {
					int mid = (l+r)/2;
					if(lis[mid] > arr[i]) {
						r = mid-1;
					}else if(lis[mid] < arr[i]) {
						l = mid+1;
					}else {
						l = mid;
						break;
					}
				}
				lis[l] = arr[i];
			}
			System.out.println(lnow+1);
		}
		
		
		
		
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main4198 {
	static int N;
	static int arr[];
	//static ArrayList<Integer> dp = new ArrayList<Integer>();
	static int lis[], lds[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		lis = new int[N+1];
		lds = new int[N+1];
		int max = 0;
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
		//dp.add(arr[0]);
		lis[0] = 1;
		
		for(int i=0;i<N;i++) {
			int inow = 0;
			int dnow = 0;
			lis = new int[N];
			lds = new int[N];
			lis[0] = arr[i];
			lds[0] = arr[i];
			for(int j=i+1;j<N;j++) {
				if(arr[i] < arr[j]) {
					if(lis[inow] < arr[j]) {
						lis[++inow] = arr[j];
						continue;
					}
					int l = 0, r = inow;
					while(l<=r) {
						int mid = (l+r)/2;
						if(lis[mid] > arr[j]) {
							r = mid-1;
						}else {
							l = mid+1;
						}
					}
					
					lis[l] = arr[j];
					//inow++;
					
					
				}else {
					if(lds[dnow] > arr[j]) {
						lds[++dnow] = arr[j];
						continue;
					}
					int l = 0, r = dnow;
					while(l<=r) {
						int mid = (l+r)/2;
						if(lds[mid] < arr[j]) {
							r = mid-1;
						}else {
							l = mid+1;
						}
					}
					
					lds[l] = arr[j];
					//dnow++;
				}
			}
			max = Math.max(max, inow+dnow+1);
//			System.out.println(Arrays.toString(lis));
//			
//			System.out.println(Arrays.toString(lds));
//			System.out.println(inow + " " + dnow);
		}
		
		
		
//		System.out.println(Arrays.toString(lis));
//		
//		System.out.println(Arrays.toString(lds));
		
		System.out.println(max);
	}
}

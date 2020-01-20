package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {
	static int N;
	static int arr[];
	static void QuickSort(int l, int r) {
		if(l == r) return;
		if(l == r-1) {
			if(arr[r] < arr[l]) {
				int tmp = arr[r];
				arr[r] = arr[l];
				arr[l] = tmp;
			}
			return;
		}
		int mid = (l+r)/2;
		if(arr[mid] < arr[l]) {
			int tmp = arr[mid];
			arr[mid] = arr[l];
			arr[l] = tmp;
		}
		if(arr[mid] < arr[r]) {
			int tmp = arr[mid];
			arr[mid] = arr[r];
			arr[r] = tmp;
		}
		int left = l+1;
		int right = r-1;
		while(true) {
			while(left < r) {
				if(arr[r] <= arr[left]) {
					break;
				}
				left++;
			}
			while(l < right) {
				if(arr[right] < arr[r]) {
					break;
				}
				right--;
			}
			if(right <= left) break;
			int tmp = arr[right];
			arr[right] = arr[left];
			arr[left] = tmp;
		}
		int tmp = arr[left];
		arr[left] = arr[r];
		arr[r] = tmp;
		
		QuickSort(l, left-1);
		QuickSort(left, r);
		
		
		
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		QuickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
//		for(int i=0;i<M;i++) {
//			
//		}
		
	}
}

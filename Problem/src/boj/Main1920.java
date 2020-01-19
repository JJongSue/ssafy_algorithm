package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {
	static int arr[];
	static void QuickSort(int left, int right) {
		//System.out.println(left + " " + right);
		if(left == right) return;
		if(right == left - 1) {
			if(arr[left] > arr[right]) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
			return;
		}
		int pivot = (left + right) / 2;
//		if(arr[left] < arr[pivot] && arr[pivot] < arr[right]) {
//			int tmp = arr[right];
//			arr[right] = arr[pivot];
//			arr[pivot] = tmp;
//		}else if(arr[left] < arr[pivot] && arr[pivot] < arr[right]) {
//			
//		}
		if(arr[pivot] < arr[left]) {
			int tmp = arr[left];
			arr[left] = arr[pivot];
			arr[pivot] = tmp;
		}
		if(arr[pivot] < arr[right]) {
			int tmp = arr[right];
			arr[right] = arr[pivot];
			arr[pivot] = tmp;
		}
		int r = right - 1;
		int l = left;
		
		while(true) {
			while(l < right) {
				if(arr[l] > arr[right]) break;
				l++;
			}
			while(left <= r) {
				if(arr[r] < arr[right]) break;
				r--;
			}
			if(r < l) break;
			//System.out.println(Arrays.toString(arr));
			int tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
		int tmp = arr[right];
		arr[right] = arr[l];
		arr[l] = tmp;
		//System.out.println(Arrays.toString(arr));
		if(left<l-1) QuickSort(left, l-1);
		if(l+1<right) QuickSort(l+1, right);
		
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		QuickSort(0, N-1);
		//System.out.println(Arrays.toString(arr));
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			boolean is_true = false;
			
			int l = 0;
			int r = N-1;
			
			while(l<=r) {
				int mid = (l+r) / 2;
				if(arr[mid] == find) {
					is_true = true;
					break;
				}
				if(arr[mid] < find) {
					l = mid+1;
				}else {
					r = mid-1;
				}
				
			}
			if(is_true) sb.append(1).append("\n");
			else sb.append(0).append("\n");
			
		}
		System.out.println(sb);
		
	}
}

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
		if(arr[r] < arr[mid]) {
			int tmp = arr[mid];
			arr[mid] = arr[r];
			arr[r] = tmp;
		}
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
		QuickSort(left+1, r);
		
		
		
		
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
		int arr2[][] = new int[N][2];
		int now = 0;
		arr2[now][0] = 1;
		arr2[now][1] = arr[0];
		for(int i=1;i<N;i++) {
			if(arr2[now][1] == arr[i]) arr2[now][0]++;
			else {
				arr2[++now][0] = 1;
				arr2[now][1] = arr[i];
			}
		}
		//System.out.println(Arrays.toString(arr));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			int cnt = 0;
			int tmp = Integer.parseInt(st.nextToken());
			int l = 0, r = now;
			boolean is_have = false;
			while(l <= r) {
				int mid = (l+r) / 2;
				if(arr2[mid][1] == tmp) {
					
					sb.append(arr2[mid][0]).append(" ");
					is_have = true;
					break;
				}
				if(arr2[mid][1] < tmp) {
					l = mid+1;
				}else r = mid-1;
			}
			if(!is_have) sb.append(0).append(" ");
			
		}
		System.out.println(sb);
		
	}
}

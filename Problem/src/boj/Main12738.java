package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main12738 {
	static int arr[];
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		al.add(arr[0]);
		for(int i=1;i<N;i++) {
			if(arr[i] == al.get(al.size()-1)) continue;
			else if(arr[i] > al.get(al.size()-1)) {
				al.add(arr[i]);
				continue;
			}
			int l = 0, r = al.size()-1;
			while(l<=r) {
				int mid = (l+r)/2;
				if(al.get(mid) > arr[i]) {
					r = mid-1;
				}else if(al.get(mid) < arr[i]) {
					l = mid+1;
				}else {
					l = mid;
					break;
				}
			}
			al.set(l, arr[i]);
		}
		System.out.println(al.size());
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10815 {
	//가진 카드를 저장하는 arr과 개수를 저장하는 N
	static int[] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//N과 arr을 입력받음
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		//arr을 이진탐색하기위해 arr을 sort시킴
		Arrays.sort(arr);
		
		//M과 카드를 입력받고 결과를 sb에 넣음
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int find_num = Integer.parseInt(st.nextToken());
			boolean tmp = is_have(0, N-1, find_num);
			if(tmp) sb.append("1").append(" ");
			else sb.append("0").append(" ");
		}
		System.out.println(sb);
		
	}
	
	//찾으려는 수를 이분탐색으로 찾음
	static boolean is_have(int left, int right, int find_num) {
		//left가 right보다 크면 false return
		if(left > right) return false;
		
		int mid = (left+right)/2;
		if(arr[mid] == find_num) return true;
		else if(arr[mid] > find_num) return is_have(left, mid-1, find_num);
		else return is_have(mid+1, right, find_num);
	}
}

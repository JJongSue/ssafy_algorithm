package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11279 {
	static class pq{
		int arr[] = new int[100_002];
		
		
		public pq() {
			super();
			arr[0] = 1;
		}
		void add(int input) {
			int now = arr[0];
			arr[now] = input;
			while(now/2 >= 1) {
				if(arr[now/2] > arr[now]) {
					break;	
				}
				int tmp = arr[now/2];
				arr[now/2] = arr[now];
				arr[now] = tmp;
				now = now/2;
			}
			arr[0]++;
			
		}
		int poll() {
			if(arr[0] == 1) return 0;
			int peek = arr[1];
			arr[1] = arr[arr[0]-1];
			arr[0]--;
			int now = 1;
			while((now<<1) < arr[0]) {
				int ch = (now<<1);
				if(ch+1 < arr[0] && arr[ch] < arr[ch+1]) {
					ch++;
				}
				if(arr[ch] < arr[now]) {
					break;
				}
				int tmp = arr[ch];
				arr[ch] = arr[now];
				arr[now] = tmp;
				now = ch;
				
			}
			
			
			return peek;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pq pq = new pq();
		StringBuilder sb = new StringBuilder();
		for(int cmd = 0;cmd<N;cmd++) {
			int c = Integer.parseInt(br.readLine());
			if(c == 0) {
				sb.append(pq.poll()).append("\n");
//				for(int i=0;i<6;i++) {
//					System.out.println(pq.arr[i]);
//				}
			}else {
				pq.add(c);
			}
		}
//		for(int i=0;i<6;i++) {
//			System.out.println(pq.arr[i]);
//		}
		System.out.println(sb);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

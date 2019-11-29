package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			int sum = 0;
			double avg = 0;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			avg = sum/N;
			//System.out.println(avg);
			double NN = N;
			double cnt = 0;
			for(int i=0;i<N;i++) {
				if(avg < arr[i]) {
					cnt++;
					//System.out.println("되는겨");
				}
			}
			double be = (cnt/N)*100;
			System.out.printf("%.3f", be);
			System.out.println("%");
			//System.out.println(avg);
		}
	}
}

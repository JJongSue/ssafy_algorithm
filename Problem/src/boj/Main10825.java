package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10825 {
	static class grade{
		String name;
		int a;
		int b;
		int c;
		public grade(String name, int a, int b, int c) {
			super();
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}
	static grade arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new grade[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i] = new grade(name, a, b, c);
		}
		Arrays.sort(arr, new Comparator<grade>() {

			@Override
			public int compare(grade o1, grade o2) {
				if(o1.a == o2.a) {
					if(o1.b == o2.b) {
						if(o1.c == o2.c) {
							return o1.name.compareTo(o2.name);
						}
						return o2.c - o1.c;						
					}
					return o1.b - o2.b;
					
				}
				return o2.a - o1.a;
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i].name).append("\n");
		}
		System.out.println(sb);
		
	}
}

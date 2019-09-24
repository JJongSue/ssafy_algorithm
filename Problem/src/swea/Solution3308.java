package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution3308 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N + 1][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				arr[i][0] = Integer.parseInt(st.nextToken());
			if (N == 1)
				System.out.println("#" + tc + " " + 1);
			else {
				int ans = 0;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(0);
				al.add(arr[1][0]);
				arr[1][1] = 1;
				for (int i = 2; i <= N; i++) {
					int max = 1;
					if (al.get(al.size() - 1) <= arr[i][0]) {
						max = al.size();
					} else {
						max = binary_search(0, al.size() - 1, al, arr[i][0]);
						//System.out.println(max);
					}
					/*
					 * for(int j=0;j<al.size();j++) { if(al.get(j) >= arr[i][0]) break; max = j+2; }
					 */

					arr[i][1] = max;
					ans = Math.max(max, ans);
					if (al.size() == max) {
						al.add(arr[i][0]);
					} else if (al.size() > max) {
						if (al.get(max) > arr[i][0])
							al.set(max, arr[i][0]);

					}
				}
				System.out.println("#" + tc + " " + ans);
			}

		}
	}

	static int binary_search(int start, int end, ArrayList<Integer> al, int find_num) {
		//System.out.println(start+" "+end);
		int middle = (start + end) / 2;
		if(start > end) return start;
		/*if(end-start == 1) {
			if(al.get(end) < find_num) return start;
			return end;
		}*/
		if (al.get(middle) > find_num) {
			return binary_search(start, middle-1, al, find_num);
		} else if(al.get(middle) < find_num) {
			return binary_search(middle+1, end, al, find_num);
		}
		 else { 
			 int tmp = middle;
			 while(tmp < al.size() && tmp != find_num) {
				 tmp++;
			 }return tmp;
		  
		  
		  }
		 
		// return 0;
	}

}

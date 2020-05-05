
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] br = { -1, 1, 0, 0 };
	static int[] bc = { 0, 0, -1, 1 };
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				answer = Math.max(map[i][j], answer);
			}
		}
		
//		left(0, 0, map);
//		right(0,0,map);
		up(0,0,map);
//		down(0,0,map);
		System.out.println(answer);
	}
	static int answer;
	public static void left(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			answer = Math.max(answer, max);
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =0; 
			int j =0;
			int next =1; 
			while(j<N) {
				if(next>=N) {
					tmp[i][idx]=arr[i][j];
					max = Math.max(max, tmp[i][idx]);
					break;
//					j++; 
//					continue; 
				}
				if(arr[i][j]==0) {
					j++; 
					next = j+1; 
					continue;
				}
				else if(arr[i][j]==arr[i][next]) {
					tmp[i][idx]=arr[i][j]+arr[i][next];
					max = Math.max(max, tmp[i][idx]);
					idx++;
					j=next+1; 
					next = j+1; 
				}else if(arr[i][next]==0) {
					next++; 
				}else {// 다를 때  
					tmp[i][idx]=arr[i][j];
					max = Math.max(max, tmp[i][idx]);
					idx++;
					j++; 
					next= j+1; 
				}
			}
		}
		System.out.println("left "+cnt);
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	public static void right(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			answer = Math.max(answer, max);
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =N-1; 
			int j = N-1; 
			int next = j-1; 
			while(j>=0) {
				if(next<0) {
					tmp[i][idx]=arr[i][j];
					max = Math.max(max, tmp[i][idx]);
					break;
//					j--; 
//					continue; 
				}
				if(arr[i][j]==0) {
					j--;
					next = j-1; 
					continue; 
				}
				if(arr[i][j]==arr[i][next]) {
					tmp[i][idx]=arr[i][j]+arr[i][next];
					max = Math.max(max, tmp[i][idx]);
					idx--;
					j=next-1; 
					next = j-1; 
				}else if(arr[i][next]==0) {
					next--; 
				}else { 
					tmp[i][idx]=arr[i][j];
					max = Math.max(max, tmp[i][idx]);
					idx--;
					j--; 
					next= j-1;  
				}
			}
		}
		System.out.println("right "+cnt);
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	public static void up(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			answer = Math.max(answer, max);
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =0; 
			int j = 0; 
			int next = 1; 
			while(j<N) {
				if(next>=N) {
					tmp[idx][i]= arr[j][i];
					max = Math.max(max, tmp[idx][i]);
					break;
//					j++;
//					continue;
				}
				if(arr[j][i]==0) {
					j++; 
					next = j+1; 
					continue;
				}
				 if(arr[j][i]==arr[next][i]) {
					tmp[idx][i]= arr[j][i]+arr[next][i];
					max = Math.max(max, tmp[i][idx]);
					idx++; 
					j=next+1; 
					next = j+1; 
				}
				else if(arr[next][i]==0) {
					next++; 
				}else { 
					tmp[idx][i]=arr[j][i];
					max = Math.max(max, tmp[idx][i]);
					idx++;
					j++; 
					next= j+1; 
				}
				
			}
		}
		System.out.println("up "+cnt);
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
	
	public static void down(int cnt, int max, int[][]arr) {
		if(cnt==5) {
			answer = Math.max(answer, max);
			return; 
		}
		int[][] tmp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int idx =N-1; 
			int j = N-1; 
			int next = j-1; 
			while(j>=0) {
				if(next<0) {
					tmp[idx][i]=arr[j][i];
					max = Math.max(max, tmp[idx][i]);
					break;
//					j--;
//					continue;
//					break;
				}
				if(arr[j][i]==0) {
					j--; 
					next = j-1; 
					continue; 
				}
				else if(arr[j][i]==arr[next][i]) {
					tmp[idx][i]=arr[j][i]+arr[next][i];
					max = Math.max(max, tmp[idx][i]);
					idx--;
					j=next-1; 
					next = j-1; 
				}else if(arr[next][i]==0) {
					next--; 
				}else { 
					tmp[idx][i]=arr[j][i];
					max = Math.max(max, tmp[idx][i]);
					idx--;
					j--; 
					next= j-1; 
				}
			}
		}
		System.out.println("down "+cnt);
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		left(cnt+1,max, tmp);
		right(cnt+1,max, tmp);
		up(cnt+1,max,tmp);
		down(cnt+1,max,tmp);
	}
}
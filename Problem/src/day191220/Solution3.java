package day191220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//숫자선물
/*내일은 현승이의 생일이다! 돈이 드는 선물은 준비하기 힘들고,

생색을 내기 위해 은지는 N 이하의 양의 정수를 하나 선물하기로 했다.

은지는 숫자 x와 y를 좋아하기 때문에, 선물하는 수를 x와 y로 이루어진 수로 만들고 싶다.

(x 또는 y로 수를 만들거나, x, y 모두 사용하여 수를 만들 수 있음)

선물하는 것이 가능한 정수 중에서 가장 큰 수를 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 N, x, y(1 ≤ N ≤ 10^100,000, 0 ≤ x < y ≤ 9)가 공백 하나로 구분되어 주어진다.

N은 0으로 시작하지 않는다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 선물할 수 있는 수 중에서 가장 큰 수를 출력한다.

만약 선물할 수 있는 수가 없으면, -1을 출력한다.



4
16 1 3
2 6 9
5 0 8
422223324 2 4


[Sample out]


#1 13
#2 -1
#3 -1
#4 422222444

 * 
 * 
 */
public class Solution3 {
	static String Ntmp;
	static char[] cmap;
	static String ans="";
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			
			sb.append('#').append(tc).append(' ');
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ntmp = st.nextToken();
			cmap = Ntmp.toCharArray();
			ans = "";
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char xx = (char) (x+'0');
			char yy = (char) (y+'0');
			boolean is_zero = true;
			if(xx == '0' && cmap[0] < yy) {
				if(cmap.length>=2) {
					for(int i=1;i<cmap.length;i++) {
						sb.append(yy);
					}
				}else sb.append("-1");
			}else if(cmap[0] < xx) {
				if(cmap.length>=2) {
					for(int i=1;i<cmap.length;i++) {
						sb.append(yy);
					}
				}else sb.append("-1");
			}else if(cmap[0] > yy){
				for(int i=0;i<cmap.length;i++) sb.append(yy);
			}else {
				boolean is_dis = false;
				boolean is_minus = false;
				int go_dis = -1;
				char ansmap[] = new char[cmap.length];
				for(int i=0;i<cmap.length;i++) {
					if(cmap[i] > yy) {
						for(int j=0;j<i;j++) sb.append(ansmap[j]);
						for(int j=i;j<cmap.length;j++) sb.append(yy);
						is_minus = true;
						break;
					}
					else if(cmap[i] == yy) {
						is_dis = true;
						go_dis = i;
						ansmap[i] = yy;		
						
					}
					else if(cmap[i] > xx && cmap[i]<yy) {
						ansmap[i] = xx;
						for(int j=0;j<i;j++) sb.append(ansmap[j]);
						sb.append(xx);
						for(int j=i+1;j<cmap.length;j++) sb.append(yy);
						is_minus = true;
						break;
						
					}else if(cmap[i] == xx) {
						ansmap[i] = xx;
					}
					else if(cmap[i] < xx) {
						if(is_dis) {
							for(int j=0;j<go_dis;j++) sb.append(ansmap[j]);
							sb.append(xx);
							for(int j=go_dis+1;j<cmap.length;j++) sb.append(yy);
							is_minus = true;
							break;
						}else {
							
							if(cmap.length>=2) {
								for(int j=1;j<cmap.length;j++) {
									sb.append(yy);
								}
							}else sb.append("-1");
							is_minus = true;
							break;
						}
					}
					
				}
				if(!is_minus) {
					for(int i=0;i<cmap.length;i++) {
						sb.append(ansmap[i]);
					}
				}
			}
			
			
			sb.append("\n");
			/*
			while(is_zero) {
				//for(int i=0;i<cmap.length;i++) System.out.print(cmap[i]);
				//System.out.println();
				for(int i=cmap.length-1;i>=max_v;i--) {
					if(cmap[i] == '1' && max_v==cmap.length-1) {
						is_zero = false;
						break;
					}
					else if(cmap[i] == '1' && i==max_v) {
						cmap[i] = '0';
						max_v = find_max_v();												
						break;
					}
					else if(cmap[i] == '0') {
						cmap[i] = '9';
					}else {
						cmap[i]--;
						break;
					}
				}
				ans += yy;  
			}*/
			//System.out.println("#"+tc+" "+ans);
		}
		System.out.println(sb);
		
		
	}
	static int find_max_v() {
		for(int i=0;i<cmap.length;i++) {
			if(cmap[i] != '0') return i;
		}
		return 0;
	}
}

package swea;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution3378 {
	public static void main(String[] args) {
		int prime[] = {2,3,5,7,11,13,17,19};				
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int master[][] = new int[p][4];
			int me[][] = new int[q][4];
			int map[] = new int[3];
			Arrays.fill(map, -1);
			String tmp = sc.next();
			//System.out.println(tmp);
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i) == '(') master[0][0]++;
				else if(tmp.charAt(i) == '{') master[0][1]++;
				else if(tmp.charAt(i) == '[') master[0][2]++;
				else if(tmp.charAt(i) == ')') master[0][0]--;
				else if(tmp.charAt(i) == '}') master[0][1]--;
				else if(tmp.charAt(i) == ']') master[0][2]--;
			}
			for(int i=1;i<p;i++) {
				tmp = sc.next();				
				master[i][0] = master[i-1][0];
				master[i][1] = master[i-1][1];
				master[i][2] = master[i-1][2];
				int j = 0;
				int dotcnt = 0;
				while(j<tmp.length() && tmp.charAt(j)=='.')
				{
					dotcnt++;
					j++;
				}
				master[i-1][3]=dotcnt;
				for(int k=j;k<tmp.length();k++) {
					if(tmp.charAt(k) == '(') master[i][0]++;
					else if(tmp.charAt(k) == '{') master[i][1]++;
					else if(tmp.charAt(k) == '[') master[i][2]++;
					else if(tmp.charAt(k) == ')') master[i][0]--;
					else if(tmp.charAt(k) == '}') master[i][1]--;
					else if(tmp.charAt(k) == ']') master[i][2]--;
				}
			}
			for(int i=0;i<p;i++) {
				if(map[0] != -1 && map[1]!=-1 && map[2] != -1) break;				
				if(master[i][0] == 0 && master[i][1] == 0 && master[i][2] == 0 ) continue;
				for(int j=0;j<3;j++) {
					if(map[j] != -1 && master[i][j] != 0) {
						master[i][3] -= map[j]*master[i][j];
						master[i][j]=0;
					}
				}int sum =0;
				for(int j=0;j<3;j++) {
					sum+=master[i][j];
				}
				if(sum == master[i][3] && sum!=0) {
					for(int j=0;j<3;j++) {
						if(map[j] == -1 && master[i][j] != 0) map[j] = 1;
					}
					continue;
				}
				sum = 0;
				for(int j=0;j<3;j++) {
					sum+=master[i][j]*20;
				}
				
				if(master[i][3] == sum) {
					for(int j=0;j<3;j++) {
						if(map[j] == -1 && master[i][j] != 0) map[j] = 20;
					}
					continue;
				}
				if(map[0] == -1 && master[i][0] != 0 && master[i][1] == 0 && master[i][2] == 0) {
					map[0] = master[i][3]/master[i][0];
				}else if(map[1] == -1 && master[i][0] == 0 && master[i][1] != 0 && master[i][2] == 0) {
					map[1] = master[i][3]/master[i][1];
				}else if(map[2] == -1 && master[i][0] == 0 && master[i][1] == 0 && master[i][2] != 0) {
					map[2] = master[i][3]/master[i][2];
				}
			}
			for(int i=0;i<p;i++) {

				//System.out.println(Arrays.toString(master[i]));
				if(map[0] != -1 && map[1]!=-1 && map[2] != -1) break;
				if(master[i][0] == 0 && master[i][1] == 0 && master[i][2] == 0 ) continue;
				for(int j=0;j<3;j++) {
					if(map[j] != -1 && master[i][j] != 0) {
						master[i][3] -= map[j]*master[i][j];
						master[i][j]=0;
					}
				}
				if(map[0] == -1 && master[i][0] != 0 && master[i][1] == 0 && master[i][2] == 0) {
					map[0] = master[i][3]/master[i][0];
				}else if(map[1] == -1 && master[i][0] == 0 && master[i][1] != 0 && master[i][2] == 0) {
					map[1] = master[i][3]/master[i][1];
				}else if(map[2] == -1 && master[i][0] == 0 && master[i][1] == 0 && master[i][2] != 0) {
					map[2] = master[i][3]/master[i][2];
				}
			}
			for(int i=0;i<p;i++) {
				for(int j=0;j<prime.length;j++) {
					boolean is_ok = true;
					for(int k=0;k<4;k++) {
						if(master[i][k] % prime[j] != 0) {
							is_ok =false;
							break;
						}
					}
					if(is_ok && master[i][0] != 0 && master[i][1] != 0 && master[i][2] != 0 ) {
						for(int k=0;k<4;k++) {
							master[i][k] /= prime[j];
						}
						j--;
					}
				}
			}
			
			
			
			//System.out.println(Arrays.toString(map));
			tmp = sc.next();
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i) == '(') me[0][0]++;
				else if(tmp.charAt(i) == '{') me[0][1]++;
				else if(tmp.charAt(i) == '[') me[0][2]++;
				else if(tmp.charAt(i) == ')') me[0][0]--;
				else if(tmp.charAt(i) == '}') me[0][1]--;
				else if(tmp.charAt(i) == ']') me[0][2]--;
			}
			for(int i=1;i<q;i++) {
				tmp = sc.next();				
				me[i][0] = me[i-1][0];
				me[i][1] = me[i-1][1];
				me[i][2] = me[i-1][2];
				
				for(int k=0;k<tmp.length();k++) {
					if(tmp.charAt(k) == '(') me[i][0]++;
					else if(tmp.charAt(k) == '{') me[i][1]++;
					else if(tmp.charAt(k) == '[') me[i][2]++;
					else if(tmp.charAt(k) == ')') me[i][0]--;
					else if(tmp.charAt(k) == '}') me[i][1]--;
					else if(tmp.charAt(k) == ']') me[i][2]--;
				}
			}
			for(int i=0;i<q;i++) {
				if(i==0) System.out.print("#"+tc+" "+0+" ");
				else {
					int answer = 0;
					boolean is_minus = false;
					for(int j=0;j<3;j++) {
						if(me[i-1][j] != 0) {
							if(map[j] == -1) {
								is_minus=true;								
							}else {
								answer+=(map[j]*me[i-1][j]);
								me[i-1][j]=0;
								
							}
						}
					}
					if(!is_minus) System.out.print(answer+" ");
					else {
						int multi = 1;
						for(int j=0;j<prime.length;j++) {
							boolean is_ok = true;
							for(int k=0;k<4;k++) {
								if(me[i-1][k] % prime[j] != 0) {
									is_ok =false;
									break;
								}
							}
							if(is_ok && me[i-1][0] != 0 && me[i-1][1] != 0 && me[i-1][2] != 0 ) {
								for(int k=0;k<4;k++) {
									me[i-1][k] /= prime[j];
								}
								multi*=prime[j];
								j--;
							}
						}
						
						for(int j=0;j<p;j++) {
							boolean is_same = true;
							for(int k=0;k<3;k++) {
								if(master[j][k] != me[i-1][k]) {
									is_same =false;
									break;
								}
							}
							if(is_same) {
								is_minus = false;
								System.out.print((master[j][3]*multi)+" ");
								break;
							}
						}
						if(is_minus) System.out.print(-1+" "); 
					}
					
					
				}
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

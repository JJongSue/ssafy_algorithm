package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3378_2 {
	public static void main(String[] args) {
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19 };

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int master[][] = new int[p][4];
			int me[][] = new int[q][4];
			int map[] = new int[3];
			Arrays.fill(map, -1);
			String tmp = sc.next();
			// System.out.println(tmp);
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == '(')
					master[0][0]++;
				else if (tmp.charAt(i) == '{')
					master[0][1]++;
				else if (tmp.charAt(i) == '[')
					master[0][2]++;
				else if (tmp.charAt(i) == ')')
					master[0][0]--;
				else if (tmp.charAt(i) == '}')
					master[0][1]--;
				else if (tmp.charAt(i) == ']')
					master[0][2]--;
			}
			for (int i = 1; i < p; i++) {
				tmp = sc.next();
				master[i][0] = master[i - 1][0];
				master[i][1] = master[i - 1][1];
				master[i][2] = master[i - 1][2];
				int j = 0;
				int dotcnt = 0;
				while (j < tmp.length() && tmp.charAt(j) == '.') {
					dotcnt++;
					j++;
				}
				master[i - 1][3] = dotcnt;
				for (int k = j; k < tmp.length(); k++) {
					if (tmp.charAt(k) == '(')
						master[i][0]++;
					else if (tmp.charAt(k) == '{')
						master[i][1]++;
					else if (tmp.charAt(k) == '[')
						master[i][2]++;
					else if (tmp.charAt(k) == ')')
						master[i][0]--;
					else if (tmp.charAt(k) == '}')
						master[i][1]--;
					else if (tmp.charAt(k) == ']')
						master[i][2]--;
				}
			}
			int R = -2, C = -2, S = -2;
			for (int i = 1; i <= 20; i++) {
				// if(R==-1) break;
				for (int j = 1; j <= 20; j++) {

					// if(C==-1) break;
					boolean is_same = false;
					for (int k = 1; k <= 20; k++) {

						// if(S == -1) break;
						is_same = false;
						for (int l = 0; l < p ; l++) {
							int sum = master[l][0] * i + master[l][1] * j + master[l][2] * k;
							if (sum != master[l][3]) {
								is_same = false;
								break;
							} else
								is_same = true;
						}
						if (is_same) {
							if (S == -2 || S == k)
								S = k;
							else
								S = -1;
							if (C == -2 || C == j)
								C = j;
							else
								C = -1;
							if (R == -2 || R == i)
								R = i;
							else
								R = -1;
						}

					}
				}
			}

			// System.out.println(Arrays.toString(map));
			tmp = sc.next();
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == '(')
					me[0][0]++;
				else if (tmp.charAt(i) == '{')
					me[0][1]++;
				else if (tmp.charAt(i) == '[')
					me[0][2]++;
				else if (tmp.charAt(i) == ')')
					me[0][0]--;
				else if (tmp.charAt(i) == '}')
					me[0][1]--;
				else if (tmp.charAt(i) == ']')
					me[0][2]--;
			}
			for (int i = 1; i < q; i++) {
				tmp = sc.next();
				me[i][0] = me[i - 1][0];
				me[i][1] = me[i - 1][1];
				me[i][2] = me[i - 1][2];

				for (int k = 0; k < tmp.length(); k++) {
					if (tmp.charAt(k) == '(')
						me[i][0]++;
					else if (tmp.charAt(k) == '{')
						me[i][1]++;
					else if (tmp.charAt(k) == '[')
						me[i][2]++;
					else if (tmp.charAt(k) == ')')
						me[i][0]--;
					else if (tmp.charAt(k) == '}')
						me[i][1]--;
					else if (tmp.charAt(k) == ']')
						me[i][2]--;
				}
			}
			for (int i = 0; i < q; i++) {
				if (i == 0)
					System.out.print("#" + tc + " " + 0 + " ");
				else {
					int answer = 0;
					boolean is_minus = false;
					if (me[i - 1][0] != 0 && !is_minus) {
						if (R > 0)
							answer += R * me[i - 1][0];
						else
							is_minus = true;
					}
					if (me[i - 1][1] != 0 && !is_minus) {
						if (C > 0)
							answer += C * me[i - 1][1];
						else
							is_minus = true;
					}

					if (me[i - 1][2] != 0 && !is_minus) {
						if (S > 0)
							answer += S * me[i - 1][2];
						else
							is_minus = true;
					}
					if (is_minus) {
						boolean is_same = false;
						for(int j=0;j<p-1;j++) {
							if(is_same) break;
							for(int k=0;k<3;k++) {
								if(master[j][k] == me[i-1][k]) {
									is_same=true;
								}
								else {
									is_same=false;
									break;
								}
							}
							if(is_same) {
								is_minus=false;
								System.out.print(master[j][3] + " ");
								break;
							}
						}
						
						if(is_minus)System.out.print(-1 + " ");
					}
						
					else
						System.out.print(answer + " ");

				}
			}
			System.out.println();
		}
	}

}

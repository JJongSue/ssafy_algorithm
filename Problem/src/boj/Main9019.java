package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9019 {
	static boolean is_visit[];

	static class sta {
		int a;
		String s;

		public sta(int a, String s) {
			super();
			this.a = a;
			this.s = s;
		}

	}

	static String answer;

	public static void main(String[] args) {
		System.out.println(dL(1000));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			is_visit = new boolean[10000];



			// System.out.println(Arrays.toString(a));
			// System.out.println(Arrays.toString(b));/*
			Queue<sta> q = new LinkedList<sta>();
			q.add(new sta(A, ""));
			is_visit[A] = true;
			// dR(a);
			// System.out.println(Arrays.toString(dS(a)));
			asd: while (true) {

				int size = q.size();

				boolean is_same = true;
				for (int s = 0; s < size; s++) {
					is_same = true;
					sta statmp = q.poll();
					if (statmp.a != B)
						is_same = false;
					/*
					 * for(int i=0;i<4;i++) {
					 * 
					 * if(statmp.a != B ) { is_same=false; break; }
					 * 
					 * }
					 */
					if (is_same) {
						// System.out.println(Arrays.toString(statmp.a));
						// System.out.println(Arrays.toString(b));
						System.out.println(statmp.s);
						break asd;
					}
					// int [] arr = dD(statmp.a);
					int sss = (dD(statmp.a));
					if (!is_visit[sss]) {
						q.add(new sta(dD(statmp.a), statmp.s + 'D'));
						is_visit[sss] = true;
					}

					sss = dS(statmp.a);
					// arr = dS(statmp.a);
					if (!is_visit[sss]) {
						q.add(new sta(sss, statmp.s + 'S'));
						is_visit[sss] = true;
					}
					sss = dL(statmp.a);
					// arr = dS(statmp.a);
					if (!is_visit[sss]) {
						q.add(new sta(sss, statmp.s + 'L'));
						is_visit[sss] = true;
					}
					sss = dR(statmp.a);
					// arr = dS(statmp.a);
					if (!is_visit[sss]) {
						q.add(new sta(sss, statmp.s + 'R'));
						is_visit[sss] = true;
					}

					// arr = dL(statmp.a);
					// q.add(new sta(dL(statmp.a), statmp.s+'L'));

					// arr = dR(statmp.a);
					// q.add(new sta(dR(statmp.a), statmp.s+'R'));

				}

			}
		}
	}

	/*
	 * static void do_go(int []a, int []b, String ans) { boolean is_ok = true;
	 * for(int i=0;i<4;i++) { if(a[i] != b[i]) { is_ok = false; break; } } if(is_ok)
	 * { answer = ans; return; } dD(a, b, ans); dS(a, b, ans); dL(a, b, ans); dR(a,
	 * b, ans);
	 * 
	 * }
	 */
	static int dD(int b) {
		int a = b;
		/*
		int a1 = a / 1000;
		a = a % 1000;
		int a2 = a / 100;
		a = a % 100;
		int a3 = a / 10;
		int a4 = a % 10;
		a = 0;
		int tmp = 0;
		a += (a4 * 2) % 10 + tmp;
		tmp = (a4 * 2) / 10;

		a += ((a3 * 2) + tmp) % 10 * 10;
		tmp = (a3 * 2) / 10;

		a += ((a2 * 2) + tmp) % 10 * 100;
		tmp = (a2 * 2) / 10;

		a += ((a1 * 2) + tmp) % 10 * 1000;
		tmp = (a2 * 2) / 10;
		*/
		
		/*
		 * int a[] = new int[4]; for(int i=0;i<4;i++) a[i]=b[i]; int tmp =0; for(int
		 * i=3;i>=0;i--) { int result = 0; if(a[i] >=5) { result = tmp+((a[i]*2)%10);
		 * tmp = 1; a[i]= result; }else { a[i] = a[i]*2+tmp; tmp=0; } }
		 */
		// System.out.println("D"+Arrays.toString(a));
		return (a*2)%10000;
	}

	static int dS(int b) {
		
		int a = b;
		if(a == 0) return 9999;
		else return a-1;
		/*
		int a1 = a / 1000;
		a = a % 1000;
		int a2 = a / 100;
		a = a % 100;
		int a3 = a / 10;
		int a4 = a % 10;

		if (a1 == 0)
			a1 = 9;
		else
			a1--;

		if (a2 == 0)
			a2 = 9;
		else
			a2--;

		if (a3 == 0)
			a3 = 9;
		else
			a3--;

		if (a4 == 0)
			a4 = 9;
		else
			a4--;

		a = a1 * 1000 + a2 * 100 + a3 * 10 + a4;*/

		/*
		 * for(int i=0;i<4;i++) a[i]=b[i]; for(int i=0;i<4;i++) {
		 * 
		 * if(a[i] == 0) a[i]=9; else a[i]--; }
		 */
		// System.out.println("S"+Arrays.toString(a));
		//return a;
	}

	static int dL(int b) {
		int a = b;
		int a1 = a / 1000;
		a = a % 1000;
		int a2 = a / 100;
		a = a % 100;
		int a3 = a / 10;
		int a4 = a % 10;

		a = a2 * 1000 + a3 * 100 + a4 * 10 + a1;
		// System.out.println("L"+Arrays.toString(a));
		return a;
	}

	static int dR(int b) {
		int a = b;
		int a1 = a / 1000;
		a = a % 1000;
		int a2 = a / 100;
		a = a % 100;
		int a3 = a / 10;
		int a4 = a % 10;

		a = a4 * 1000 + a1 * 100 + a2 * 10 + a3;
		// System.out.println("R"+Arrays.toString(a));
		return a;
	}

}

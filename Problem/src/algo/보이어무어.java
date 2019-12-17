package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보이어무어 {
	static int NO_OF_CHARS = 500001;
	static int ans = 0;

	static void badCharHeuristic(char[] str, int size, int badchar[]) {
		int i;
		for (i = 0; i < size; i++)
			badchar[i] = -1;
		for (i = 0; i < size; i++)
			badchar[(int) str[i]] = i;
	}

	static void search(char txt[], char pat[]) {
		int m = pat.length;
		int n = txt.length;

		int badchar[] = new int[NO_OF_CHARS];

		badCharHeuristic(pat, m, badchar);

		int s = 0;
		while (s <= (n - m)) {
			int j = m - 1;
			while (j >= 0 && pat[j] == txt[s + j])
				j--;

			if (j < 0) {
				//System.out.println("시작점(idx : 0)으로부터의 offset = " + s);
				ans++;
				s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
			}
			else
				s += Math.max(1, j - badchar[txt[s + j]]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			ans = 0;
			String str = br.readLine();
			String pattern = br.readLine();			
			char txt[] = str.toCharArray();
			char pat[] = pattern.toCharArray();
			search(txt, pat);
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}

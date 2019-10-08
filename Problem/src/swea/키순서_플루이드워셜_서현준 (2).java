package day23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 유향 그래프에서 최단 경로(플로이드 알고리즘).
 * 플로이드-워셜 알고리즘은 각각의 꼭짓점 쌍을 지나는 그래프의 모든 경로를 비교한다.
 * 이 알고리즘은 두 꼭짓점 간의 추정 최단 경로를 최적이 될 때 까지 점진적으로 개선시켜서 최단경로를 찾는다.
 * 플로이드-워셜 알고리즘은 거의 대부분이나 모든 꼭짓점 쌍이 변으로 연결된 밀집 그래프에서 모든 꼭짓점 쌍 간의 경로를 계산할 때 적합하다.
 */
public class 키순서_플로이드워셜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int INF = 987654321;
		int[][] adj = new int[501][501];
		int[] isOk = new int[501];
		int N, M, ans;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						adj[i][j] = 0;
					else
						adj[i][j] = INF;
				}
				isOk[i] = 0;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adj[i][j] < INF || adj[j][i] < INF)
						isOk[i]++;
				}
			}
			ans = 0;
			for (int i = 1; i <= N; i++) {
				if (isOk[i] == N)
					ans++;
			}
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
		}
		bw.flush();
	}
}
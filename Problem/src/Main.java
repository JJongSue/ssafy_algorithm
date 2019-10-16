import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {
	private static int N;// (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
	private static int L;
	private static int R;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] num;
	private static boolean[][] visited2;

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// N×N크기의 땅
		L = Integer.parseInt(st.nextToken());// 두 나라의 인구 차이가 L명 이상, R명 이하
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		num = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		Queue<Pos> queue = new LinkedList<>();
		Queue<Pos> unit = new LinkedList<>();

		boolean flag = true;
		int ans = 0;
		int avg = -1;
		while (flag) {
			flag = false;
			int sum = 0;
			int cnt = 0;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
				Arrays.fill(visited2[i], false);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int s = 0; s < N; s++) {
						Arrays.fill(visited[s], false);
						Arrays.fill(visited2[s], false);
					}
					if (!visited[i][j] && map[i][j]!=avg) {
						visited[i][j] = true;
						sum = map[i][j];
						cnt = 1;
						num[i][j] = ++idx;
						queue.add(new Pos(i, j));

						while (!queue.isEmpty()) {
							Pos p = queue.poll();
							for (int d = 0; d < 4; d++) {
								int nr = p.r + dr[d];
								int nc = p.c + dc[d];
								if (isRange(nr, nc) && !visited[nr][nc]) {
									int dif = Math.abs(map[p.r][p.c] - map[nr][nc]);
									if (dif >= L && dif <= R) {
										visited[nr][nc] = true;
										sum += map[nr][nc];
										cnt++;
										num[nr][nc] = idx;
										queue.add(new Pos(nr, nc));
										flag = true;
									}
								}
							}
						} // end while

						if(cnt>1) {
						avg = sum / cnt;
						}else {
							continue;
						}
						
//						System.out.println("-");
//						for (int[] n : num) {
//							System.out.println(Arrays.toString(n));
//						}
//						System.out.println();
						unit.add(new Pos(i,j));
						map[i][j] = avg; 
						while(!unit.isEmpty()) {
							Pos u = unit.poll();
							for (int d = 0; d < 4; d++) {
								int nr = u.r + dr[d];
								int nc = u.c + dc[d];
								if (isRange(nr, nc) && !visited2[nr][nc]) {
									if(num[nr][nc]==num[u.r][u.c]) {
										visited2[nr][nc] = true;
										unit.add(new Pos(nr, nc));
										map[nr][nc] = avg;
									}
								}

							}
						}
						for (int x = 0; x < N; x++) {
							Arrays.fill(num[x], 0);
						}
					} // end if
				}
			}
			if(flag)
				ans++;
			else
				break;
//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println();
//			for (int[] n : num) {
//				System.out.println(Arrays.toString(n));
//			}
//			System.out.println();
		}
		System.out.println(ans);
	}

	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
}

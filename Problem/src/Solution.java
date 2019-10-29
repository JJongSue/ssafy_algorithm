import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int[][] map = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            Queue<Integer> helper = new LinkedList<Integer>();
            switch (command) {
            case "up":
                // 빈공간 압축!
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = r + 1; s < N; s++) {
                                if (map[s][c] != 0) {
                                    helper.add(map[s][c]);
                                    map[s][c] = 0;
                                }
                            }
                            int s = r - 1;
                            while (!helper.isEmpty()) {
                                s++;
                                map[s][c] = helper.poll();
                            }
                        }
                    }
                }
                // 맨 위에껀 안볼꺼지롱
                // 2048 ㄱ
                for (int r = 1; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r - 1][c] == map[r][c]) {
                            map[r - 1][c] *= 2;
                            map[r][c] = 0;
                        }
                    }
                }
                // 빈공간 압축!
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = r + 1; s < N; s++) {
                                if (map[s][c] != 0) {
                                    helper.add(map[s][c]);
                                    map[s][c] = 0;
                                }
                            }
                            int s = r - 1;
                            while (!helper.isEmpty()) {
                                s++;
                                map[s][c] = helper.poll();
                            }
                        }
                    }
                }
                break;
            case "down":
                // 빈공간 압축!
                for (int r = N-1; r >= 0; r--) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = r-1; s >= 0; s--) {
                                if (map[s][c] != 0) {
                                    helper.add(map[s][c]);
                                    map[s][c] = 0;
                                }
                            }
                            int s = r + 1;
                            while (!helper.isEmpty()) {
                                s--;
                                map[s][c] = helper.poll();
                            }
                        }
                    }
                }
                // 2048 ㄱ
                for (int r = N-2; r >=0; r--) {
                    for (int c = 0; c < N; c++) {
                        if (map[r + 1][c] == map[r][c]) {
                            map[r + 1][c] *= 2;
                            map[r][c] = 0;
                        }
                    }
                }
                //공간 압축 ㄱ
                for (int r = N-1; r >= 0; r--) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = r-1; s >= 0; s--) {
                                if (map[s][c] != 0) {
                                    helper.add(map[s][c]);
                                    map[s][c] = 0;
                                }
                            }
                            int s = r + 1;
                            while (!helper.isEmpty()) {
                                s--;
                                map[s][c] = helper.poll();
                            }
                        }
                    }
                }
                break;
            case "left":
                // 빈공간 압축!
                for (int r = 0; r <N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = c+1; s< N; s++) {
                                if (map[r][s] != 0) {
                                    helper.add(map[r][s]);
                                    map[r][s] = 0;
                                }
                            }
                            int s = c - 1;
                            while (!helper.isEmpty()) {
                                s++;
                                map[r][s] = helper.poll();
                            }
                        }
                    }
                }
                // 2048 ㄱ
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N-1; c++) {
                        if (map[r][c+1] == map[r][c]) {
                            map[r][c] *= 2;
                            map[r][c+1] = 0;
                        }
                    }
                }
                //공간 압축 ㄱ
                for (int r = 0; r <N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (map[r][c] == 0) {
                            for (int s = c+1; s< N; s++) {
                                if (map[r][s] != 0) {
                                    helper.add(map[r][s]);
                                    map[r][s] = 0;
                                }
                            }
                            int s = c - 1;
                            while (!helper.isEmpty()) {
                                s++;
                                map[r][s] = helper.poll();
                            }
                        }
                    }
                }
                break;
            case "right":
                // 빈공간 압축!
                for (int r = 0; r <N; r++) {
                    for (int c = N-1; c > 0; c--) {
                        if (map[r][c] == 0) {
                            for (int s = c-1; s>=0; s--) {
                                if (map[r][s] != 0) {
                                    helper.add(map[r][s]);
                                    map[r][s] = 0;
                                }
                            }
                            int s = c + 1;
                            while (!helper.isEmpty()) {
                                s--;
                                map[r][s] = helper.poll();
                            }
                        }
                    }
                }
                 
                // 2048 ㄱ
                for (int r = 0; r < N; r++) {
                    for (int c = N-1; c >0; c--) {
                        if (map[r][c-1] == map[r][c]) {
                            map[r][c] *= 2;
                            map[r][c-1] = 0;
                        }
                    }
                }
                //공간 압축 ㄱ
                for (int r = 0; r <N; r++) {
                    for (int c = N-1; c > 0; c--) {
                        if (map[r][c] == 0) {
                            for (int s = c-1; s>=0; s--) {
                                if (map[r][s] != 0) {
                                    helper.add(map[r][s]);
                                    map[r][s] = 0;
                                }
                            }
                            int s = c + 1;
                            while (!helper.isEmpty()) {
                                s--;
                                map[r][s] = helper.poll();
                            }
                        }
                    }
                }
                break;
            }//switch 끝
            sb.append("#").append(tc).append('\n');
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    sb.append(map[r][c]).append(" ");
                }
                sb.append('\n');
            }
 
        }//tc 끝
        System.out.print(sb.toString());
    }
 
}
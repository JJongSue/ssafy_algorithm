import java.io.*;
import java.util.*;

public class Main {
   static char[][] map;
   static int N, M;

   static boolean inMap(int x, int y) {
      return x >= 0 && x < N && y >= 0 && y < M;
   }

   static int[] dx = { -1, 0, 1 };
   static int[] dy = { 1, 1, 1 };

   static class info {
      int x;
      int y;

      public info(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
   }

   static info rabbit;
   static ArrayList<info> li;
   static int[][] dp;

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();
      map = new char[N][M];
      dp = new int[N][M];
      li = new ArrayList<info>();
      for (int i = 0; i < N; i++) {
         String str = sc.next();
         for (int j = 0; j < M; j++) {
            map[i][j] = str.charAt(j);
            dp[i][j] = -1;
            if (map[i][j] == 'R') {
               rabbit = new info(i, j);
               dp[i][j] = 0;
            } else if (map[i][j] == 'O') {
               li.add(new info(i, j)); // 문 후보군들 저장
            }
         }
      }
      // 우측으로 나아가기 때문에 지나간 길 다시 갈 일 없어
      // .빈공간, c 당근, o 문 지나갈 수 있어
      // # 벽 못 지나가, o 문이라고 꼭 도착지 아니야... 도착지의 예비군일 뿐
      func(rabbit.x, rabbit.y);

      int result=Integer.MIN_VALUE;
      if (!visited) {
         System.out.println("-1");
      } else {
         for (int i = 0; i < li.size(); i++) {
            result=Math.max(result, dp[li.get(i).x][li.get(i).y]);
         }
         System.out.println(result);
      }
   }

   static boolean visited; //여러 문 중에 하나라도 들렸다면 true / false인 경우 출력 -1

   private static void func(int x, int y) {
      // TODO Auto-generated method stub
      int total = dp[x][y]; // 현 경로까지 먹은 당근 수
      for (int i = 0; i < 3; i++) {
         int nx = x + dx[i];
         int ny = y + dy[i];
         if (!inMap(nx, ny) || map[nx][ny] == '#')
            continue;
         // 범위 안에 있는 경우 => 당근 많이 먹어온 길인지 확인 필요=>갱신하고 지나가
         if (map[nx][ny] == 'C') {
        	if(dp[nx][ny] == -1) {
        		dp[nx][ny] = total + 1;
                func(nx, ny);
        	}
        	else if (dp[nx][ny] < total + 1) {
               dp[nx][ny] = total + 1;
               //func(nx, ny);
            }
         } else {
        	if( dp[nx][ny] == -1) {
        		if (map[nx][ny] == 'O')
                    visited = true;
                 dp[nx][ny] = total;
                 func(nx, ny);
        	}
        	else if (dp[nx][ny] < total) {
               if (map[nx][ny] == 'O')
                  visited = true;
               dp[nx][ny] = total;
               //func(nx, ny);
            }
         }

      }
   }

}

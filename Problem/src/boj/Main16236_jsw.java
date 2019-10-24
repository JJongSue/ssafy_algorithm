package boj;
import java.io.*;
import java.util.*;
public class Main16236_jsw {
   public static class Shark {
       int r, c, level, step, exp;
       public Shark(int r, int c, int level, int step, int exp) {
           this.r = r;
           this.c = c;
           this.level = level;
           this.step = step;
           this.exp = exp;
       }
   }
   public static class Fish implements Comparable<Fish> {
       int r, c;
       public Fish(int r, int c) {
           this.r = r;
           this.c = c;
       }
       @Override
       public int compareTo(Fish o) {
          if(this.r == o.r) return this.c - o.c;
          return this.r - o.r;
       }
   }
   static Queue<Shark> shark = new LinkedList<>();
   static PriorityQueue<Fish> fish = new PriorityQueue<>();
   static int fishCount;
   static int N;
   static int[][] map;
   static boolean[][] visited;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       StringTokenizer st = null;
       map = new int[N][N];
       visited = new boolean[N][N];
       for (int r = 0; r < N; r++) {
           st = new StringTokenizer(br.readLine());
           for (int c = 0; c < N; c++) {
               int a = Integer.parseInt(st.nextToken());
               map[r][c] = a;
               if (a == 9) {
                   map[r][c] = 0;
                   shark.add(new Shark(r, c, 2, 0, 0));
               }
               if (a != 9 && a != 0) {
                   fishCount++;
               }
           }
       }
       BFS();
       System.out.println(answer);
   }
   static int[] dc = { -1, 1, 0, 0 };
   static int[] dr = { 0, 0, -1, 1 };
   static int answer =0;
   public static void BFS() {
       end:while (!shark.isEmpty()) {
    	   int size = shark.size();
    	   int step = shark.peek().step;
    	   int exp= shark.peek().exp;
    	   int level = shark.peek().level;
    	   for(int s=0;s<size;s++) {
    		   if(fishCount==0) break end;
    		   Shark cur_shark = shark.poll();
               int cc = cur_shark.c;
               int cr = cur_shark.r;
               level = cur_shark.level;
               step = cur_shark.step;
               exp = cur_shark.exp;
               
               for (int i = 0; i < 4; i++) {
                   int nc = cc + dc[i];
                   int nr = cr + dr[i];
                   if(nr < 0 || nc < 0 || nr >= N || nc >= N)continue;
                   if(visited[nr][nc] || map[nr][nc] > level)continue;
                   if(map[nr][nc]==0 || map[nr][nc] ==level) {
                       visited[nr][nc] =true;
                       shark.add(new Shark(nr, nc, level, step+1, exp));
                   }
                   else if(map[nr][nc] < level) {
                       visited[nr][nc]=true;
//                        shark.add(new Shark(nr, nc, level, step+1, exp));
                       fish.add(new Fish(nr, nc));
                   }
               }
               
               
               
               
    	   }
    	   if(!fish.isEmpty()) {
//             System.out.println(fish.size());
           // System.out.println("걸음수"+(step+1));
            int cx=fish.peek().c;
            int cy=fish.peek().r;
            fish.poll();
            map[cy][cx] = 0;
            fish.clear();
            shark.clear();
            answer+=step;
            step=0;
            fishCount--;
            for(int i=0;i<N; i++) {
                Arrays.fill(visited[i], false);
            }
            exp++;
            if(exp == level) {
                exp=0;
                level++;
            }
            shark.add(new Shark(cy, cx, level, step, exp));
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }
            System.out.println();
            //break end2;
        }
           
           
       }
   }
}
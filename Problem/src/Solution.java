import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static class Pos implements Comparable<Pos>{
        int r, c;
        char val;
        Pos(int r, int c, char val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
        @Override
        public int compareTo(Pos o) {
            return this.val-o.val;
        }
    }
    static PriorityQueue<Pos> queue;
    static LinkedList<Pos> list;
    static char [][]map;
    static boolean[][] visited;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());//  케이스의 수 T
        StringTokenizer st = null;
         
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//두 정수 N, M(1 ≤ N, M ≤ 2,000)
            int M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            String str;
            for (int i = 0; i < N; i++) {
            	map[i] = br.readLine().toCharArray();
                //str = br.readLine();
                /*for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                }*/
            }
             
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
             
            visited = new boolean[N][M];
            list = new LinkedList<>();
            queue = new PriorityQueue<>();
            visited[0][0] = true;
            list.add(new Pos(0, 0, map[0][0]));
            sb.append(map[0][0]);
//          System.out.println(sb.toString());
//          System.out.println(queue.peek().val);
             
            int sizeL=0;
            int sizeQ=0;
            int min = 987654321;
             
            while(!list.isEmpty()) {
                sizeL = list.size();
                queue = new PriorityQueue<>();
//              System.out.println("size>>"+size);
                for (int i = 0; i < sizeL; i++) {
                    Pos p = list.get(0);//꺼내서 오른쪽, 아래쪽 넣기
                    list.poll();
                    
//                  System.out.println("test -- p.r:"+p.r+", p.c:"+p.c);
                    for (int d = 0; d < 2; d++) {
                        int nr = p.r+dr[d];
                        int nc = p.c+dc[d];
                        if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            queue.add(new Pos(nr, nc, map[nr][nc]));
//                          System.out.println("nr:"+nr+", nc:"+nc+", val:"+map[nr][nc]);
                             
                        }
                    }
                     
                }
                 
                sizeQ = queue.size();
                list = new LinkedList<>();
                min = queue.peek().val;
                sb.append(min);
//              System.out.println("size:"+size+", min:"+min);
                /*if(queue.peek().r==N-1 && queue.peek().c==M-1)
                    break;*/
                 
                for (int i = 0; i < sizeQ; i++) {//작은거만 찾자
                    Pos p = queue.poll();
                    if(p.val==min)
                        list.add(p);
                    else break;
                    
                }
                //queue.clear();
                 
            }
             
            System.out.println(sb.toString());
//          for (int[] is : map) {
//              System.out.println(Arrays.toString(is));
//          }
//          System.out.println();
        }
    }
     
    static int[] dr = {0,1};
    static int[] dc = {1,0};
}
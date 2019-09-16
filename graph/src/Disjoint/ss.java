package Disjoint;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class ss {
    static int N;
    static long[] posX; 
    static long[] posY; 
    static long[][] cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            cost = new long[N][N];
            posX = new long[N];
            posY = new long[N];
            for(int i=0; i<N; i++) {
                posX[i] = sc.nextLong();
                posY[i] = sc.nextLong();
            }
            double price = sc.nextDouble();
             
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    long c = Math.abs(posX[i]-posX[j])*Math.abs(posX[i]-posX[j]) + 
                            Math.abs(posY[i]-posY[j])*Math.abs(posY[i]-posY[j]);
                    cost[i][j] = c;
                    cost[j][i] = c;
                }
            }
             
            boolean[] visited = new boolean[N];
            ArrayList<Integer> list = new ArrayList<Integer>();
            PriorityQueue<edge> pq = new PriorityQueue<>();
             
            double sum = 0;
            int index = 0;
            visited[0] = true;
            list.add(index);
             
            for(int i=0; i<N-1; i++) {
                pq.clear();
                for(int num : list) {
                    for(int j=0; j<N; j++) {
                        if(!visited[j] && i!=j)
                            pq.add(new edge(j, cost[num][j]));
                    }
                }
                edge e = pq.poll();
                sum += e.cost;
                index = e.idx;
                list.add(index);
                visited[index] = true;
            }
            sum *= price;
            System.out.println("#" + tc + " " + Math.round(sum));
        } 
    }
    static class edge implements Comparable<edge>{
        int idx;
        double cost;
        public edge(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
        @Override
        public int compareTo(edge o) {
            // TODO Auto-generated method stub
            if(this.cost - o.cost>0)
                return 1;
            else
                return -1;
        }
    }
}
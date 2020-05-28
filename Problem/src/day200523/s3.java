package day200523;

import java.util.ArrayList;

public class s3 {
   public static void main(String[] args) {
//      int[][] board = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{2,1,3,2}};
//      int[][] board = {{1,1,3,3},{4,1,3,4},{1,2,1,1},{1,1,1,1}};
	   int[][] board = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
//      down(board);
//      find(board.length, board, 0);
      printb(board);
      System.out.println(solution(board));
   }
   static void printb(int board[][]) {
	   int s= board.length;
	   for(int i=0;i<s;i++) {
		   for(int j=0;j<s;j++) System.out.print(board[i][j] + " ");
		   System.out.println();
	   }
   }
   public static int solution(int[][] board) {
	   
      int answer = 0;
      //사탕 선택 
      int n = board.length;
      int map[][]= new int[n][n];
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
               System.arraycopy(board[k], 0, map[k], 0, n);
            }
            map[i][j]=0; 
            int cnt = 1; 
            int tmp = 0; 
            down(map);
            while(true) {
               tmp = find(n,map,cnt);
               down(map);
               if(cnt== tmp) {
                  break; 
               }
               cnt = tmp ; 
            }
            answer =Math.max(answer, cnt);
         }
      }
      return answer;
   }
   
   public static int find(int n, int[][] map, int cnt) {
      boolean flag = false;
      int[][] arr = new int[n][n]; 
      for (int i = 0; i < arr.length; i++) {
         System.arraycopy(map[i], 0, arr[i], 0, n);
      }
      for (int i = 0; i < map.length; i++) {
         for (int j = 0; j < map.length; j++) {
            if(map[i][j]==0)continue; 
            int num = map[i][j]; 
            int nr = i; 
            boolean flag_in = false;
            //세로
            int tmp =1; 
            while(nr>0) {
               nr--;
               if(map[nr][j]==num) tmp++; 
               else break;
            }
            nr = i; 
            while(nr<n-1) {
               nr++; 
               if(map[nr][j]==num) tmp++;
               else  break;
            }
            if(tmp >=3) {
               nr = i; 
               map[nr][j]= 0; 
               flag = true; 
               flag_in= true; 
               while(nr>0) {
                  nr--;
                  if(map[nr][j]==num) arr[nr][j]=0; 
                  else break;
               }
               nr =i; 
               while(nr<n-1) {
                  nr++; 
                  if(map[nr][j]==num) arr[nr][j]=0; 
                  else  break;
               }
               arr[i][j]=0;
            }
            //가로
            int nc = j; 
            tmp=1; 
            while(nc>0) {
               nc--; 
               if(map[i][nc]==num)tmp++;
               else break;
            }
            nc = j; 
            while(nc<n-1) {
               nc++; 
               if(map[i][nc]==num)tmp++; 
               else break;
            }
            if(tmp >=3) { 
               nc = j; 
               flag = true; 
               flag_in= true; 
               while(nc>0) {
                  nc--; 
                  if(map[i][nc]==num)arr[i][nc]=0; 
                  else break;
               }
               nc = j; 
               while(nc<n-1) {
                  nc++; 
                  if(map[i][nc]==num)arr[i][nc]=0; 
                  else break;
               }
               arr[i][j]=0;
            }
         }
      }
      if(flag) {
         cnt =0; 
         for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < arr.length; k++) {
               map[i][k]=arr[i][k];
               if(arr[i][k]==0)cnt++;
            }
         }
      }

      
      return cnt;
   }
   public static void down(int[][] map) {
      ArrayList<Integer> list =new ArrayList<Integer>(); 
      for (int i = 0; i < map.length; i++) {
         list.clear();
         for (int j = map.length-1; j >=0; j--) {
            if(map[j][i]==0)continue; 
            list.add(map[j][i]);
            map[j][i]=0;
         }

         int idx = map.length-1;
         for (int j = 0; j < list.size(); j++) {
            map[idx][i]=list.get(j);
            idx--;
         }
      }

   }

}
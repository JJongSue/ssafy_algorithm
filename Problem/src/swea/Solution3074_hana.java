package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3074_hana {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            long min = Long.MAX_VALUE;
            long[] arr = new long[N];
            for(int i=0;i<N;i++){
                arr[i] = Long.parseLong(br.readLine());
                min = Math.min(min, arr[i]);
            }
            long ans = search(1,min*M,arr,M);
            System.out.println("#"+t+" "+ans);
        }
    }
    static long search(long left,long right, long[] arr,long M){
        if(left>right){
            return -1;
        }
        long count=0;
        long mid = (left+right)/2;
        int r =0;
        for(int i=0;i<arr.length;i++){
            count += mid/arr[i];
            if(mid%arr[i]==0){
                r++;
            }
        }
//      System.out.println(mid+" "+count);
        if(count>=M && count<M+r){
            return mid;
        }
//      System.out.println(mid+" "+count);
        if(count>=M && count<M+r){
            return mid;
        }
        else if(count>=M){
            return search(left,mid-1,arr,M);
        }
        else{
            return search(mid+1,right,arr,M);
        }
    }
	
	
}

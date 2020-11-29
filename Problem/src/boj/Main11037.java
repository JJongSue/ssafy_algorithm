package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        System.out.println("hello");
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
        	ans ^= (Integer.parseInt(br.readLine()));
        }
        System.out.println(ans);


    }
}

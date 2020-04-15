import java.io.*;
import java.util.*;

public class Main {
	static boolean is_p[];
	static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		is_p = new boolean[M+1];
		StringBuilder sb = new StringBuilder();
		if( 2>= N && 2<= M) {
			//sb.append(2).append("\n");
			System.out.println(2);
		}
		boolean is_first = true;
		for(int i=4;i<=M;i+=2) is_p[i] = true;
		for(int i=3;i<=M;i+=2) {
			if(is_p[i]) continue;
			//sb.append(i).append("\n");
			if(i>=N && i<=M)
			System.out.println(i);
			for(int j=i+i;j<=M;j+=(i+i)) {
				if(j<0) break;
				is_p[j] = true;
			}
		}
		//System.out.println(sb);
	}

}

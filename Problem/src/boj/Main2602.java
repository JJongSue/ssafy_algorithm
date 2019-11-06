package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2602 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char rig[] = br.readLine().toCharArray();
		char one[] = br.readLine().toCharArray();
		char two[] = br.readLine().toCharArray();
		int oo[] = new int[one.length];
		int tt[] = new int[one.length];
		int N = one.length;
		for(int i=0;i<N;i++) {
			if(one[i] == rig[rig.length-1]) oo[i] = 1;
			if(two[i] == rig[rig.length-1]) tt[i] = 1;
		}
		
		
		for(int i=N-1;i>=0;i--) {
			for(int j=i+1;j<N;j++) {
				if(one[i] )
			}
		}
		
	}
}

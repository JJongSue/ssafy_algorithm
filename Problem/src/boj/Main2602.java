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
		long oo[] = new long[rig.length];
		long tt[] = new long[rig.length];
		int N = one.length;
		long tmpo = 0;
		long tmpt = 0;
		for(int i=N-1;i>=0;i--) {
			long tmpoo = oo[0];
			long tmptt = tt[0];			
			
			for(int j=0;j<rig.length-1;j++) {
				if(one[i] == rig[j]) {					
					oo[j] += tt[j+1];
				}
				if(two[i] == rig[j])
				{
					tt[j] += oo[j+1];				
				}
			}
			if(one[i] == rig[rig.length-1]) {					
				oo[rig.length-1] += (1);
				
			}
			if(two[i] == rig[rig.length-1]) {					
				tt[rig.length-1] += (1);
			}			
			
		}
		
		
		
		System.out.println((oo[0]+tt[0]));
		
	}
}

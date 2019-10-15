package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16506 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			sb.append(code(tmp)).append("\n");			
		}
		System.out.println(sb);
	}
	static String code(String tmp) {
		String arr[] = tmp.split(" ");
		StringBuilder sb = new StringBuilder();
		if(arr[0].equals("ADD")) {
			//0000
			sb.append("0000");
			//4
			sb.append("0");
			//5
			sb.append("0");
			sb.append(binary(arr[1]));
			sb.append(binary(arr[2]));
			sb.append(binary(arr[3]));
			sb.append("0");			
		}
		else if(arr[0].equals("ADDC")) {
			//0000
			sb.append("0000");
			//4
			sb.append("1");
			//5
			sb.append("0");
			//RD
			sb.append(binary(arr[1]));
			//RA
			sb.append(binary(arr[2]));
			//RC
			sb.append(binary(arr[3]));			
		}else if(arr[0].equals("SUB")) {
			//0000
			sb.append("0001");
			//4
			sb.append("0");
			//5
			sb.append("0");
			//RD
			sb.append(binary(arr[1]));
			//RA
			sb.append(binary(arr[2]));
			//RC
			sb.append(binary(arr[3]));		
			sb.append("0");	
		}else if(arr[0].equals("SUBC")) {
			//0000
			sb.append("0001");
			//4
			sb.append("1");
			//5
			sb.append("0");
			//RD
			sb.append(binary(arr[1]));
			//RA
			sb.append(binary(arr[2]));
			//RC
			sb.append(binary(arr[3]));	
		}else if(arr[0].equals("MOV")) {
			//0000
			sb.append("0010");
			//4
			sb.append("0");
			//5
			sb.append("0");
			//RD
			sb.append(binary(arr[1]));
			//RA
			sb.append(binary(arr[2]));
			//RC
			sb.append(binary(arr[3]));		
			sb.append("0");	
		}else if(arr[0].equals("MOVC")) {
			//0000
			sb.append("0010");
			//4
			sb.append("1");
			//5
			sb.append("0");
			//RD
			sb.append(binary(arr[1]));
			//RA
			sb.append(binary(arr[2]));
			//RC
			sb.append(binary(arr[3]));	
		}
		
		
		return sb.toString();
	}
	
	static String binary(String tmp) {
		int a = Integer.parseInt(tmp);
		switch (a) {
		case 0:
			return "000";
		case 1:
			return "001";
		case 2:
			return "010";
		case 3:
			return "011";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		case 8:
			return "1000";
		case 9:
			return "1001";
		case 10:
			return "1010";
		case 11:
			return "1011";
		case 12:
			return "1100";
		case 13:
			return "1101";
		case 14:
			return "1110";
		case 15:
			return "1111";
			

		default:
			return "";
		}
		
	}
	
}

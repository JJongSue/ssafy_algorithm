import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class makeinput {
	public static void main(String[] args) throws IOException {
		int N = 500;
		char output = '/';
		FileWriter   fw = new FileWriter("test.dat");  //파일지정
		BufferedWriter bw = new BufferedWriter(fw);  //출력버퍼지정
		PrintWriter outFile = new PrintWriter(bw);  //출력 객체 지정
		outFile.print( N+" "+ N  + "\r\n");  //해당객체에 print문으로 출력함
		//System.out.println(N);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				outFile.print( output );
			}outFile.print( "\r\n");
		}
		outFile.flush();
	}
}


public class twox {
	static int bino(int n, int k) {
		if(k==0 || n==k) return 1;
		return bino(n-1, k-1)+bino(n-1,k);
	}
	static int B[][];
	static {
		B= new int[10000][10000];
	}
	static int bino1(int n, int r) {
		if(r ==0 || n==r) return 1;
		if(B[n][r] != 0) return B[n][r];
		return B[n][r]=bino1(n-1,r-1)+bino1(n-1,r);
	}
	static int bino2(int n, int k) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<Math.min(i, k);j++) {
				if(j==0 || j == i) B[i][j]=1;
				else B[i][j]= B[i-1][j-1]+B[i-1][j];
			}
		}
		return B[n][k];
	}
	public static void main(String[] args) {
		
	}
}

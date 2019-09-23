
public class rabbitNum {
	public static void main(String[] args) {
		long []Arr = new long[101];
		Arr[1]=1;
		Arr[2]=1;
		for(int i=3;i<=100;i++) {
			Arr[i]=Arr[i-1]+Arr[i-2];
		}
		System.out.println(Arr[100]);
	}
}

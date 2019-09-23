
public class money {
	static int arr[];
	static {
		arr = new int[100];
		for(int i=0;i<4;i++)
			arr[i]=i;
	}
	static int minmoney(int n) {
		if(n<4) return arr[n];
		if(arr[n] != 0) return arr[n];
		if(n<6) return arr[n]=Math.min(minmoney(n-1)+1, minmoney(n-4)+1);
		int a = (minmoney(n-4)+1);
		a = Math.min(minmoney(n-1)+1,a);
		return arr[n]= Math.min(a, minmoney(n-6)+1);
		
	}
	public static void main(String[] args) {
		System.out.println(minmoney(99));
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11004 {
	static int arr[], K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quicksort(0, arr.length-1);
//		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[K-1]);
	}
	
	public static int partition(int left, int right) {
	    int mid = (left + right) / 2; 
	    swap(left, mid); // 중앙 값을 첫 번째 요소로 이동
	 
	    int pivot = arr[left];
	    int i = left, j = right;
	 
	    while (i < j) {
	        while (pivot < arr[j]) { // j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
	            j--;
	        }
	 
	        while (i < j && pivot >= arr[i]) { // i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
	            i++;
	        }
	        swap(i, j); // 찾은 i와 j를 교환
	    }
	    // 반복문을 벗어난 경우는 i와 j가 만난경우
	    // 피봇과 교환
	    arr[left] = arr[i];
	    arr[i] = pivot;
	    return i;
	}
	 
	public static void swap(int a, int b) {
	    int temp = arr[b];
	    arr[b] = arr[a];
	    arr[a] = temp;
	}
	 
	public static void quicksort(int left, int right) {
	    if (left >= right) {
	        return;
	    }
	 
	    int pi = partition(left, right);
	    
	   // partition과정을 통해 구한 구분점에 +1한 값과 k를 비교하여 해당하는 부분집합에 대해
       // 재귀호출을 반복한다.
//	    if(pi+1 == K) return;
	    if(pi+1<K)
	    	quicksort(pi + 1, right);
	    else
	    	quicksort(left, pi - 1);
	    
	}

}

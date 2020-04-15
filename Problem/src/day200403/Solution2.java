package day200403;

import java.util.ArrayList;

public class Solution2 {
	 static public int[] solution(int []arr) {
        
        int size = 1;
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(arr[0]);
        int past = arr[0];
        for(int i=1;i<arr.length;i++) {
        	if(past != arr[i]) {
        		al.add(arr[i]);
        		past = arr[i];
        		
        	}
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++) {
        	answer[i] = al.get(i);
        	//System.out.println(answer[i]);
        }
        
        
        //System.out.println(answer.toString());
        return answer;
	}
	public static void main(String[] args) {
		//int arr[] = {1,1,3,3,0,1,1};
		int arr[] = {4,4,4,3,3};
		System.out.println(solution(arr).toString());
	}
}

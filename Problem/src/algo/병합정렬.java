package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class 병합정렬 {
	
	static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
		if(arr.size() == 1) return arr;
		int mid = arr.size()/2;
		ArrayList<Integer> la = new ArrayList<Integer>();
		ArrayList<Integer> ra = new ArrayList<Integer>();
		for(int i=0;i<mid;i++) {
			la.add(arr.get(i));
		}
		for(int i=mid;i<arr.size();i++) {
			ra.add(arr.get(i));
		}
		la = merge_sort(la);
		ra = merge_sort(ra);
		return merge(la,ra);
	}
	
	static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(left.size()>0 || right.size()>0) {
			if(left.size()>0 && right.size()>0) {
				if(left.get(0) > right.get(0)) {
					result.add(right.get(0));
					right.remove(0);
				}else {
					result.add(left.get(0));
					left.remove(0);
				}
			}else if(left.size()>0) {
				result.add(left.get(0));
				left.remove(0);
			}else if(right.size()>0) {
				result.add(right.get(0));
				right.remove(0);
			}
		}
		
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		Integer[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		int N = arr.length;
		
		ArrayList<Integer> result = merge_sort(new ArrayList<Integer>(Arrays.asList(arr)));
		for(int data: result)
			System.out.print(data + " ");
	}

}

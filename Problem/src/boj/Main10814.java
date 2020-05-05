package boj;

import java.util.HashMap;

public class Main10814 {
	static HashMap<Integer, String> hm = new HashMap<>();
	static class man{
		int index;
		int age;
		public man(int index, int age) {
			super();
			this.index = index;
			this.age = age;
		}
		int compare(man o) {
			if(o.age == this.age) return this.age - o.age;
			return this.index - o.index;
		}
	}
	static man arr[];
	
	static void quickSort(int left ,int right) {
		int l = left;
		int r = right;
		if(l==r) return;
		if(l+1 == r) {
			int cmp = arr[l].compare(arr[r]);
			if(cmp > 0) {
				man tmp = arr[l];
				arr[l] = arr[r];
				arr[r] = tmp;
			}
			return;
		}
		
		int mid = (l+r)>>1;
		
		
		while(l<r) {
			while(arr[l].compare(arr[mid])<0) l++;
			while(arr[r].compare(arr[mid])>0) r--;
			
			if(l)
		}
	}
}

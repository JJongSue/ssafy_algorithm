package voidmu;

import java.util.Arrays;

public class 보이어무어 {
	static int skipTable[];
	public static void main(String[] args) {
		skipTable = new int[256];
		String str = "I loee yoe ve move. Plovse, love me.";
		String pattern = "love";
		int found = search(str, 0, pattern);
		System.out.println(found+"에서 패턴이 시작됩니다.");
		
	}
	
	static void getSkipTable(String pattern) {
		for(int i=0;i<skipTable.length;i++) skipTable[i]=pattern.length();
		for(int i=0;i<pattern.length();i++)
		{
			skipTable[pattern.charAt(i)] = pattern.length()-1-i;
		}
	}
	static int search(String str, int start_idx, String pattern) {
		boolean []is_visit = new boolean[str.length()];
		getSkipTable(pattern);
		int index = start_idx+pattern.length()-1;
		while(index<str.length()) {
			if(is_visit[index]) {
				index++;
				continue;
			}
			is_visit[index]=true;
			int s_idx=index;
			
			int p_idx=pattern.length()-1;
			while(p_idx>=0 && str.charAt(s_idx)==pattern.charAt(p_idx)) {
				s_idx--;
				p_idx--;
			}
			if(p_idx==-1) return s_idx+1;
			index = index - pattern.length() + 1 + p_idx;			
			index = index + skipTable[str.charAt(index)];
			
			
			//if(pattern.charAt(p_idx) != str.charAt(index)) index+=skipTable[pattern.charAt(index)];
			/*else {
				
			}*/
		}
		/*for(int i=0;i<str.length()-pattern.length();i++)
		{
			boolean is_ok=true;
			for(int j=pattern.length()-1;j>=0;j--)
			{
				if(pattern.charAt(j) != str.charAt(i+j))
				{
					i+=j;
					i+=skipTable[str.charAt(i)];
					is_ok=false;
					break;
				}
				if(is_ok) {
					return i;
				}
					
			}
		}*/
		//검사할 위치를 찾아서
		
		//검사할 위치가 문자열 끝을 넘아가지 않는다면 반복
		
		//현재 위치부터 검사를 시작해서 패턴이 모두 일치하는지 or 몇번째 문자에서 틀리는 지
		
		//틀리다면 틀린 위치로 이동
		//틀린 위치에서 문자에 해당하는 거리만큼 이동
		return -1;
	}
}

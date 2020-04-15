package day200405;

public class Solution2 {
	public int solution(String answer_sheet, String[] sheets) {
        int answer = 0;
        for(int i=0;i<sheets.length;i++) {
        	for(int j=i+1;j<sheets.length;j++) {
        		int tmp = 0;
        		int cnt=0;
        		int max_l = 0;
        		for(int k=0;k<answer_sheet.length();k++) {
        			if(sheets[i].charAt(k) == sheets[j].charAt(k) && sheets[i].charAt(k) != answer_sheet.charAt(k)) {
        				cnt++;
        				tmp++;
        				max_l = Math.max(tmp, max_l);
        			}else {
        				tmp=0;
        			}
        		}
        		answer = Math.max(answer, cnt+(max_l*max_l) );
        	}
        }
        return answer;
    }
}

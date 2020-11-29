package day200913;

public class Solution5 {
	//승리2 패배-2 블랙잭 승리3
	
	/*
	 * 게임규칙
	 * 플레이어1장 딜러1장뒤집
	 * 플레이어1장 딜러1장 보이게
	 * 플레이어가 21보다 작으면 1장 받을 수 있음/21넘어가면 패배
	 * 
	 * 플레이어가 카드를 받지않으면 카드공개후 딜러카드합이 17이상이 될때까지 카드받음
	 * 21넘으면 딜러패배 17이상이면 받기중지
	 * 그후 21에 가까운사람 승리 카드가 같으면 비김
	 * 
	 * 11,12,13 => 10    || 1은 1또는 11
	 */
	
	/*
	 * 딜러의 보이는 카드 1, 7이상 플레이어는 17이상이 될때까지 받음
	 * 4,5,6일경우 안받음
	 * 2,3일경우 12이상이 될때까지 받음
	 */
	static int size, now=0, map[];
	static int game() {
		int player = 0;
		int del = 0;
		int po =0;
		int delo = 0;
//		System.out.println("now : " + now);
		
		if(map[now] > 10) player += 10;
		else if(map[now] == 1) po++;
		else player += map[now];
		now++;
		if(now >= size) return 0;
		
		int secret = 0;
		if(map[now] > 10) secret = 10;
		else if(map[now] == 1) secret=1;
		else secret = map[now];
		now++;		
		if(now >= size) return 0;
		
		if(map[now] > 10) player += 10;
		else if(map[now] == 1) po++;
		else player += map[now];
		now++;
		if(now >= size) return 0;
		
		int open = 0;
		if(map[now] > 10) open = 10;
		else open = map[now];
		now++;
		
		if(po == 2) {
			player = 12;
		}else if(po == 1) {
			player += 11;
		}
		
		if(open == 1 && secret == 1) {
			del = 12;
		}else if(open == 1 || secret == 1) {
			del = open + secret + 10;
		}else {
			del = open+secret;
		}
		
		if(player == 21) {
			if(del == 21) return 0;
			return 3;
		}
		
		if(open == 4 || open == 5 || open == 6) {
			
		}else if(open == 1 || open >= 7) {
			while(player < 17) {
//				System.out.println(player);
				if(now >= size) return 0;
				int c = map[now];
				now++;
				if(c == 1) {
					if(player+11 <= 21) {
						player += 11;
					}else {
						player++;
					}
				}if(c >= 10) {
					player+=10;
				}else {
					player += c;
				}
				
			}
			if(player > 21) return -2;
		}else {
			while(player < 12) {
				if(now >= size) return 0;
				int c = map[now];
				now++;
				if(c == 1) {
					if(player+11 <= 21) {
						player += 11;
					}else {
						player++;
					}
				}if(c >= 10) {
					player+=10;
				}else {
					player += c;
				}
				
			}
			if(player > 21) return -2;
		}
		
		while(del < 17) {
			if(now >= size) return 0;
			int c = map[now];
			now++;
			if(c == 1) {
				if(del+11 <= 21) {
					del += 11;
				}else {
					del++;
				}
			}if(c >= 10) {
				del+=10;
			}else {
				del += c;
			}
		}
		if(del > 21) return 2;
		if(del < player) return 2;
		else if(del > player) return -2;
		return 0;
	}
	
	static int solution(int[] cards) {
		size = cards.length;
		map = new int[size];
		for(int i=0;i<size;i++) map[i] = cards[i];
		int ans = 0;
		while(now < size) {
			int tmp = game();
//			System.out.println(tmp);
			ans += tmp;
		}
		return ans;
	}
	public static void main(String[] args) {
//		int cards[] = {12, 7, 11, 6, 2, 12};
//		int cards[] = {1, 4, 10, 6, 9, 1, 8, 13};
//		int cards[] = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
		int cards[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		System.out.println(solution(cards));
	}
}

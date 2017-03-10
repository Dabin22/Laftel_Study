package dabin;

public class Output {
	private static final String P1WIN = "Player1 win";
	private static final String P2WIN = "Player2 win";
	private static final String DRAW = "Draw";
	private static final String ERROR = "error";
	
	private static final int HIGHCARD = 1;
	private static final int ONEPAIR = 2;
	private static final int TWOPAIRS = 3;
	private static final int THREEOFKIND = 4;
	private static final int STRAIGHT = 5;
	private static final int FLUSH = 6;
	private static final int FULLHOUSE = 7;
	private static final int FOUROFKIND = 8;
	private static final int STRAIGHTFLUSH = 9;
	private static final int ROYALFLUSH = 10;
	
	
	private CardPack p1,p2;
	
	

	
	public Output(CardPack p1, CardPack p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		rankCalculation(p1);
		rankCalculation(p2);
		compare();
		
	}
	
	//이제 각 계급의 값을 가지고 비교합니다.
	private void compare() {
		if(p1.rank>p2.rank){
			print(P1WIN);
		}else if(p1.rank<p2.rank){
			print(P2WIN);
		}else{
			//계급 값이 같을시 카드의 값을 비교합니다.
			detailCompare();
		}
		
	}

	//계급이 동일 하다면 카드 최고 값 리스트의 길이가 같으므로 하나씩 비교해 나가고 계속 같다면 무승부 판정을 내립니다.
	private void detailCompare() {
		int p1_max = 0;
		int p2_max = 0;
		boolean same = true;
		for(int i=0; i<p1.max.size(); i++){
			p1_max = p1.max.get(i);
			p2_max = p2.max.get(i);
	
			if(p1_max>p2_max){
				print(P1WIN);
				same = false;
				break;
			}else if(p1_max<p2_max){
				print(P2WIN);
				same = false;
				break;
			}
		}
		if(same){
			print(DRAW);
		}
		
	}

	
	//계급을 계산하는 
	private void rankCalculation(CardPack card) {
		//페어 여부를 먼저 판단합니다.
		calPair(card);
		//패어가 없을시 스트레이트와 플러쉬 여부를 계산합니다.
		if (card.rank == HIGHCARD) {
			calStraight(card);
		}else{
			for(int i=0; i<card.value.length;i++){
				if(card.value[i] >0 && !card.max.equals(i)){
					card.max.add(i);
				}
			}
		}
	}

	//플러쉬 여부를 판단한뒤 이제 연속성여부를 판단합니다. 그리고 특수 경우인 10JQKA 여부도 검사해서 판단합니다.
	private void calStraight(CardPack card) {
		int count = 0;
		isSameType(card);
		for (int i = 2; i <= 15; i++) {
			if (count == 5) {
				if (card.rank == FLUSH) {
					if (card.value[10] + card.value[11] + card.value[12] + card.value[13] +card.value[14] == 5) {
						card.rank = ROYALFLUSH;
					} else {
						card.rank = STRAIGHTFLUSH;
					}
				} else {
					card.rank = STRAIGHT;
				}
			} else if (i == 6 && count == 4 && card.value[14] == 1) {
				if (card.rank == FLUSH) {
					card.rank = STRAIGHTFLUSH;
				} else {
					card.rank = STRAIGHT;
				}
				card.max.remove(0);
				card.max.add(1);

			} else {
				if (card.value[i] == 1) {
					count++;
					card.max.add(0,i);
				} else {
					count--;
				}
			}
		}
	}

	private void calPair(CardPack card) {
		//4장 페어부터 차근차근 찾아봅니다.그리고 동일계급시 비교하는 최대값을 차곡차곡 저장합니다.
		for (int i = 14; i > 0; i--) {
			if (card.value[i] == 4) {
				card.rank = FOUROFKIND;
				card.max.add(i);
			} else {
				if (card.value[i] == 3) {
					if (card.value[0] == 1) {
						card.rank = FULLHOUSE;
						card.max.add(0, i);
					} else {
						card.value[0] = 3;
						card.rank = THREEOFKIND;
						card.max.add(i);
					}
				} else if (card.value[i] == 2) {
					if (card.value[0] == 1) {
						card.rank = TWOPAIRS;
						card.max.add(i);
					} else if (card.value[0] == 3) {
						card.rank = FULLHOUSE;
						card.max.add(i);
					} else {
						card.value[0] = 1;
						card.rank = ONEPAIR;
						card.max.add(i);
					}
				}
			}
		}
		
	}

	private void isSameType(CardPack card) {
		for (int p1 : card.type) {
			//플러쉬여부를 계산합니다.
			if (p1 == 5) {
				card.rank = 6;
			}
		}
	}

	public static void print(String result) {
		if (result.equals(ERROR)) {
			System.out.println("wrong value!");
		} else {
			System.out.println(result);
		}

	}
	
}
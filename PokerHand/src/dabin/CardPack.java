package dabin;

import java.util.ArrayList;

public class CardPack {
	public int value[];	//카드 값을 모아둔 배열입니다.
	public int type[];	//카드의 종류를 모아둔 배열입니다.
	public int rank=1;  //카드의 조합의 계급을 나타내는 값입니다.
	public ArrayList<Integer> max; //동급일시 비교하는 큰값부터 나오는 리스트입니다.
	
	
	
	public CardPack() {
		value = new int[15];
		type = new int[4];
		max = new ArrayList<>();
	}
	

}

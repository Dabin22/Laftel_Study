package dabin;

import java.util.ArrayList;

public class CardPack {
	public int value[];	//ī�� ���� ��Ƶ� �迭�Դϴ�.
	public int type[];	//ī���� ������ ��Ƶ� �迭�Դϴ�.
	public int rank=1;  //ī���� ������ ����� ��Ÿ���� ���Դϴ�.
	public ArrayList<Integer> max; //�����Ͻ� ���ϴ� ū������ ������ ����Ʈ�Դϴ�.
	
	
	
	public CardPack() {
		value = new int[15];
		type = new int[4];
		max = new ArrayList<>();
	}
	

}

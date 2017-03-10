package dabin;

public class Output {

	private String front;
	private static String NO_ONE = "no one ";
	private static String AND = " and ";
	private static String REST = " , ";
	private static String OTHERS = " others ";

	public void likes(String[] names) {
		//���� ���ڿ��� ���� �ƴ� ��
		if (names != null) {
			int size = names.length;
			if(size ==0){ //���� �ƴ����� �ƹ��͵� �Է¹��� �ʾ�����
				front = NO_ONE;
			}else if (size == 1) { 
				//�ϳ� �� ��
				front = names[0]+" ";
			} else if (size == 2) { 
				//�ΰ� �� ��
				front = names[0] + AND + names[1];
			} else {
				//�ΰ� �̻� �� ��
				front = names[0] + REST + names[1];
				if (size > 3) {
					//3�� �̻� �� ��
					front += (size - 2) + OTHERS;
				} else {
					//3�� �� ��
					front +=AND+ names[2];
				}
			}
		} else {
			// �� �϶� 
			front = NO_ONE;
		}

		print();
	}

	private void print() {
		//�ϼ��� ���
		System.out.println(front + "like this");
	}
}

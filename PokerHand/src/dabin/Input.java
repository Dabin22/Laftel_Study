package dabin;

public class Input {
	CardPack p1,p2;

	private static final String ERROR = "error";

	public static void main(String[] args) {
		Input input = new Input();
		
		String player1 = "As 8d Ad 8c 5d";
		String player2 = "Qh Qs Jd Kd Jc";
		input.input_card(player1, player2);
		
		player1 = "Ks Kc Jd Kd Jc";
		player2 = "Jh Js Jd Kd Jc";
		input.input_card(player1, player2);
		
		player1 = "Ad Kh Ac 7h 7d";
		player2 = "Ah Kh Ac 7h 7d";
		input.input_card(player1, player2);
		
	}
	
	
	//���� ���ڿ��� ������ ī�� ���� ���� ����� �����ϰ� Output ��ü�� ������ ī�� ���� ����� ����մϴ�.
	public void input_card(String player1, String player2) {
		p1 = new CardPack();
		p2 = new CardPack();
		if (player1.length() == 14 && player2.length() == 14) {
			for (int i = 0; i < player1.length(); i += 3) {
				
				selectValue(player1.charAt(i), true);
				selectValue(player2.charAt(i), false);
				selectType(player1.charAt(i + 1), true);
				selectType(player2.charAt(i + 1), false);
			}
			new Output(p1,p2);
			
		} else {
			Output.print(ERROR);
		}

	}
	
	//ī���� ���� ����ؼ� �迭�� �����ϱ����ؼ� ���ڸ� ���ڷ� ��ȯ�ϴ� �����Դϴ�.
	private void selectValue(char value, boolean isP1) {
		if (value >= '2' && value <= '9') {
			inputValue(value - '0', isP1);
		} else {
			switch (value) {
			case 'T':
				inputValue(value - 74, isP1);
				break;
			case 'J':
				inputValue(value - 63, isP1);
				break;
			case 'Q':
				inputValue(value - 69, isP1);
				break;
			case 'K':
				inputValue(value - 62, isP1);
				break;
			case 'A':
				inputValue(value - 51, isP1);
				break;
			default:
				Output.print(ERROR);
				break;
			}
		}
	}
	
	//��ȯ�� ���� �迭�� �ε��� ������ ����Ͽ� ���� �����մϴ�.
	private void inputValue(int value, boolean isP1) {
		if (isP1) {
			p1.value[value]++;
		} else {
			p2.value[value]++;
		}
	}

	/*
	 * ī�� ������ ���ڸ� �� ���� ���� ������ ��ȯ�մϴ�.
	 * c�� 0, d�� 1, h�� 2, s�� 3���� ��ȯ�մϴ�.
	*/
	private void selectType(char type, boolean isP1) {
		switch (type) {
		case 'c':
			inputType(type - 'c', isP1);
			break;
		case 'd':
			inputType(type - 'd' + 1, isP1);
			break;
		case 'h':
			inputType(type - 'h' + 2, isP1);
			break;
		case 's':
			inputType(type - 's' + 3, isP1);
			break;
		default:
			Output.print(ERROR);
			break;
		}

	}
	
	//������ ������ ��ȯ�� ���� �迭�� �ε��� �ּҷ� ����ؼ� ���� �����մϴ�.
	private void inputType(int type, boolean isP1) {
		if (isP1) {
			p1.type[type]++;
		} else {
			p2.type[type]++;
		}
	}


}

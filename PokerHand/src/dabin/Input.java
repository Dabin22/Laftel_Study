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
	
	
	//받은 문자열을 값따로 카드 종류 따로 나누어서 저장하고 Output 객체롤 보내서 카드 조합 계급을 계산합니다.
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
	
	//카드의 값만 계산해서 배열에 저장하기위해서 문자를 숫자로 변환하는 과정입니다.
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
	
	//변환된 값을 배열의 인덱스 값으로 사용하여 값을 저장합니다.
	private void inputValue(int value, boolean isP1) {
		if (isP1) {
			p1.value[value]++;
		} else {
			p2.value[value]++;
		}
	}

	/*
	 * 카드 종류의 문자를 각 고유 숫자 값으로 변환합니다.
	 * c는 0, d는 1, h는 2, s는 3으로 변환합니다.
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
	
	//고유의 값으로 변환된 것을 배열의 인덱스 주소로 사용해서 값을 저장합니다.
	private void inputType(int type, boolean isP1) {
		if (isP1) {
			p1.type[type]++;
		} else {
			p2.type[type]++;
		}
	}


}

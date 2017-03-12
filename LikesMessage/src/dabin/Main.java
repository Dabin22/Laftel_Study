package dabin;

public class Main {

	private String front;
	private static String NO_ONE = "no one ";
	private static String AND = " and ";
	private static String REST = " , ";
	private static String OTHERS = " others ";
	
	
	public static void main(String[] args) {
		Main main = new Main();
		
		// answer 1
		String[] answer1 = {};
		main.likesMessage(answer1);
		// answer 2
		String[] answer2 = { "Rafy" };
		main.likesMessage(answer2);
		// answer 3
		String[] answer3 = { "Rafy", "Ryan" };
		main.likesMessage(answer3);
		// answer 4
		String[] answer4 = { "Rafy", "Ryan", "Curian" };
		main.likesMessage(answer4);
		// answer 5
		String[] answer5 = { "Rafy", "Ryan", "Curian", "Billy" };
		main.likesMessage(answer5);
		// answer 6
		String[] answer6 = { "Rafy", "Ryan", "Ryan", "Curian", "Billy", "Green" };
		main.likesMessage(answer6);

	}
	
	
	public void likesMessage(String[] names) {
		//받은 문자열이 널이 아닐 시
		if (names != null) {
			int size = names.length;
			if(size ==0){ //0명일시
				front = NO_ONE;
			}else if (size == 1) { //한명일시
				front = names[0]+" ";
			} else if (size == 2) { //2명일시
				//두명일시
				front = names[0] + AND + names[1];
			} else if (size == 3) { //3명일시
				front += names[0] + REST + names[1]+ AND + names[2];
			} else if( size > 3){
				front += names[0] + REST + names[1]+ AND +(size - 2) + OTHERS;
			}else {
				errorPrint();
			}
			
		} else {
			errorPrint();
		}

		print();
	}


	private void print() {
		
		System.out.println(front + "like this");
	}

	private void errorPrint() {
		System.out.println("입력형태가 이상합니다.");
	}


}

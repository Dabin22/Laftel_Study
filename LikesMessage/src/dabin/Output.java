package dabin;

public class Output {

	private String front;
	private static String NO_ONE = "no one ";
	private static String AND = " and ";
	private static String REST = " , ";
	private static String OTHERS = " others ";

	public void likes(String[] names) {
		//받은 문자열이 널이 아닐 시
		if (names != null) {
			int size = names.length;
			if(size ==0){ //널이 아니지만 아무것도 입력받지 않았을때
				front = NO_ONE;
			}else if (size == 1) { 
				//하나 일 때
				front = names[0]+" ";
			} else if (size == 2) { 
				//두개 일 때
				front = names[0] + AND + names[1];
			} else {
				//두개 이상 일 때
				front = names[0] + REST + names[1];
				if (size > 3) {
					//3개 이상 일 때
					front += (size - 2) + OTHERS;
				} else {
					//3개 일 때
					front +=AND+ names[2];
				}
			}
		} else {
			// 널 일때 
			front = NO_ONE;
		}

		print();
	}

	private void print() {
		//완성된 출력
		System.out.println(front + "like this");
	}
}

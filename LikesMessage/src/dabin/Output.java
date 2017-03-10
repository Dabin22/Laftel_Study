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
			if(size ==0){ //문자열이 0이 아닐시 
				front = NO_ONE;
			}else if (size == 1) { 
				//한명일시
				front = names[0]+" ";
			} else if (size == 2) { 
				//두명일시
				front = names[0] + AND + names[1];
			} else {
				
				front = names[0] + REST + names[1];
				if (size > 3) {
					//3명 이상일시	
					front += (size - 2) + OTHERS;
				} else {
					//3명 일시
					front +=AND+ names[2];
				}
			}
		} else {
			
			front = NO_ONE;
		}

		print();
	}

	private void print() {
		
		System.out.println(front + "like this");
	}
}

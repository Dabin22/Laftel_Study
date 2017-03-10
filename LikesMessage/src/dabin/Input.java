package dabin;

//입력 부분입니다.
public class Input {

	public static void main(String[] args) {
		Output output = new Output();

		// answer 1
		String[] answer1 = {};
		output.likes(answer1);
		// answer 2
		String[] answer2 = {"Rafy"};
		output.likes(answer2);
		// answer 3
		String[] answer3 = { "Rafy", "Ryan" };
		output.likes(answer3);
		// answer 4
		String[] answer4 = { "Rafy", "Ryan", "Curian"};
		output.likes(answer4);
		// answer 5
		String[] answer5 = { "Rafy", "Ryan", "Curian", "Billy" };
		output.likes(answer5);
		// answer 6
		String[] answer6 = { "Rafy", "Ryan", "Ryan", "Curian", "Billy", "Green" };
		output.likes(answer6);
	}

}

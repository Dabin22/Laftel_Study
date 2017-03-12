package dabin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	Stack<Character> reverse_char = new Stack<>(); // 반전이 되야하는 문자를 저장하는 스택
	Stack<String> reverse_word; // 반전된 문자열을 저장하는 스택
	Queue<String> tagWord; // 태그문자열들을 저장한 큐
	ArrayList<String> sequence; // 태그 와 태그 아닌 문자의 순서를 저장한 리스트
	StringBuilder sentence; // 결과를 출력하는 문장

	boolean tag = false; // 태그안의 문자인지 아닌지를 구분하기 위한 부울변수
	String temp_word = ""; // 태그안의 글자들을 넣는 임시 문자열 변수

	// 초기화하는 부분
	private void init() {
		reverse_char = new Stack<>();
		reverse_word = new Stack<>();
		sequence = new ArrayList<>();
		tagWord = new LinkedList<>();
		sentence = new StringBuilder();
	}

	public static void main(String[] args) {
		Main main = new Main();

		String input = "The quick <font color=\"brown\">brown</font> fox jumps over the lazy dog";
		main.distinguish(input);
		input = "The quick fox jumps over the lazy dog";
		main.distinguish(input);
		input = "The quick <font color=\"brown\">bro<br>wn</font><hr> fox jumps over the lazy dog";
		main.distinguish(input);
	}

	// 입력받은 문장을 구분합니다. 반전이 필요한 부분은 스택에 태그는 큐에 그리고 그 순서를 리스트에 저장합니다.
	private void distinguish(String input) {
		init();
		int count = -1;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '<' && !tag) {
				reverse_char.push(input.charAt(i));
				if (sequence.isEmpty() || !sequence.get(count).equals("reverse")) {
					sequence.add("reverse");
					count++;
				}
			} else if (input.charAt(i) == '<') {
				if (!reverse_char.isEmpty()) {
					reverse();
				}
				tag = true;
				temp_word += input.charAt(i);
			} else if (input.charAt(i) == '>') {
				temp_word += input.charAt(i);
				tagWord.add(temp_word);
				tag = false;
				sequence.add("tag");
				count++;
				temp_word = "";
			} else {
				temp_word += input.charAt(i);
			}

		}
		if (!reverse_char.empty()) {
			reverse();
			if (sequence.isEmpty() || !sequence.get(count).equals("reverse")) {
				sequence.add("reverse");
				count++;
			}
		}
		combined();

	}

	//반전시킨 뒤에 스택에 저장합니다.
	private void reverse() {

		String temp_word = "";
		while (!reverse_char.isEmpty()) {
			temp_word += reverse_char.pop();
		}
		reverse_word.push(temp_word);

	}

	// 리스트에 적힌 순서를 토대로 큐와 스택에 문자열을 합칩니다.
	private void combined() {
		for (String str : sequence) {
			if (str.equals("tag")) {
				sentence.append(tagWord.poll());
			} else if (str.equals("reverse")) {
				sentence.append(reverse_word.pop());
			}
		}
		print();

	}

	private void print() {

		// 출력합니다.
		System.out.println(sentence);

	}

}

package dabin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Output {

	public void reverse(String sentence) {
		Stack<String> st = new Stack<>(); //문장 전체를 받는 스택
		Queue<String> q = new LinkedList<String>(); //태그부분을 받는 큐
		boolean tag = false; //태그안의 문자인지를 구분하기 위한 부울변수
		String temp_word = ""; //태그안의 글자들을 넣는 임시 문자열 변수
		
		
		for(int i =0; i<sentence.length(); i++){
			if(sentence.charAt(i)!='<'&& !tag){
				//태그가 아닌 글자들을 한글자씩 스택에 넣는다.
				st.push(sentence.charAt(i)+"");	
			}else{
				//임시 변수에 태그표시 안의 글자들을 넣는다.
				temp_word += sentence.charAt(i);
				tag = true;
				if(sentence.charAt(i) == '>'){
					tag = false;
					//'>'로 태그를 닫았을 시에 그 부분이 태그가 들어갈 곳이라고 스택에 태그라는 글자를 넣습니다.
					st.push("tag");
					//임시의 태그 문장을 큐에 넣습니다.
					q.offer(temp_word);
					//초기화
					temp_word ="";
				}
			}
			
		}
		
		print(st,q);
		
		
	}

	private void print(Stack<String> st,Queue<String> q) {
		String str = "";
		String result = "";
		while(!st.empty()){
			str = st.pop().toString();
			//스택에서 받은 문자열이 태그인지 아닌지 판별후
			if(str.equals("tag")){
				//태그이면 태그문자열을 결과에 추가합니다.
				result +=q.poll();
			}else{
				//아닐시 바로 결과에 추가합니다.
				result += str;
			}
			
		}
		
		//출력합니다.
		System.out.println(result);
		
	}

}

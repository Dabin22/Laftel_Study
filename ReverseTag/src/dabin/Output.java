package dabin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Output {

	public void reverse(String sentence) {
		Stack<String> st = new Stack<>(); //���� ��ü�� �޴� ����
		Queue<String> q = new LinkedList<String>(); //�±׺κ��� �޴� ť
		boolean tag = false; //�±׾��� ���������� �����ϱ� ���� �οﺯ��
		String temp_word = ""; //�±׾��� ���ڵ��� �ִ� �ӽ� ���ڿ� ����
		
		
		for(int i =0; i<sentence.length(); i++){
			if(sentence.charAt(i)!='<'&& !tag){
				//�±װ� �ƴ� ���ڵ��� �ѱ��ھ� ���ÿ� �ִ´�.
				st.push(sentence.charAt(i)+"");	
			}else{
				//�ӽ� ������ �±�ǥ�� ���� ���ڵ��� �ִ´�.
				temp_word += sentence.charAt(i);
				tag = true;
				if(sentence.charAt(i) == '>'){
					tag = false;
					//'>'�� �±׸� �ݾ��� �ÿ� �� �κ��� �±װ� �� ���̶�� ���ÿ� �±׶�� ���ڸ� �ֽ��ϴ�.
					st.push("tag");
					//�ӽ��� �±� ������ ť�� �ֽ��ϴ�.
					q.offer(temp_word);
					//�ʱ�ȭ
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
			//���ÿ��� ���� ���ڿ��� �±����� �ƴ��� �Ǻ���
			if(str.equals("tag")){
				//�±��̸� �±׹��ڿ��� ����� �߰��մϴ�.
				result +=q.poll();
			}else{
				//�ƴҽ� �ٷ� ����� �߰��մϴ�.
				result += str;
			}
			
		}
		
		//����մϴ�.
		System.out.println(result);
		
	}

}

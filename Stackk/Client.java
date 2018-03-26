package Stackk;

public class Client {

	public static void main(String[] args) throws Exception {

		Stackkk<Integer> st = new Stackkk<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(60);
		st.pop();
		st.push(50);
		st.display();

		st.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");

		st.evaluatePostfix("231*+9-");

	}

}

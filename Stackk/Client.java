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

		st.checkBalanceBrackets("{()}{[]");

		st.nextGreaterElement(new int[] { 4, 5, 2, 25 });

		st.display();
		Stackkk<Integer> stRev = st.reverseStackUsingRecurssion();
		stRev.display();

		System.out.println("*********");
		st.push(30);
		st.push(-5);
		st.push(18);
		st.push(14);
		st.push(-3);
		st.display();
		Stackkk<Integer> sortedSt = st.sortUsingRecursion();
		sortedSt.display();
	}

}

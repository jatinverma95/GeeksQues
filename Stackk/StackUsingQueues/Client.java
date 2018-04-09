package Stackk.StackUsingQueues;

public class Client {

	public static void main(String[] args) {
		StackkUsingQueue<Integer> st = new StackkUsingQueue<>();

		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);

		st.pop();
		st.pop();
		st.push(50);

		st.display();
	}

}

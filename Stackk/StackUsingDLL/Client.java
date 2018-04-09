package Stackk.StackUsingDLL;

public class Client {

	public static void main(String[] args) throws Exception {
		StackkUsingDLL st = new StackkUsingDLL();

		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		
		st.push(70);

		st.pop();
		st.pop();
		st.push(80);

		System.out.println(st.findMiddle());
		st.deleteMiddle();
		System.err.println(st.findMiddle());
		

	}
}

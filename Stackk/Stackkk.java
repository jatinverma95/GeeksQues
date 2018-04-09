package Stackk;

import java.util.Stack;

public class Stackkk<T> {
	protected T[] data;
	protected int tos;

	public Stackkk() {
		this(10);
	}

	public Stackkk(int cap) {
		data = (T[]) new Object[cap];
		tos = -1;
	}

	public void push(T item) throws Exception {
		if (data.length == tos) {
			throw new Exception("Stack full");
		}

		this.tos++;
		this.data[this.tos] = item;

	}

	public T pop() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		T rv = this.data[this.tos];
		this.tos--;
		return rv;

	}

	public T top() throws Exception {
		if (this.tos == -1) {
			throw new Exception("Stack empty");
		}
		T rv = this.data[this.tos];
		return rv;

	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		if (this.tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println(this.data[i]);
		}
		System.out.println("END");

	}

	public void infixToPostfix(String exp) throws Exception {
		Stackkk<Character> tempStack = new Stackkk<>();
		String res = "";
		while (exp.length() != 0) {
			char ch = exp.charAt(0);
			exp = exp.substring(1);

			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
				res += ch;
			} else if (ch == '(') {
				tempStack.push(ch);
			} else if ("+-*/^)".indexOf(ch) != -1) {
				if (ch == ')') {
					while (!tempStack.isEmpty() && tempStack.top() != '(') {
						res += tempStack.pop();
					}
					tempStack.pop();

				} else {

					if (!tempStack.isEmpty()) {
						int p = priorityFind(ch);
						int tosp = priorityFind(tempStack.top());
						if (p < tosp) {
							while (!tempStack.isEmpty() && p <= priorityFind(tempStack.top())) {
								res += tempStack.pop();
							}

						}
					}
					tempStack.push(ch);
				}
			}
		}

		while (tempStack.size() > 0) {
			res += tempStack.pop();
		}

		for (int i = 0; i < res.length(); i++) {
			System.out.print(res.charAt(i));
		}
		System.out.println();

	}

	public int priorityFind(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	public void evaluatePostfix(String exp) throws Exception {
		int res = 0;
		Stackkk<Integer> stackkk = new Stackkk<>();
		while (exp.length() != 0) {
			char ch = exp.charAt(0);
			exp = exp.substring(1);

			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
				stackkk.push(ch - '0');
			} else if ("+-*/".indexOf(ch) != -1) {
				int one = stackkk.pop();
				int two = stackkk.pop();
				int tempRes = evalFunc(ch, one, two);

				stackkk.push(tempRes);

			}

		}

		System.out.println(stackkk.pop());
	}

	public int evalFunc(char ch, int one, int two) {
		switch (ch) {
		case '+':
			return one + two;
		case '-':
			return two - one;
		case '*':
			return one * two;
		case '/':
			return two / one;
		case '^':
			return two ^ one;
		}
		return -1;
	}

	public void checkBalanceBrackets(String exp) throws Exception {

		Stackkk<Character> st = new Stackkk<>();

		while (exp.length() != 0) {
			char ch = exp.charAt(0);
			exp = exp.substring(1);

			if ("([{".indexOf(ch) != -1) {
				st.push(ch);
			} else if (")]}".indexOf(ch) != -1) {
				if (!st.isEmpty()) {
					char temp = st.pop();

					if ("([{".indexOf(temp) != ")]}".indexOf(ch)) {
						System.out.println("BracketNotMatching");
						return;
					}
				} else {
					System.out.println("ClosingMore");
					return;
				}
			}
		}

		if (st.size() != 0) {
			System.out.println("OpeningMore");
		} else {

			System.out.println("AllGood");
		}

	}

	public void nextGreaterElement(int[] arr) throws Exception {
		Stackkk<Integer> st = new Stackkk<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			int elem = arr[i];
			if (i == arr.length - 1) {
				st.push(elem);
				System.out.println(elem + "->" + -1);
			} else {
				while (!st.isEmpty() && st.top() < elem) {
					st.pop();
				}
				if (!st.isEmpty()) {
					System.out.println(elem + "->" + st.top());
				} else {
					System.out.println(elem + "->" + -1);
				}
				st.push(elem);
			}

		}

	}

	public Stackkk<Integer> reverseStackUsingRecurssion() throws Exception {
		if (this.isEmpty()) {
			return new Stackkk<>();
		}
		int one = (int) this.pop();
		Stackkk<Integer> st = reverseStackUsingRecurssion();
		Stackkk<Integer> rvst = insertAtBottom(st, one, false);
		return rvst;

	}

	private Stackkk<Integer> insertAtBottom(Stackkk<Integer> st, int one, boolean indic) throws Exception {
		if (st.isEmpty()) {
			if (!indic) {
				st.push(one);
				return st;
			}
			return new Stackkk<>();
		}

		int temp = st.pop();
		Stackkk<Integer> rst = insertAtBottom(st, one, true);
		if (rst.isEmpty()) {
			rst.push(one);
		}
		rst.push(temp);

		return rst;
	}

	public Stackkk<Integer> sortUsingRecursion() throws Exception {
		if (this.isEmpty()) {
			return new Stackkk<>();
		}
		int temp = (int) this.pop();

		Stackkk<Integer> st = sortUsingRecursion();
		Stackkk<Integer> rst = sortHelper(st, temp);

		return rst;

	}

	private Stackkk<Integer> sortHelper(Stackkk<Integer> st, int one) throws Exception {
		if (st.isEmpty()) {
			Stackkk<Integer> bst = new Stackkk<>();
			bst.push(one);
			return bst;
		}
		if (st.top() < one) {
			st.push(one);
			return st;
		} else {
			int temp = st.pop();
			Stackkk<Integer> stt = sortHelper(st, one);
			stt.push(temp);
			return stt;
		}
	}

	public void stockSpan(int[] stock) throws Exception {
		Stackkk<Integer> span = new Stackkk<>();
		int[] res = new int[stock.length];

		for (int i = 0; i < stock.length; i++) {
			if (span.isEmpty()) {
				span.push(i);
				res[i] = 1;
			} else {
				while (!span.isEmpty() && stock[span.top()] <= stock[i]) {
					span.pop();
				}
				res[i] = span.isEmpty() ? i + 1 : i - span.top();
				span.push(i);
			}
		}

		for (int i : res) {
			System.out.print(i + ",");
		}

	}
	
	
	

}

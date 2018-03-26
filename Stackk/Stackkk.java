package Stackk;

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
		for (int i = 0; i <= this.tos; i++) {
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

	public void checkBalanceBrackets(String exp) {

		Stackkk<Character> st = new Stackkk<>();

		while (exp.length() != 0) {
			char ch = exp.charAt(0);
			exp = exp.substring(1);

			if ("([{".indexOf(ch) != -1) {
				
			}
		}

	}

}

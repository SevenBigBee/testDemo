package cn.interview.code;

public class KeyWorldFinally {

	public static void main(String[] args) {
		System.out.println(new KeyWorldFinally().test());
		;

	}

	static int test() {
		int x = 1;
		try {
			System.out.println("return");
			return x;
		} finally {
//			++x;
			x = x + 1;
			System.out.println("Finally");
		}
	}
}

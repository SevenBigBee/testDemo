package cn.interview.code;

public class SplitClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st = "11111@102716";
//		String st = "信用卡@102716";
		String[] split = st.split("@102716");
		System.out.println(split);
	}

}

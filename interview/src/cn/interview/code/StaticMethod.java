package cn.interview.code;

public class StaticMethod {

	public static void main(String[] args) {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				Utils.t.hashCode();
				System.out.println(Utils.t.toString());
				Utils.set();
				Utils.get();
				System.out.println(Utils.tl);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Utils.t.hashCode();
				System.out.println(Utils.t.toString());
				Utils.set();
				Utils.get();
				System.out.println(Utils.tl);
			}
		}).start();
	}
	
	static class Utils{
		public static Test t = new Test();
		public static ThreadLocal<String> tl = new ThreadLocal();
		public static  void set() {
			tl.set(Thread.currentThread().getName());
		}
		
		public static void get() {
			System.out.println(tl.get().toString());
		}
		
	}
	
	static class Test{
		public Test() {
			System.out.println("初始化TEST");
		}
	}
}

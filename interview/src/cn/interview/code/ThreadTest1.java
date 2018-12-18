package cn.interview.code;

/**
 * 
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1 
 *
 * @author 	30456
 * @date 	2018年10月10日
 * @Copyright zhanjiang Lai Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * 30456			2018年10月10日			新增
 *
 * </pre>
 */
public class ThreadTest1 {

	int j ;
	/**
	 * 递增
	 * @author 	30456
	 * @date 	2018年10月10日
	 */
	public synchronized void asc() {
		for (int i=0; i < 100; i ++) {
			System.out.println(Thread.currentThread().getName() + "ASC:j= " + j++);
		}
	}
	
	/**
	 * 递减
	 * @author 	30456
	 * @date 	2018年10月10日
	 */
	public synchronized void desc() {
		for (int i=0; i < 100; i ++) {
			System.out.println(Thread.currentThread().getName() + "DESC:j=" + j--);
		}
	} 
	/** 
	 * 调用加法线程
	 */
	private class Asc implements Runnable {
		@Override
		public void run() {
			asc();
		}
	}
	
	/**
	 * 调用减法线程
	 */
	private class Desc implements Runnable{
		@Override
		public void run() {
			desc();
		}
	}
	
	public static void main(String[] args) {
		ThreadTest1 tt = new ThreadTest1();
		for (int i = 0; i < 2; i ++) {
			new Thread(tt.new Asc()).start();
			new Thread(tt.new Desc()).start();
		}
	}
}

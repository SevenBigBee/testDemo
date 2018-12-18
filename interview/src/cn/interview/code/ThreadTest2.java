package cn.interview.code;

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，
 * 接着再回到主线程又循环100，如此循环50次，请写出程序。
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
public class ThreadTest2 {
	public static void main(String[] args) {
		new ThreadTest2().init();
	}
	
	public void init() {
		Business business  = new Business();
		/**
		 * 开启子线程
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				/** 子线程执行业务逻辑 50次,第一次成功好,另外49次排队,等锁释放 **/
				for (int i=0; i < 50; i ++) {
					business.SubTread(i);
				}
			}}).start(); 
		for (int i=0; i < 50; i++) {
			business.MainThread(i);
		}
	}
	
	private class Business{
		boolean bShouldSub = true; //定义执行权
		/**
		 * 主线程业务逻辑
		 * @author 	30456
		 * @date 	2018年10月10日 
		 * @param i
		 */
		public synchronized void MainThread(int i) {
			if (bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/** 100次改为5次测试使用**/
			for (int j=0; j<5; j++) {
				System.out.println(Thread.currentThread().getName() + 
						":i= " + i + " ,j=" +j);
			}
			bShouldSub = true;
			this.notify();
		}
		
		/**
		 * 子线程业务逻辑
		 * @author 	30456
		 * @date 	2018年10月10日 
		 * @param i
		 */
		public synchronized void SubTread(int i) {
			if (!bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			/** 这里严格来说不是子程序循环了10次,而是执行了一个循环任务**/
			for (int j=0; j < 10; j++) {
				System.out.println(Thread.currentThread().getName() + 
						":i=" + i + " ,j=" + j);
			}
			
			bShouldSub = false;
			this.notify();
		}
	}
}

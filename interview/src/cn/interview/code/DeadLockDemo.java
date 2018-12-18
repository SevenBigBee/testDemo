package cn.interview.code;

/**
 * 
 * 编写个会进入死锁的程序
 *
 * @author 	30456
 * @date 	2018年10月18日
 * @Copyright zhanjiang Lai Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=================
 * Modifier			date			Content
 * 30456			2018年10月18日			新增
 *
 * </pre>
 */
public class DeadLockDemo {
	public static void main(String[] args) {
		Object lockA = new Object();
		Object lockB = new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(lockA) {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + " Have got loackA，going to sleep...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(threadName + " LoackA have waked up, want get to lockB");
					synchronized(lockB) {
						System.out.println(threadName + " Have got loackB");
					}
					System.out.println("after get lockB");
				}
				System.out.println("after get lockA");
			}
		}, "线程A").start();
		
		new Thread(new Runnable() {
			public void run() {
				synchronized (lockB) {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + "Have got lockB, going to sleep...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(threadName + "LockB have waked up , want to get lockA");
					synchronized (lockA) {
						System.out.println(threadName + " Have got loackA");

					}
				}
			}
		},"线程B").start();
	}
}

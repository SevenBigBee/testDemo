package cn.interview.code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * synchronized和java.util.concurrent.locks.Lock的异同 
 * 主要相同点：Lock能完成synchronized所实现的所有功能
 * 主要不同点：Lock有比synchronized更精确的线程语义和更好的性能。
 * synchronized会自动释放锁，而Lock一定要求程序员手工释放，并且必须在finally从句中释放。
 * Lock还有更强大的功能，例如，它的tryLock方法可以非阻塞方式去拿锁。
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
public class ThreadTest {
	int j;
	private Lock lock = new ReentrantLock();
	private class Subtractor implements Runnable{
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					Thread th=Thread.currentThread();
//					System.out.println("Tread name:"+th.getName());
					System.out.println("Tread name:"+th.getName() + "  j--=" + j --);
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	private class Adder implements Runnable{
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					Thread th=Thread.currentThread();
					System.out.println("Tread name:"+th.getName() + "  j++=" + j++);
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTest tt = new ThreadTest();
		for (int i=0; i < 2; i++) {
			new Thread(tt.new Adder()).start();
			new Thread(tt.new Subtractor()).start();
		}
	}
}

package cn.itcast_07;

	public class ThreadTest implements Runnable {
	    int number = 10;

	    public void firstMethod() throws Exception {
	        synchronized (this) {
	            number += 100;
	            System.out.println(number+Thread.currentThread().getName());
	        }
	    }

	    public void secondMethod() throws Exception {
	        synchronized (this) {
	            /**
	             * (��Ϣ2S,�����߳�)
	             * ����֤��ǰ�̶߳���Ļ�����ռ��ʱ,
	             * �Ƿ񱻿��Է�������ͬ�������
	             */
//	            Thread.sleep(2000);
	            System.out.println(Thread.currentThread().getName());
	            this.wait(2000);
	            number *= 200;
	        }
	    }

	    @Override
	    public void run() {
	        try {
	            firstMethod();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        ThreadTest threadTest = new ThreadTest();
	        Thread thread = new Thread(threadTest);
	        thread.start();
	        threadTest.secondMethod();
	        System.out.println(threadTest.number);
	    }
}

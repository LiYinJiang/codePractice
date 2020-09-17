package net.eryingzhang.train.o2;

public final class Singleton4 {

	private Singleton4() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton4 instance() {
		return inter.instance;
	}
	
	/**只有被使用时才加载内部类
	 * */
	private static class inter {
		private static Singleton4 instance = new Singleton4();

	}
}

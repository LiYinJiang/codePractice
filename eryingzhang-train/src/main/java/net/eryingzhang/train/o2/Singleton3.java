package net.eryingzhang.train.o2;

/*
 * 缩小锁范围，加锁前后进行判断
 * */
public final class Singleton3 {
	private Singleton3() {

	}

	private static Singleton3 instance;

	public static Singleton3 instance() {
		if (instance == null) {

			synchronized (Singleton3.class) {
				if (instance == null)
					instance = new Singleton3();
			}
		}

		return instance;
	}
}

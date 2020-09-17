package net.eryingzhang.train.o2;
/**
 * 单线程安全
 * */
public final class Singleton1 {
	private Singleton1() {

	}

	private static Singleton1 instance;

	public static Singleton1 instance() {
		if (instance == null)
			instance = new Singleton1();
		return instance;
	}
}

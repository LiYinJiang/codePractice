package net.eryingzhang.train.o2;

/**
 * 静态和 同步双重 校验 ，效率不高
 * */
public final class Singleton2 {
	private Singleton2() {

	}

	private static Singleton2 instance;

	public static synchronized Singleton2 instance() {
		  
		if (instance == null)
			instance = new Singleton2();
		
		return instance;
	}
	
}

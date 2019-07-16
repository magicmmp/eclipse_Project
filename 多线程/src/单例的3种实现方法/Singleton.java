package 单例的3种实现方法;

//饿汉式
//没有线程安全问题，推荐使用
class Singleton {
	// 1,私有构造函数
	private Singleton() {
	}

	// 2,创建本类对象
	private static Singleton s = new Singleton();

	// 3,对外提供公共的访问方法
	public static Singleton getInstance() {
		return s;
	}

	
	
	  public static void print() { System.out.println("11111111111"); }
	 
}


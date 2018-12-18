package cn.interview.code.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	/** 通过类装载器获取Car类对象 **/
	public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		@SuppressWarnings("unchecked")
		Class<Car> loadClass = (Class<Car>)contextClassLoader.loadClass("cn.interview.code.reflect.Car");
		/** 获取类的默认构造器对像并通过它实例化Car**/
		Constructor<Car> declaredConstructor = loadClass.getDeclaredConstructor((Class[])null);
		Car car = declaredConstructor.newInstance();
		
		/** 通过反射方法设置属性**/
		Method setBrand = loadClass.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = loadClass.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		Method setMaxSpeed = loadClass.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 300);
		return car;
	}
	
	/** 通过有参构造获取Car对象
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException **/
	public static Car initByMethodConst() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> calzz = Thread.currentThread().getContextClassLoader().loadClass("cn.interview.code.reflect.Car");
		Constructor<?> cont = calzz.getDeclaredConstructor(String.class, String.class, int.class);
		Car car = (Car)cont.newInstance("宝马320", "白色", 300);
		return car;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Car initByDefaultConst = initByDefaultConst();
		initByDefaultConst.introduce();
		
		Car initByMethodConst = initByMethodConst();
		initByMethodConst.introduce();
	}
}

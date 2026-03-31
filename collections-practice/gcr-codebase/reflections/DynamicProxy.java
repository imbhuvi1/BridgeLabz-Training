package gcr_codebase.reflections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
	void sayHello(String name);
}

class Greet implements Greeting {
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
}

class LoggingProxy implements InvocationHandler {

	private final Object target;

	public LoggingProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Calling method: " + method.getName());
		return method.invoke(target, args);
	}

}

public class DynamicProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeting greeting = new Greet();
		Greeting proxy = (Greeting) Proxy.newProxyInstance(Greet.class.getClassLoader(), new Class[] { Greeting.class },
				new LoggingProxy(greeting));
		proxy.sayHello("Reflection");
	}

}

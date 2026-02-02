package gcr_codebase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class Calculator {

	@CacheResult
	public int square(int n) {
		return n * n;
	}
}

class SimpleCache {

	static Map<Integer, Integer> cache = new HashMap<>();

	public static int execute(Calculator obj, String methodName, int input) throws Exception {
		Method method = obj.getClass().getMethod(methodName, int.class);
		if (method.isAnnotationPresent(CacheResult.class)) {
			if (cache.containsKey(input)) {
				return cache.get(input);
			}
			int result = (int) method.invoke(obj, input);
			cache.put(input, result);
			return result;
		}
		return (int) method.invoke(obj, input);
	}
}

public class CacheResultAnnotation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		System.out.println(SimpleCache.execute(calc, "square", 5));
		System.out.println(SimpleCache.execute(calc, "square", 5));
		System.out.println(SimpleCache.execute(calc, "square", 6));
	}

}
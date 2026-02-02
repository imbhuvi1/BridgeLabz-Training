package gcr_codebase.reflections;

import java.lang.reflect.Field;

class Configuration {

	private static String API_KEY = "KEY1";

	public static void printKey() {
		System.out.println(API_KEY);
	}
}

public class ModifyStaticField {

	public static void main(String[] args)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Configuration.printKey();
		Field field = Configuration.class.getDeclaredField("API_KEY");
		field.setAccessible(true);
		field.set(null, "KEY2");
		Configuration.printKey();
	}

}
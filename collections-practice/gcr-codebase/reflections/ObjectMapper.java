package gcr_codebase.reflections;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class ObjectMapperUtil {
	public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
		T instance = clazz.getDeclaredConstructor().newInstance();
		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			Field field = clazz.getDeclaredField(entry.getKey());
			field.setAccessible(true);
			field.set(instance, entry.getValue());
		}
		return instance;
	}
}

class User {
	private String name;
	private int age;
	
	public void display() {
		System.out.println(name + " : " + age);
	}
}

public class ObjectMapper {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Govind");
		map.put("age", 23);
		User user = ObjectMapperUtil.toObject(User.class, map);
		user.display();
	}

}

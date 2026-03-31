package gcr_codebase.functional_interface;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
@interface Sensitive {
}

@Sensitive
class Info {
	private String info;

	Info(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return info;
	}
}

class PublicInfo {
	private String info;

	PublicInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return info;
	}
}

public class SensitiveDataTagging {

	public static void show(Object obj) {
		if (obj.getClass().isAnnotationPresent(Sensitive.class)) {
			System.out.println("Encrypting sensitive data: " + obj);
		} else {
			System.out.println(obj);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info info = new Info("Private Info");
		PublicInfo publicInfo = new PublicInfo("Public Info");
		show(info);
		show(publicInfo);
	}

}
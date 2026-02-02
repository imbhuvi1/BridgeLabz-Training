package gcr_codebase.reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
	String name();
}

@Author(name = "Zangwill")
class AuthorClass {
}

public class RetrieveAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> author = AuthorClass.class;

		if (author.isAnnotationPresent(Author.class)) {
			Author authorName = author.getAnnotation(Author.class);
			System.out.println(authorName.name());
		}
	}

}

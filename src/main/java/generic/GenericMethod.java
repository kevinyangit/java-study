package generic;

import lombok.Book;

public class GenericMethod {

	public <T> T newInstant(Class<T> c) {
		try {
			T newInstance = c.newInstance();
			return newInstance;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T newInstant2(T c) {
		return c;

	}

	public static void main(String[] args) {
		GenericMethod genericMethod = new GenericMethod();
		Book newInstant = genericMethod.newInstant(Book.class);
		System.out.println(newInstant.toString());

		newInstant.setAge("11");
		Book newInstant2 = genericMethod.newInstant2(newInstant);
		System.out.println(newInstant2.toString());
	}
}

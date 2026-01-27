package gcr_codebase.collections.list;

import java.util.*;

public class ReverseList {

	public static <T> void reverse(List<T> list) {
		for (int i = 0; i <= list.size() / 2; i++) {
			T temp = list.get(i);
			list.set(i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, temp);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5);
		List<String> linkedList = new LinkedList<String>(Arrays.asList("A", "B", "C", "D", "E"));
		reverse(arrayList);
		reverse(linkedList);
		System.out.println(arrayList);
		System.out.println(linkedList);
	}

}

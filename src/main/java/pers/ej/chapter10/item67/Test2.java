// More complex test of ObservableSet - Page 267
package pers.ej.chapter10.item67;

import java.util.HashSet;

public class Test2 {
	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<Integer>(
				new HashSet<Integer>());

		set.addObserver(new SetObserver<Integer>() {
			public void added(ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
				// 这里调用了remove方法，而之前一步是在遍历，所以会报异常
				if (e == 23)
					s.removeObserver(this);
			}
		});

		for (int i = 0; i < 100; i++)
			set.add(i);
	}
}

package com.java8;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {
	private Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		if (this.lineSpliterator.tryAdvance(line -> {
			System.out.println(line);
			this.name = line;
		}) && this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line))
				&& this.lineSpliterator.tryAdvance(line -> this.city = line)) {
			Person person = new Person(age, name, city);
			action.accept(person);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Spliterator<Person> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}

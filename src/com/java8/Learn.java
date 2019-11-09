package com.java8;

import java.awt.List;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Learn {
	public static void main(String[] args) {
		/*
		 * int[] number = { 1, 2, 3, 4, 5, 6, 7 }; int min =
		 * IntStream.of(number).distinct().sorted().limit(3).sum();
		 * System.out.println(min); IntStream.range(1,
		 * 100).forEach(System.out::println); IntStream.range(50,
		 * 100).boxed().collect(Collectors.toList());
		 * 
		 * 
		 * Predicate<Integer> predicate = new Predicate<Integer>() {
		 * 
		 * @Override public boolean test(Integer t) {
		 * 
		 * return t > 4; } };
		 * 
		 * 
		 * IntPredicate predicate = new IntPredicate() {
		 * 
		 * @Override public boolean test(int value) {
		 * 
		 * return value > 4; } };
		 * 
		 * // IntToDoubleFunction
		 * IntStream.of(number).filter(predicate).forEach(System.out::println);
		 * 
		 * java.util.List<Person> person = new ArrayList<Person>(); person.add(new
		 * Person(1, "rbc")); person.add(new Person(3, "abc")); person.add(new Person(2,
		 * "xc")); person.forEach(e -> { System.out.println(e.getName()); });
		 * System.out.println("0-----------------------");
		 * person.sort(Comparator.comparing(Person::getName).thenComparing(Person::getId
		 * )); person.forEach(e -> { System.out.println(e.getName()); });
		 */

		Path file = Paths.get("pepole.txt");
		try (Stream<String> lines = Files.lines(file)) {
			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<Person> pepolesp = new PersonSpliterator(lineSpliterator);

			Stream<Person> pepole = StreamSupport.stream(pepolesp, false);
			pepole.forEach(System.out::println);

		} catch (Exception e2) {
			// TODO: handle exception
		}

	}
}

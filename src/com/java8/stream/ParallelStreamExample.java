package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		// thread limit to parallel computation.
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		List<String> strings = new ArrayList<>();

		List<String> list = Stream.iterate("+", s -> s + "+").parallel().limit(1000)
				// .peek(s -> System.out.println(s + " processed in the thread " +
				// Thread.currentThread().getName()))
				// .forEach(s -> strings.add(s));
				.collect(Collectors.toList());
		System.out.println(list.size());
	}
}

package com.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalStream {
	public static void main(String[] args) {
		/*
		 * List<Double> result = new ArrayList<Double>();
		 * ThreadLocalRandom.current().doubles(10_000).boxed().parallel()
		 *
		 * 
		 * .forEach(d -> NewMath.inv(d) .ifPresent(inv -> NewMath.sqrt(inv) .ifPresent(s
		 * -> result.add(s))));
		 * 
		 * System.out.println(result.size());
		 */
		Function<Double, Stream<Double>> flatMapper = d -> NewMath.inv(d).flatMap(inv -> NewMath.sqrt(inv))
				.map(sqrt -> Stream.of(sqrt)).orElseGet(() -> Stream.empty());

		List<Double> list = ThreadLocalRandom.current().doubles(10_000)
		.parallel()
		.boxed().flatMap(flatMapper).collect(Collectors.toList());
		
		System.out.println(list.size());
	}
}

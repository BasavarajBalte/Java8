package com.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.java8.Person;
import com.java8.PersonSpliterator;

public class ParallelStreamLearn {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("people.txt");
		Stream<String> streamLines = Files.lines(path);
		Spliterator<String> spliteratorStream = streamLines.spliterator();
		Spliterator<Person> personSpliterator =  new PersonSpliterator(spliteratorStream);
		//parallel not applicable for stateful stream
		//state less stream   stream.filter(a->a>10) filter not required outside information
		//state full stream stream.skip(2).limit(3)  this need counter and all element access to know while processing.
		Stream<Person> personObjStream = StreamSupport.stream(personSpliterator, false);
		personObjStream.parallel().filter(p -> p.getAge() > 33).sorted()
		.forEach(System.out::println);
		
		
		
	}
}

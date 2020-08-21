package com.nick.blog.streams.standard.terminal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S41_collect_collectingAndThen {
    public static void main(String... args) {
        System.out.print("\n1.collectingAndThen(List, synchronizedList): ");
        List<String> synchronizedList1 = Stream.of("a", "b", "c")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::synchronizedList));
        System.out.print(synchronizedList1);        //prints: [a, b, c]

        System.out.print("\n2.collect(.toList) => synchronizedList()   : ");
        List<String> l = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> synchronizedList2 = Collections.synchronizedList(l);
        System.out.println(synchronizedList2);        //prints: [a, b, c]

        List<Person> list = List.of(new Person("John", "Denver", 25),
                                    new Person("Jane", "Denver", 24),
                                    new Person("Bob", "Denver", 23),
                                    new Person("Bill", "Boston", 25),
                                    new Person("Bob", "Chicago", 24),
                                    new Person("Jill", "Boston", 23));

        System.out.print("\n1.groupingBy(City, MaxAgePerson): ");
        Map<String, Optional<Person>> map1 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors
                        .maxBy(Comparator.comparing(Person::getAge))));
        System.out.print(map1);  //prints: {Chicago=Optional[Person{name='Bob', city='Chicago', age=24}],
                                 //         Denver=Optional[Person{name='John', city='Denver', age=25}],
                                 //         Boston=Optional[Person{name='Bill', city='Boston', age=25}]}

        System.out.print("\n2.groupingBy(City, MaxAgeName)  : ");
        Map<String, String> map2 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getAge)),
                        p -> p.orElse(new Person("x", "x", 0)).getName())));
        System.out.print(map2);  //prints: {Chicago=Bob, Denver=John, Boston=Bill}
    }

    private static class Person {
        private String name, city;
        private int age;

        public Person(String name, String city, int age) {
            this.name = name;
            this.city = city;
            this.age = age;
        }
        public String getCity() { return city; }
        public String getName() { return name; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return "Person{name='" + name +
               "', city='" + city + "', age=" + age + '}';
        }
    }

}

package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class S38_collect_map_reducing {
    public static void main(String... args) {
        List<Person> list = List.of(new Person("John", "Denver", 25),
                                    new Person("Jane", "Denver", 24),
                                    new Person("Bob", "Denver", 23),
                                    new Person("Bill", "Boston", 25),
                                    new Person("Bob", "Chicago", 24),
                                    new Person("Jill", "Boston", 23));

        System.out.print("\n1.reducing(BinaryOperator): ");
        Optional<Person> oldestOptional1 = list.stream()
                .collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));
        System.out.print(oldestOptional1.get());  //prints: Person{name='John', city='Denver', age=25}

        System.out.print("\n2.reduce(BinaryOperator)  : ");
        Optional<Person> oldestOptional2 = list.stream().reduce(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println(oldestOptional2.get());  //prints: Person{name='John', city='Denver', age=25}

        System.out.print("\n3.groupingBy(city): ");
        Map<String, List<Person>> map31 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.print(map31);  //prints: {Chicago=[Person{name='Bob', city='Chicago', age=24}],
                                   //          Denver=[Person{name='John', city='Denver', age=25},
                                   //                  Person{name='Jane', city='Denver', age=24},
                                   //                  Person{name='Bob', city='Denver', age=23}],
                                   //          Boston=[Person{name='Bill', city='Boston', age=25},
                                   //                  Person{name='Jill', city='Boston', age=23}]}

        System.out.print("\n3.partitioningBy(isDenver): ");
        Map<Boolean, List<Person>> map32 = list.stream()
                .collect(Collectors.partitioningBy(p -> "Denver".equals(p.getCity())));
        System.out.println(map32);  //prints: {false=[Person{name='Bill', city='Boston', age=25},
                                    //                Person{name='Bob', city='Chicago', age=24},
                                    //                Person{name='Jill', city='Boston', age=23}],
                                    //          true=[Person{name='John', city='Denver', age=25},
                                    //                Person{name='Jane', city='Denver', age=24},
                                    //                Person{name='Bob', city='Denver', age=23}]}

        System.out.print("\n4.groupingBy(city, reducing(BinaryOperator)        : ");
        Map<String, Optional<Person>> map4 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map4);  //prints: {Chicago=Optional[Person{name='Bob', city='Chicago', age=24}],
                                 //          Denver=Optional[Person{name='John', city='Denver', age=25}],
                                 //          Boston=Optional[Person{name='Bill', city='Boston', age=25}]}

        System.out.print("\n5.partitioningBy(isDenver, reducing(BinaryOperator): ");
        Map<Boolean, Optional<Person>> map5 = list.stream()
                .collect(Collectors.partitioningBy(p -> "Denver".equals(p.getCity()),
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.println(map5);  //prints: {false=Optional[Person{name='Jane', city='Denver', age=24}],
                                  //          true=Optional[Person{name='John', city='Denver', age=25}]}

        System.out.print("\n6.reducing(Identity, BinaryOperator): ");
        Map<String, Person> map6 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(new Person("Init", "Init", 0),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map6);  //prints: {Chicago=Person{name='Bob', city='Chicago', age=24},
                                 //         Denver=Person{name='John', city='Denver', age=25},
                                 //         Boston=Person{name='Bill', city='Boston', age=25}}

        System.out.print("\n7.reduce(Identity, BinaryOperator)  : ");
        Map<Boolean, Person> map7 = list.stream()
                .collect(Collectors.partitioningBy(p -> "Denver".equals(p.getCity()), Collectors.reducing(new Person("Init", "Init", 0),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.println(map7);  //prints: {false=Person{name='Jane', city='Denver', age=24},
                                   //          true=Person{name='John', city='Denver', age=25}}

        System.out.print("\n8.groupingBy(city, reducing(Identity, BinaryOperator)        : ");
        Map<String, Person> map8 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(new Person("Init", "Init", 200),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map8);  //prints: {Chicago=Person{name='Init', city='Init', age=200},
                                 //         Denver=Person{name='Init', city='Init', age=200},
                                 //         Boston=Person{name='Init', city='Init', age=200}}

        System.out.print("\n9.partitioningBy(isDenver, reducing(Identity, BinaryOperator): ");
        Map<Boolean, Person> map9 = list.stream()
                .collect(Collectors.partitioningBy(p -> "Denver".equals(p.getCity()), Collectors.reducing(new Person("Init", "Init", 200),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.println(map9);  //prints: {false=Person{name='Jane', city='Denver', age=24},
                                   //          true=Person{name='John', city='Denver', age=25}}

        System.out.print("\n10.reducing(Identity, Function, BinaryOperator): ");
        int theOldestAge10 = list.stream()
                .collect(Collectors.reducing(0, Person::getAge, BinaryOperator.maxBy(Comparator.comparingInt(i -> i))));
        System.out.print(theOldestAge10);        //prints: 25

        System.out.print("\n11.map().reduce(Identity, BinaryOperator)      : ");
        int theOldestAge11 = list.stream().map(Person::getAge).reduce(0, BinaryOperator.maxBy(Comparator.comparingInt(i -> i)));
        System.out.print(theOldestAge11);        //prints: 25

        System.out.print("\n12.groupingBy(city, reducing(Identity, Function, BinaryOperator)    : ");
        Map<String, Integer> map12 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(0, Person::getAge,
                        BinaryOperator.maxBy(Comparator.comparingInt(i -> i)))));
        System.out.print(map12);  //prints: {Chicago=24, Denver=25, Boston=25}

        System.out.print("\n13.groupingBy(isDenver, reducing(Identity, Function, BinaryOperator): ");
        Map<Boolean, Integer> map13 = list.stream()
                .collect(Collectors.groupingBy(p -> "Denver".equals(p.getCity()), Collectors.reducing(0, Person::getAge,
                        BinaryOperator.maxBy(Comparator.comparingInt(i -> i)))));
        System.out.println(map13);  //prints: {false=24, true=25}
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
        public int getAge() { return age; }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

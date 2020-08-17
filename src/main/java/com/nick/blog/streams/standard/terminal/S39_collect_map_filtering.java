package com.nick.blog.streams.standard.terminal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class S39_collect_map_filtering {  //since Java 9
    public static void main(String... args) {
        List<Person> list = List.of(new Person("John", "Denver", 25),
                                    new Person("Jane", "Denver", 24),
                                    new Person("Bob", "Denver", 23),
                                    new Person("Bill", "Boston", 25),
                                    new Person("Bob", "Chicago", 24),
                                    new Person("Jill", "Boston", 23));

        System.out.print("\n1.filtering(age==25, toList()): ");
        List<Person> list1 = list.stream()
                .collect(Collectors.filtering(p -> p.getAge() == 25, Collectors.toList()));
        System.out.print(list1);  //prints: [Person{name='John', city='Denver', age=25}, Person{name='Bill', city='Boston', age=25}]

        System.out.print("\n2.filter(age==25).toList()    : ");
        List<Person> list2 = list.stream().filter(p -> p.getAge() == 25).collect(Collectors.toList());
        System.out.println(list2);  //prints: [Person{name='John', city='Denver', age=25}, Person{name='Bill', city='Boston', age=25}]

        System.out.print("\n3.groupingBy(city, .filtering(age==25, toList()))        : ");
        Map<String, List<Person>> map3 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.filtering(p -> p.getAge() == 25, Collectors.toList())));
        System.out.print(map3);  //prints: {Chicago=[],
                                   //        Denver=[Person{name='John', city='Denver', age=25}],
                                   //        Boston=[Person{name='Bill', city='Boston', age=25}]}

        System.out.print("\n4.partitioningBy(isDenver, .filtering(age==25, toList())): ");
        Map<Boolean, List<Person>> map4= list.stream()
                .collect(Collectors.partitioningBy(p -> "Denver".equals(p.getCity()), Collectors.filtering(p -> p.getAge() == 25, Collectors.toList())));
        System.out.println(map4);  //prints: {false=[Person{name='Bill', city='Boston', age=25}],
                                    //         true=[Person{name='John', city='Denver', age=25}]}
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

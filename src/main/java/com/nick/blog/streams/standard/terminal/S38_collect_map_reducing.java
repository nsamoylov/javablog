package com.nick.blog.streams.standard.terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class S38_collect_map_reducing {
    public static void main(String... args) {
        List<Person> list = List.of(new Person("John", "Denver", Gender.Male, 25),
                                    new Person("Jane", "Denver", Gender.Female, 24),
                                    new Person("Bob", "Denver", Gender.Male, 23),
                                    new Person("Bill", "Boston", Gender.Male, 25),
                                    new Person("Bob", "Chicago", Gender.Male, 24),
                                    new Person("Jill", "Boston", Gender.Female, 23));

        System.out.print("\n1.reducing(BinaryOperator): ");
        Optional<Person> oldestOptional1 = list.stream()
                .collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));
        System.out.print(oldestOptional1.get());  //prints: Person{name='John', city='Denver', gender=Male, age=25}

        System.out.print("\n1.reduce(BinaryOperator)  : ");
        Optional<Person> oldestOptional2 = list.stream().reduce(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println(oldestOptional2.get());  //prints: Person{name='John', city='Denver', gender=Male, age=25}

        System.out.print("\n2.reducing(Identity, BinaryOperator): ");
        Person theOldest1 = list.stream()
                .collect(Collectors.reducing(new Person(), BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));
        System.out.print(theOldest1);  //prints: Person{name='John', city='Denver', gender=Male, age=25}

        System.out.print("\n2.reduce(Identity, BinaryOperator)  : ");
        Person theOldest2 = list.stream().reduce(new Person(), BinaryOperator.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println(theOldest2);  //prints: Person{name='John', city='Denver', gender=Male, age=25}

        System.out.print("\n3.reducing(Identity, Function, BinaryOperator): ");
        int theOldestAge1 = list.stream()
                .collect(Collectors.reducing(0, Person::getAge, (a1,a2)-> a1 > a2 ? a1 : a2));
        System.out.print(theOldestAge1);        //prints: 25

        System.out.print("\n3.map().reduce(Identity, BinaryOperator)      : ");
        int theOldestAge2 = list.stream().map(Person::getAge).reduce(0, (x, y) -> y > x ? y : x);
        System.out.println(theOldestAge2);        //prints: 25

        System.out.print("\n4.groupingBy(city): ");
        Map<String, List<Person>> map4 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        System.out.print(map4);  //prints: {Chicago=[Person{name='Bob', city='Chicago', gender=Male, age=24}],
                                 //          Denver=[Person{name='John', city='Denver', gender=Male, age=25},
                                 //                  Person{name='Jane', city='Denver', gender=Female, age=24},
                                 //                  Person{name='Bob', city='Denver', gender=Male, age=23}],
                                 //          Boston=[Person{name='Bill', city='Boston', gender=Male, age=25},
                                 //                  Person{name='Jill', city='Boston', gender=Female, age=23}]}

        System.out.print("\n5.groupingBy(city, reducing(BinaryOperator): ");
        Map<String, Optional<Person>> map5 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map5);  //prints: {Chicago=Optional[Person{name='Bob', city='Chicago', gender=Male, age=24}],
                                 //          Denver=Optional[Person{name='John', city='Denver', gender=Male, age=25}],
                                 //          Boston=Optional[Person{name='Bill', city='Boston', gender=Male, age=25}]}

        System.out.print("\n6.groupingBy(city, reducing(Identity, BinaryOperator): ");
        Map<String, Person> map6 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(new Person(), BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map6);  //prints: {Chicago=Person{name='Bob', city='Chicago', gender=Male, age=24},
                                 //          Denver=Person{name='John', city='Denver', gender=Male, age=25},
                                 //          Boston=Person{name='Bill', city='Boston', gender=Male, age=25}}

        System.out.print("\n7.groupingBy(city, reducing(Identity, Function, BinaryOperator): ");
        Map<String, Integer> map7 = list.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.reducing(0, Person::getAge, (a1,a2)-> a1 > a2 ? a1 : a2)));
        System.out.print(map7);  //prints: {Chicago=24, Denver=25, Boston=25}

        System.out.print("\n8.groupingBy(city, reducing(BinaryOperator): ");
        Map<Boolean, Optional<Person>> map8 = list.stream()
                .collect(Collectors.partitioningBy(p -> p.getGender() == Gender.Male, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map8);  //prints: {false=Optional[Person{name='Jane', city='Denver', gender=Female, age=24}],
                                 //          true=Optional[Person{name='John', city='Denver', gender=Male, age=25}]}

        System.out.print("\n9.groupingBy(city, reducing(Identity, BinaryOperator): ");
        Map<Boolean, Person> map9 = list.stream()
                .collect(Collectors.groupingBy(p -> p.getGender() == Gender.Male, Collectors.reducing(new Person(), BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));
        System.out.print(map9);  //prints: {false=Person{name='Jane', city='Denver', gender=Female, age=24},
                                 //          true=Person{name='John', city='Denver', gender=Male, age=25}}

        System.out.print("\n10.groupingBy(city, reducing(Identity, Function, BinaryOperator): ");
        Map<Boolean, Integer> map10 = list.stream()
                .collect(Collectors.groupingBy(p -> p.getGender() == Gender.Male, Collectors.reducing(0, Person::getAge, (a1,a2)-> a1 > a2 ? a1 : a2)));
        System.out.print(map10);  //prints: {false=24, true=25}
    }

    private static class Person {
        private String name, city;
        private Gender gender;
        private int age;

        public Person(){}

        public Person(String name, String city, Gender gender, int age) {
            this.name = name;
            this.city = city;
            this.gender = gender;
            this.age = age;
        }
        public String getName() { return name; }
        public String getCity() { return city; }
        public Gender getGender() { return gender; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }
    }

    private enum Gender { Male, Female }

}

package com.nick.blog.streams.standard.terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class S42_collect_teeing {
    public static void main(String... args) { // Since Java 12
        List<Person> list = List.of(new Person("John", "Denver", 25),
                                    new Person("Jane", "Denver", 24),
                                    new Person("Bob", "Denver", 23),
                                    new Person("Bill", "Boston", 25),
                                    new Person("Bob", "Chicago", 24),
                                    new Person("Jill", "Boston", 23));

        System.out.print("\n1.teeing(count Denver, count total)   : ");
        List<Long> result1 = list.stream()
            .collect(Collectors.teeing(
                Collectors.filtering(p -> p.getCity().equals("Denver"), Collectors.counting()),
                Collectors.counting(),
                (r1, r2) -> List.of(r1, r2))
            );
        System.out.print(result1);  //prints: [3, 6]

        System.out.print("\n2.teeing(count Denver, count total)   : ");
        Map<String, Long> result2 = list.stream()
            .collect(Collectors.teeing(
                Collectors.filtering(p -> p.getCity().equals("Denver"), Collectors.counting()),
                Collectors.counting(),
                (r1, r2) -> {
                    Map<String, Long> map = new HashMap();
                    map.put("Live in Denver", r1);
                    map.put("Total persons", r2);
                    return map;
                }
            ));
        System.out.print(result2);  //prints: {Live in Denver=3, Total persons=6}

        System.out.print("\n3.teeing(Live in Denver, Persons age 23): ");
        List<List<Person>> result3 = list.stream()
            .collect(Collectors.teeing(
                Collectors.filtering(p -> p.getCity().equals("Denver"), Collectors.toList()),
                Collectors.filtering(p -> 23 == p.getAge(), Collectors.toList()),
                (l1, l2) -> List.of(l1, l2)
            ));
        System.out.println(result3);    //prints: [[Person{name='John', city='Denver', age=25},
                                        //          Person{name='Jane', city='Denver', age=24},
                                        //          Person{name='Bob', city='Denver', age=23}],
                                        //         [Person{name='Bob', city='Denver', age=23},
                                        //          Person{name='Jill', city='Boston', age=23}]]

        System.out.print("\n3.teeing(Live in Denver, Persons age 23): ");
        Map<String, String> result4 = list.stream()
            .collect(Collectors.teeing(
                Collectors.filtering(p -> p.getCity().equals("Denver"), Collectors.toList()),
                Collectors.filtering(p -> 23 == p.getAge(), Collectors.toList()),
                (l1, l2) -> {
                    String s1 = l1.stream().map(p -> p.getName()).collect(Collectors.joining(","));
                    String s2 = l2.stream().map(p -> p.getName()).collect(Collectors.joining(","));
                    Map<String, String> map = new HashMap();
                    map.put("Live in Denver", s1);
                    map.put("Persons age 23", s2);
                    return map;
                }
            ));
        System.out.println(result4);   //prints: {Persons age 23=Bob,Jill, Live in Denver=John,Jane,Bob}
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

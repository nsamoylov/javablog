package com.nick.blog.features.java16;

import java.util.Objects;

/**
 * In addition to being final (not extendable) and immutable,
 * record cannot extend another class because it already extends java.lang.Record,
 * but it can implement another interface as shown in the following example:
 *
 * It is possible to add a static method to a record, as shown in the following code snippet.
 * A static method does not and cannot access instance properties and can utilize only
 * the values passed into it as parameters.
 *
 * As you may have noticed, it is not possible to add another property or a setter to record,
 * while all additional getters have to use only getters provided already by record.
 */
public class Record {
    public static void main(String... args) {
        Person person = new Person(25, "Bill");
        System.out.println(person);  //prints: Person{age=25, name='Bill'}
        System.out.println(person.name());  //prints: Bill

        Person person1 = new Person(25, "Bill");
        System.out.println(person.equals(person1)); //prints: true

        PersonR personR = new PersonR(25, "Bill");
        System.out.println(personR);   //prints: PersonR{age=25, name='Bill'}
        System.out.println(personR.name());      //prints: Bill

        PersonR personR1 = new PersonR(25, "Bill");
        System.out.println(personR.equals(personR1)); //prints: true

        System.out.println(personR.equals(person));   //prints: false
    }

    private record PersonR(int age, String name){}

    private static final class Person{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int age() { return age; }
        public String name() { return name; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private interface Student{
        String getSchoolName();
    }

    private record StudentImpl(String name, String school) implements Student{
        public StudentImpl(String name) {
            this(name, "Unknown");
        }

        @Override
        public String getSchoolName() { return school(); }
    }
}

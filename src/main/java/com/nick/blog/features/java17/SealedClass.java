package com.nick.blog.features.java16;

import java.util.Objects;

public class Record {
    public static void main(String... args) {
        Person person = new Person(25, "Bill", "Smith");
        System.out.println(person);  //prints: Person{age=25, firstName='Bill', lastName='Smith'}
        System.out.println(person.getFirstName());  //prints: Bill

        Person person1 = new Person(25, "Bill", "Smith");
        System.out.println(person.equals(person1)); //prints: true

        PersonR personR = new PersonR(25, "Bill", "Smith");
        System.out.println(personR);   //prints: PersonR{age=25, firstName='Bill', lastName='Smith'}
        System.out.println(personR.firstName());      //prints: Bill

        PersonR personR1 = new PersonR(25, "Bill", "Smith");
        System.out.println(personR.equals(personR1)); //prints: true

        System.out.println(personR.equals(person));   //prints: false
    }

    private record PersonR(int age, String firstName, String lastName){}

    private static final class Person{
        private int age;
        private String firstName, lastName;

        public Person(int age, String firstName, String lastName) {
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int getAge() { return age; }
        public String getLastName() { return lastName; }
        public String getFirstName() { return firstName; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(firstName, person.firstName)
                    && Objects.equals(lastName, person.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, firstName, lastName);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}

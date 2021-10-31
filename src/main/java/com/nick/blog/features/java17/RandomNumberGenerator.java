package com.nick.blog.features.java17;

import java.util.Objects;

public class SealedClass {
    public static void main(String... args) {
    }

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

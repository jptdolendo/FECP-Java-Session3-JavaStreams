package org.example;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}

public class Main {
    // Activity 1
    private static void filterOddNumbers() {
        // Variable declaration
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        // Filter the numbers using isOdd predicate
        List<Integer> filteredNumbers = numbers.stream().filter(isOdd).toList();

        // Print output
        System.out.println("Odd numbers: " + filteredNumbers);
        System.out.println();
    }

    // Activity 2
    private static void filterStringsThatStartsWithA() {
        // Variable declaration
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s -> s.startsWith("A");

        // Filter the names using startsWithA predicate
        List<String> filteredString = names.stream().filter(startsWithA).toList();

        // Print output
        System.out.println("Names starting with A: " + filteredString);
        System.out.println();
    }

    // Activity 3
    private static void squareAllNumbers() {
        // Variable declarations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Map each number to square
        List<Integer> squaredNumbers = numbers.stream().map(n -> n * n).toList();

        // Print output
        System.out.println("Squared numbers: " + squaredNumbers);
        System.out.println();
    }

    // Activity 4
    private static void isEvenAndGreaterThanFive() {
        // Variable declaration
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;
        Predicate<Integer> combined = isEven.and(greaterThanFive);

        // Filter the numbers if they are divisible by two and greater than five
        List<Integer> filteredNumbers = numbers.stream().filter(combined).toList();

        // Print output
        System.out.println("Even and >5: " + filteredNumbers);
        System.out.println();
    }

    public static void main(String[] args) {
        // Call functions
        filterOddNumbers();
        filterStringsThatStartsWithA();
        squareAllNumbers();
        isEvenAndGreaterThanFive();

        // Activity 5
        List<Person> people = Arrays.asList(
                new Person("Cocoy", 25),
                new Person("Jahren", 20),
                new Person("Jan", 29),
                new Person("Echo", 18),
                new Person("Virgil", 22)
        );

        // Sort persons by age ascendingly
       List<Person> sortedbyAgeAscendingly =  people.stream()
               .sorted(Comparator.comparingInt(Person::getAge))
               .toList();

        // Print output
        System.out.println("Sorted by age (ascending):");
        Consumer<Person> printSortedPeopleByAgeAscendingly = System.out::println;
        sortedbyAgeAscendingly.forEach(printSortedPeopleByAgeAscendingly);
        System.out.println();

        // Sort persons by name
        List<Person> sortedByName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();

        // Print output
        System.out.println("Sorted by name:");
        Consumer<Person> printPeopleSortedByName = System.out::println;
        sortedByName.forEach(printPeopleSortedByName);
        System.out.println();

        // Sort persons by age ascendingly
        List<Person> sortedByAgeDescendingly = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .toList();

        // Print output
        System.out.println("Sorted by age (descending):");
        Consumer<Person> printSortedPeopleByAgeDescendingly = System.out::println;
        sortedByAgeDescendingly.forEach(printSortedPeopleByAgeDescendingly);
    }
}
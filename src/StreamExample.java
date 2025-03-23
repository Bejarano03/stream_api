import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class StreamExample {

    public static void main(String[] args) {
        // Task 2: Initialize a list of integers from 1 to 10
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // Task 3: Intermediate Operations
        // Filter out even numbers and print them
        System.out.println("Even Numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // Map the list of numbers to their squares and print the squared values
        System.out.println("\nSquared Values:");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        // Combine filtering and mapping: Filter out odd numbers and map them to their cubes
        System.out.println("\nOdd Numbers Cubed:");
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n * n)
                .forEach(System.out::println);

        // Task 4: Terminal Operations
        // Use the reduce method to sum all the numbers in the list
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("\nSum of All Numbers: " + sum);

        // Use the collect method to gather all even numbers into a new list
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("\nList of Even Numbers: " + evenNumbers);

        // Task 5: Advanced Stream Operations
        // Use the flatMap method to flatten a list of lists into a single list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        System.out.println("\nFlattened List:");
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList);

        // Use the groupingBy collector to group numbers by even and odd
        System.out.println("\nGrouped by Even and Odd:");
        Map<String, List<Integer>> groupedByEvenOdd = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println(groupedByEvenOdd);

        // Task 6: Stream with Custom Objects
        // Create a Person class with fields name and age
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        // Create a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 25),
                new Person("Diana", 35)
        );

        // Use the Stream API to filter out people older than 25 and print their names
        System.out.println("\nPeople Older Than 25:");
        people.stream()
                .filter(person -> person.age > 25)
                .map(person -> person.name)
                .forEach(System.out::println);

        // Use the Stream API to find the oldest person in the list
        System.out.println("\nOldest Person:");
        people.stream()
                .max(Comparator.comparingInt(person -> person.age))
                .ifPresent(System.out::println);
    }
}
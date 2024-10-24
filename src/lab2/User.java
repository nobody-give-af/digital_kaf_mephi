package lab2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;
    public static List<User> sortByLastName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .collect(Collectors.toList());
    }

    public static List<User> sortByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    public static boolean areAllAgesGreaterThan7(List<User> users) {
        return users.stream()
                .allMatch(user -> user.getAge() > 7);
    }

    public static double getAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public static long countDistinctCountries(List<User> users) {
        return users.stream()
                .map(User::getCountry)
                .distinct()
                .count();
    }
}
package hw2;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {

        Student[] studentArray = {
                new Student("Arsen", "Divirov", 60),
                new Student("Niyaz", "Gumerov", 56),
                new Student("Kristina", "Minina", 70),
                new Student("Ilnur", "Sabirov", 55),
                new Student("Ranis", "Murzagildin", 50),
                new Student("Nikita", "Alexeev", 80),
                new Student("Konstantin", "Sherbanev", 80)
        };

        List<Student> studentList = new LinkedList<>(Arrays.asList(studentArray));

        Map<String, Integer> studentMap = new HashMap<>();
        Arrays.stream(studentArray).forEach(st -> studentMap.put(st.getSurname(), st.getMark()));


        //task 16

        System.out.println("С List:");
        studentList.stream().filter(st -> st.getMark() >= 56)
                .forEach(System.out::println);

        System.out.println("С Map:");
        studentMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 56)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


        //task17

        System.out.println("C List:");
        double averagelist = studentList.stream()
                .filter(st -> st.getMark() >= 56)
                .mapToDouble(Student::getMark)
                .average()
                .orElse(0.0);
        System.out.println(averagelist);

        System.out.println("C Map:");
        double averagemap = studentMap.values()
                .stream()
                .filter(v -> v >= 56)
                .mapToDouble(v -> v)
                .average()
                .orElse(0.0);
        System.out.println(averagemap);


        //task18

        System.out.println("C List:");
        String surnamelist = studentList.stream()
                .filter(s -> s.getMark() >= 56)
                .max(Comparator.comparing(Student::getSurname))
                .get()
                .getSurname();
        System.out.println(surnamelist);

        System.out.println("C Map:");
        String surnamemap = studentMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 56)
                .max(Comparator.comparingInt(s -> s.getKey().length()))
                .get()
                .getKey();
        System.out.println(surnamemap);
    }
}

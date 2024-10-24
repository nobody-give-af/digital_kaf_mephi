package lab1;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    // Конструктор
    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }

    // Переопределение метода equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group) &&
                Objects.equals(grades, student.grades);
    }

    // Переопределение метода hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, grades);
    }

    // Метод для удаления студентов с низким средним баллом и перевода на следующий курс
    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getGrades().values().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);

            if (averageGrade < 3) {
                iterator.remove();  // Удаляем студента со средним баллом < 3
            } else {
                student.setCourse(student.getCourse() + 1);  // Переводим на следующий курс
            }
        }
    }

    // Метод для вывода студентов по указанному курсу
    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
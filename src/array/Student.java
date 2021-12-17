package array;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>(20);
        array.addLast(new Student("gsd1", 25));
        array.addLast(new Student("gsd2", 26));
        array.addLast(new Student("gsd3", 27));
        System.out.println(array);
    }
}

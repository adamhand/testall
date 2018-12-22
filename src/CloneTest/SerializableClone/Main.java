package CloneTest.SerializableClone;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        teacher.setAge(50);
        teacher.setName("Bob");

        Student student1 = new Student();
        student1.setAge(15);
        student1.setName("Alice");
        student1.setTeacher(teacher);

        Student student2 = (Student) student1.deepClone();

        System.out.println();
        System.out.println("student2 "+student2.getName());
        System.out.println("student2 "+student2.getAge());
        System.out.println("student2 "+student2.getTeacher().getName());
        System.out.println("student2 "+student2.getTeacher().getAge());

        System.out.println();
        System.out.println("修改老师信息：");
        student1.getTeacher().setName("Job");

        System.out.println("student1 "+student1.getTeacher().getName());
        System.out.println("student2 "+student2.getTeacher().getName());
    }
}

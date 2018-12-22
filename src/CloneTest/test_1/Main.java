package CloneTest.test_1;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setAge(30);
        teacher.setName("Bob");

        Student student1 = new Student();
        student1.setAge(15);
        student1.setName("Alice");
        student1.setTeacher(teacher);

        Student student2 = (Student) student1.clone();
        student2.setAge(16);
        student2.setName("Couche");

        System.out.println("student1 "+student1.getName());
        System.out.println("student1 "+student1.getAge());
        System.out.println("student1 "+student1.getTeacher().getName());
        System.out.println("student1 "+student1.getTeacher().getAge());

        System.out.println();

        System.out.println("student2 "+student2.getName());
        System.out.println("student2 "+student2.getAge());
        System.out.println("student2 "+student2.getTeacher().getName());
        System.out.println("student2 "+student2.getTeacher().getAge());

        student1.getTeacher().setName("Jam");

        System.out.println();
        System.out.println("修改老师信息后：");
        System.out.println("student1 "+student1.getTeacher().getName());
        System.out.println("student2 "+student2.getTeacher().getName());
    }
}

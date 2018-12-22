package CloneTest.test_1;

public class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅复制
//        return super.clone();

        //深复制
        Student student = (Student) super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());

        return student;
    }
}

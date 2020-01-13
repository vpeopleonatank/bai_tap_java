package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class stream {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1,"khai", 6));
        studentList.add(new Student(2,"minh", 8));
        studentList.add(new Student(3,"vuong", 10));
        studentList.add(new Student(3,"duy", 6));
        studentList.add(new Student(3,"long", 7));
        studentList.add(new Student(3,"bac", 9));

        List<Float> studentList1 = studentList.stream()
                .filter(p -> p.diemTb > 7)
                .map(p -> p.diemTb)
                .collect(Collectors.toList());


        studentList1.stream()
                .forEach(diem -> System.out.println(diem));
        float totalDiem = studentList.stream()
                .map(student -> student.diemTb)
                .reduce(0.0f, (sum, diemTb) -> sum+diemTb);
        System.out.println(totalDiem);
        double idSum = studentList.stream()
                .collect(Collectors.summingDouble(s -> s.id));
        System.out.println(idSum);
        Student maxStudent = studentList.stream()
                .max((s1, s2) ->
                        s1.diemTb > s2.diemTb ? 1 : -1).get();
        System.out.println(maxStudent);
        long countStudent = studentList.stream()
                .filter(student -> student.diemTb < 7)
                .count();
        System.out.println(countStudent);
//
        Map<Integer, String> studentMap = studentList.stream()
                .filter(s -> s.id < 3)
                .collect(Collectors.toMap(s -> s.id , s -> s.hoTen));
        System.out.println(studentList);

        // method reference
        List<Float> diemTbStudent = studentList.stream()
                .filter(s -> s.diemTb >6)
                .   map(Student::getDiemTb)
                .collect(Collectors.toList());
        System.out.println(diemTbStudent);
    }
}
class Student {
    int id;
    String hoTen;
    float diemTb;
    public Student(int id, String hoTen, float diemTb) {
        this.id = id;
        this.hoTen = hoTen;
        this.diemTb = diemTb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiemTb(float diemTb) {
        this.diemTb = diemTb;
    }

    public int getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public float getDiemTb() {
        return diemTb;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", diemTb=" + diemTb +
                '}';
    }
}
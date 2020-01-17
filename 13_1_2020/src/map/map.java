package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;



public class map {
    public static void main(String[] args) {
        Map<Integer, Student> hashMap = new HashMap<Integer, Student>();
        Student s1 = new Student(1, "khai", 4);
        Student s2 = new Student(2, "quang", 9);
        Student s3 = new Student(3, "long", 8);
        hashMap.put(1, s1);
        hashMap.put(2, s2);
        hashMap.put(3, s3);

        for(Map.Entry entry:hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        if (hashMap.containsKey(1)) {
            System.out.println("chua key 1");
        }

        TreeMap<Integer, Student> treeMap = new TreeMap<Integer, Student>();
        treeMap.put(1,s1);
        treeMap.put(2,s2);
        treeMap.put(3,s3);
        for (Map.Entry entry:treeMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
class Student {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Float.compare(student.diemTb, diemTb) == 0 &&
                Objects.equals(hoTen, student.hoTen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hoTen, diemTb);
    }

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
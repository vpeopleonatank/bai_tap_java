package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        List<Student> students = new ArrayList<>(10);
        students.add(new Student("a", 2));
        students.add(new Student("a", 2));
        students.add(new Student("n", 6));
        students.add(new Student("k", 5));
        students.add(new Student("l", 7));
        students.add(new Student("i", 8));
        students.add(new Student("u", 9));
        students.add(new Student("w", 0));
        students.add(new Student("r", 2));
        students.add(new Student("s", 2));
        students.add(new Student("o", 2));

        Collections.sort(students, new NameComparator());
        // Show list student
        for (Student student : students) {
            System.out.println(student);
        }
        Student keyName = new Student("a", 2);
        int index = Collections.binarySearch(students, new Student("a", 2), new NameComparator());
        System.out.println(index);
        System.out.println(students.get(index));
        for (int i = index - 1; i >= 0; i--) {
            Student student = students.get(i);
            if (student.Hoten.equals(keyName.Hoten)) {
                System.out.println(student);
            } else
                break;
        }
        int current = index + 1;
        Student currStudent = students.get(current);
        while (current < students.size() && currStudent.Hoten.equals(keyName.Hoten)) {
            System.out.println(currStudent);
            current++;
            currStudent = students.get(current);
        }

        Collections.sort(students, new DiemComparator());
        System.out.println("Sort by diemtb");

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Student keyDiem = new Student("a", 2);
        index = Collections.binarySearch(students, keyDiem, new DiemComparator());
        keyDiem = students.get(index);
        System.out.println(index);
        System.out.println(keyDiem);
        for (int i = index - 1; i >= 0; i--) {
            Student student = students.get(i);
            if (student.Diemtb == keyDiem.Diemtb) {
                System.out.println(student);
            } else
                break;
        }

        current = index + 1;
        currStudent = students.get(current);
        while (current < students.size() && currStudent.Diemtb == keyDiem.Diemtb) {
            System.out.println(currStudent);
            current++;
        }

    }
}
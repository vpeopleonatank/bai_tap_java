package app;

import java.util.Comparator;

class DiemComparator implements Comparator<Student> {
  public int compare(Student o1, Student o2) {
    if (o1.Diemtb == o2.Diemtb) {
      return 0;
    } else if (o1.Diemtb > o2.Diemtb) {
      return 1;
    } else
      return -1;
  }
}
package app;

public class Student {
  protected String Hoten;
  protected float Diemtb;

  public String getHoten() {
    return Hoten;
  }

  public void setHoten(String hoten) {
    Hoten = hoten;
  }

  public float getDiemtb() {
    return Diemtb;
  }

  public void setDiemtb(float diemtb) {
    Diemtb = diemtb;
  }

  public Student(String hoten, float diemtb) {
    Hoten = hoten;
    Diemtb = diemtb;
  }

  @Override
  public String toString() {
    return "Student [diem=" + Diemtb + ", ten=" + Hoten + "]";
  }
}
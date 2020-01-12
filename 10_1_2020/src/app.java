import java.util.*;

public class app {
    public static void main(String[] args) {
        Student st = new Student("Bn", 3.5f);
        int result = st.hashCode();
        System.out.println("Hash Code Value= " + result);

        HashSet<Student> set=new HashSet();
        set.add(new Student("Nguyen Van An", 2));
        set.add(new Student("Nguyen Van An", 2)); //Không lưu giá trị trùng
        set.add(new Student("AVo Huy Hoang", 2));
        set.add(new Student("ANguyen Thanh", 6));
        set.add(new Student("Nhan Nhan", 5));
        set.add(new Student("Lu Thai Hoc", 6));
        set.add(new Student("Nguyen Van E", 8));
        set.add(new Student("CVo Thi Hong", 9));
        set.add(new Student("Van Thi Thanh Thao", 0));
        set.add(new Student("Nguyen Thi An", 2));
        set.add(new Student("Vo Thien Bao", 2));


        System.out.println(set.size());
        //In ra
        Iterator<Student> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        Student s1 = new Student("Vo Thien Bao", 2);
        Student s2 = new Student("Vo Minh", 2);
        if (s1.equals(s2)){
            System.out.println("Bang diem nhau");
        }

        PriorityQueue<String> pQueue = new PriorityQueue<>(Comparator.comparing(String::toString).reversed());

        // Adding items to the pQueue using add()
        pQueue.add("A");
        pQueue.add("G");
        pQueue.add("D");
        pQueue.add("J");

        System.out.println(pQueue);
    }
}

class Student {
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

    @Override
    public int hashCode(){
//    return (int)(this.Diemtb);  
        System.out.println("This function runned!" + this.Hoten.charAt(0));
        return (this.Hoten.charAt(0));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.Diemtb) != Float.floatToIntBits(other.Diemtb)) {
            return false;
        }
        return true;
//        return Objects.equals(this.Hoten, other.Hoten);
    }

}
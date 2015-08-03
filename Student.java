/**
 * Created by guillermo on 3/4/15.
 */
public class Student extends Person{


    public Student(String n) {
        super(n);
    }

    public String toString() {
        return "Name is: " + name;
    }

//    public boolean equals(Object obj) {
//        Student tmp = (Student) obj;
//        return name.compareTo(tmp.name)==0;
//    }

//    public int compareTo(Student s) {
//        return name.compareTo(s.name);
//    }
//
//
//    public int compareTo(String s) {
//        return name.compareTo(s);
//    }
}

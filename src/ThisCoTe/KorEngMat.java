package ThisCoTe;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    private String name;
    private int kor;
    private int eng;
    private int mat;

    public Student(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        if(o.kor==this.kor && o.eng==this.eng && o.mat==this.mat){
            return this.name.compareTo(o.name);
        }
        if(o.kor==this.kor && o.eng==this.eng){
            return Integer.compare(o.mat,this.mat);
        }
        if(o.kor==this.kor){
            return Integer.compare(this.eng,o.eng);
        }
        return Integer.compare(o.kor,this.kor);
    }
}

public class KorEngMat {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for(int i=0; i<n; i++){
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int mat = sc.nextInt();
            students.add(new Student(name, kor,eng,mat));
        }
        sc.close();
        Collections.sort(students);

        for(int i=0; i<n; i++){
            System.out.println(students.get(i).getName());
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        System.out.println("enter a student fullname");
        String name= sc.nextLine();

        System.out.println("enter the student id");
        Integer id= sc.nextInt();
        Student newStudent= new Student(id,name);

        Course Math= new Course(101,"Math",3);
        Course Physics= new Course(102,"Physics",4);
        Course Chemistry= new Course(103,"Chemistry",3);
        Course Biology= new Course(104,"Biology",4);

        System.out.println("enter the course id that you want to reigster for");

    }
}
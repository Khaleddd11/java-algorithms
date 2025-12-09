import java.util.ArrayList;

public class Student implements RegistrationActions{
    private Integer studentId;
    private String fullName;
    private ArrayList<CourseRegistration> registrations;

    public Student(Integer studentId,String fullName){
        this.studentId=studentId;
        this.fullName=fullName;
        this.registrations = new ArrayList<>();
    }
    @Override
    public void registerCourse(Course course, Double grade){
        registrations.add(new CourseRegistration(course,grade));
    }
    
    public void printReport(){
        StringBuilder sb = new StringBuilder("");
        for (int i =0 ;i<registrations.size();i++){

            sb.append("the course is; " +registrations.get(i).course.getCourseName() + 
            "and the grade is: " + registrations.get(i).grade + "\n");
            
    }
    System.out.println(sb.toString());
        }
    int getStudentId(){
        return studentId;
    }
    String getName(){
        return fullName;
    }
    ArrayList<CourseRegistration> getRegistrations() {
       return registrations;

    }

    

    public class CourseRegistration{
        Course course; // → The course that the student took.
		Double grade; //→ The student’s grade in that course.

        CourseRegistration(Course course, Double grade){
            this.course= course;
            this.grade=grade;
        }
        Course getCourse(){
            return course;
        }
        Double getGrade(){
            return grade;
    }
}
}
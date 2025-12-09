public class Course{
    private Integer courseId;
    private String courseName;
    private Integer creditHours;

Course(int courseId, String courseName, int creditHours){
        this.courseId=courseId;
        this.courseName=courseName;
        this.creditHours=creditHours;
    }


    Integer getCourseId(){
        return courseId;
    }
    String getCourseName(){
        return courseName;
    }
    Integer getCreditHours(){
        return creditHours;
    }

}
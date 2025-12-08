public class Course{
    int courseId;
    String courseName;
    int creditHours;

Course(int courseId, String courseName, int creditHours){
        this.courseId=courseId;
        this.courseName=courseName;
        this.creditHours=creditHours;
    }


    Course getCourseId(){
        return courseId;
    }
    Course getCourseName(){
        return courseName;
    }
    Course getCreditHours(){
        return creditHours;
    }

}
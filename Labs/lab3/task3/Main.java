import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        
        // Create some courses
        courses.add(new Course(101, "Object-Oriented Programming", 3));
        courses.add(new Course(102, "Data Structures", 4));
        courses.add(new Course(103, "Database Systems", 3));
        courses.add(new Course(104, "Web Development", 3));
        
        System.out.println("=== Student Registration System ===\n");
        
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Register Student for Courses");
            System.out.println("3. Print Student Report");
            System.out.println("4. Print All Students");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine(); // clear invalid input
                continue;
            }
            
            switch (choice) {
                case 1:
                    // Add Student with validation
                    try {
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Validate ID is positive
                        if (id <= 0) {
                            System.out.println("Error: Student ID must be positive!");
                            break;
                        }
                        
                        // Check for duplicate ID
                        if (findStudent(students, id) != null) {
                            System.out.println("Error: Student with ID " + id + " already exists!");
                            break;
                        }
                        
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine().trim();
                        
                        // Validate name is not empty
                        if (name.isEmpty()) {
                            System.out.println("Error: Student name cannot be empty!");
                            break;
                        }
                        
                        students.add(new Student(id, name));
                        System.out.println("Student added successfully!");
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input! Please enter a number for ID.");
                        scanner.nextLine(); // clear invalid input
                    }
                    break;
                    
                case 2:
                    // Register for courses with validation
                    try {
                        System.out.print("Enter Student ID: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        
                        Student student = findStudent(students, studentId);
                        if (student == null) {
                            System.out.println("Error: Student not found!");
                            break;
                        }
                        
                        // Display available courses
                        System.out.println("\nAvailable Courses:");
                        for (int i = 0; i < courses.size(); i++) {
                            Course c = courses.get(i);
                            System.out.println(c.getCourseId() + ". " + c.getCourseName() + 
                                             " (" + c.getCreditHours() + " credits)");
                        }
                        
                        // Use StringTokenizer for multiple course input
                        System.out.println("\nEnter course IDs separated by commas (e.g., 101,102,103): ");
                        String courseInput = scanner.nextLine().trim();
                        
                        // Validate input is not empty
                        if (courseInput.isEmpty()) {
                            System.out.println("Error: Please enter at least one course ID!");
                            break;
                        }
                        
                        //StringTokenizer that splits "101, 103, 220" into tokens:"101","102"
                        StringTokenizer st = new StringTokenizer(courseInput, ",");
                        
                        while (st.hasMoreTokens()) {
                            try {
                                String token = st.nextToken().trim();
                                int courseId = Integer.parseInt(token); //Converts "101" → 101 
                                Course course = findCourse(courses, courseId);
                                
                                if (course == null) {
                                    System.out.println("Error: Course ID " + courseId + " not found! Skipping...");
                                    continue;
                                }
                                
                                // Check if student already registered for this course
                                if (isAlreadyRegistered(student, courseId)) {
                                    System.out.println("Warning: Already registered for " + course.getCourseName() + "! Skipping...");
                                    continue;
                                }
                                
                                System.out.print("Enter grade for " + course.getCourseName() + " (0-100): ");
                                double grade = scanner.nextDouble();
                                scanner.nextLine();
                                
                                // Validate grade range
                                if (grade < 0 || grade > 100) {
                                    System.out.println("Error: Grade must be between 0 and 100! Skipping this course...");
                                    continue;
                                }
                                
                                student.registerCourse(course, grade);
                                System.out.println("Successfully registered for " + course.getCourseName());
                                
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Invalid course ID format! Skipping...");
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Invalid grade input! Skipping this course...");
                                scanner.nextLine(); // clear invalid input
                            }
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input for student ID!");
                        scanner.nextLine(); // clear invalid input
                    }
                    break;
                    
                case 3:
                    // Print student report with validation
                    try {
                        System.out.print("Enter Student ID: ");
                        int reportId = scanner.nextInt();
                        scanner.nextLine();
                        
                        Student reportStudent = findStudent(students, reportId);
                        
                        if (reportStudent != null) {
                            reportStudent.printReport();
                        } else {
                            System.out.println("Error: Student not found!");
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input! Please enter a number.");
                        scanner.nextLine(); // clear invalid input
                    }
                    break;
                    
                case 4:
                    // Print all students
                    if (students.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        System.out.println("\n=== All Students ===");
                        for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);
                            System.out.println("ID: " + s.getStudentId() + ", Name: " + s.getName());
                        }
                    }
                    break;
                    
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }
        }
        
        scanner.close();
    }
    
    // Helper method to find student by ID
    private static Student findStudent(ArrayList<Student> students, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                return students.get(i);
            }
        }
        return null;
    }
    
    // Helper method to find course by ID
    private static Course findCourse(ArrayList<Course> courses, int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == id) {
                return courses.get(i);
            }
        }
        return null;
    }
    
    // Helper method to check if student already registered for a course
    private static boolean isAlreadyRegistered(Student student, int courseId) {
        ArrayList<Student.CourseRegistration> registrations = student.getRegistrations();
        for (int i = 0; i < registrations.size(); i++) {
            if (registrations.get(i).getCourse().getCourseId() == courseId) {
                return true;
            }
        }
        return false;
    }
}
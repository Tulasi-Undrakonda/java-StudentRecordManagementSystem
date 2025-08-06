import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: running = false; System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        
        Student student = new Student(nextId++, name, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        System.out.println("\nList of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student studentToUpdate = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToUpdate = student;
                break;
            }
        }
        
        if (studentToUpdate == null) {
            System.out.println("Student not found with ID: " + id);
            return;
        }
        
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            studentToUpdate.setName(newName);
        }
        
        System.out.print("Enter new marks (enter -1 to keep current): ");
        double newMarks = scanner.nextDouble();
        if (newMarks != -1) {
            studentToUpdate.setMarks(newMarks);
        }
        
        System.out.println("Student updated successfully!");
    }
    
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}
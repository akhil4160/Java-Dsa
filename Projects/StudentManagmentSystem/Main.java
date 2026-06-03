import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        int choice;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Roll Number: ");
                int rollNo = sc.nextInt();

                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Enter Branch: ");
                String branch = sc.next();

                if (manager.studentExists(rollNo)) {
                    System.out.println("Roll Number Already Exists");

                } else {

                    Student s1 = new Student(rollNo, name, branch);
                    manager.addStudent(s1);

                }
            } else if (choice == 2) {
                manager.displayStudents();
            } else if (choice == 3) {
                System.out.print("Enter roll: ");
                int rollNo = sc.nextInt();
                manager.searchStudent(rollNo);

            } else if (choice == 4) {
                System.out.print("Enter roll: ");
                int rollNo = sc.nextInt();
                manager.delete(rollNo);

            } else if (choice == 5) {
                System.out.print("Enter roll: ");
                int rollNo = sc.nextInt();
                System.out.println("Enter new name");
                String newName = sc.next();
                System.out.println("Enter new branch");
                String newBranch = sc.next();
                manager.update(rollNo, newName, newBranch);

            } else if (choice == 6) {
                System.out.println("Thank You!");
                break;
            }
        }
    }

}